package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.ChairBlock;
import io.github.chakyl.whimsydeco.util.WhimsyEnums;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
/**
 * @author satisfyu
 *
 * Logic for connecting Sofas, cleaned up for this use case
 * [https://github.com/Let-s-Do-Collection/Furniture/blob/main/common/src/main/java/com/berksire/furniture/block/LineConnectingBlock.java]
 * Used with permission under the MIT license
 */
public class SofaBlock extends ChairBlock {
    public static final EnumProperty<WhimsyEnums.SofaType> TYPE = WhimsyEnums.SOFA_TYPE;
    public static final VoxelShape SHAPE = box(0, 0, 0, 16, 16, 16);

    public SofaBlock(Properties pProperties) {
        super(SHAPE, 0.7D, pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TYPE, WhimsyEnums.SofaType.DISLAY).setValue(WATERLOGGED, false));
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClientSide) return;

        Direction facing = state.getValue(FACING);
        WhimsyEnums.SofaType type;
        switch (facing) {
            case EAST -> type = getType(state, world.getBlockState(pos.south()), world.getBlockState(pos.north()));
            case SOUTH -> type = getType(state, world.getBlockState(pos.west()), world.getBlockState(pos.east()));
            case WEST -> type = getType(state, world.getBlockState(pos.north()), world.getBlockState(pos.south()));
            default -> type = getType(state, world.getBlockState(pos.east()), world.getBlockState(pos.west()));
        }
        if (state.getValue(TYPE) != type) {
            state = state.setValue(TYPE, type);
        }
        world.setBlock(pos, state, 3);
    }

    public WhimsyEnums.SofaType getType(BlockState state, BlockState left, BlockState right) {
        boolean connectLeft = isConnectable(left, state);
        boolean connectRight = isConnectable(right, state);

        if (connectLeft && connectRight) {
            return WhimsyEnums.SofaType.MIDDLE;
        } else if (connectLeft) {
            return WhimsyEnums.SofaType.LEFT;
        } else if (connectRight) {
            return WhimsyEnums.SofaType.RIGHT;
        }
        return WhimsyEnums.SofaType.DISLAY;
    }

    protected boolean isConnectable(BlockState state1, BlockState state2) {
        return state1.getBlock() == state2.getBlock() && state1.getValue(FACING) == state2.getValue(FACING);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, TYPE, WATERLOGGED);
    }

}
