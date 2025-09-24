package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingTallBlock;
import io.github.chakyl.whimsydeco.util.ShapeBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BroomBlock extends RotatingTallBlock {
    public static final VoxelShape SHAPE = box(2, 0, 2, 14, 16, 14);

    public static final BooleanProperty LEANING = BooleanProperty.create("leaning");

    public BroomBlock(Properties props) {
        super(props, createShapeBuilder());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LEANING, false).setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LEANING, HALF, WATERLOGGED);
    }

    public static ShapeBuilder createShapeBuilder() {
        return blockState -> {
            return SHAPE;
        };
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClientSide) return;
        boolean isLeaning = state.getValue(LEANING);
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            if (world.getBlockState(pos.below()).getBlock() == state.getBlock())
                isLeaning = world.getBlockState(pos.below()).getValue(LEANING);
        } else {
            if (world.getBlockState(pos.above()).getBlock() == state.getBlock())
                isLeaning = world.getBlockState(pos.above()).getValue(LEANING);
        }
        world.setBlock(pos, state.setValue(LEANING, isLeaning), 3);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pLevel.setBlockAndUpdate(pPos, pState.setValue(LEANING, !pState.getValue(LEANING)));
        return InteractionResult.SUCCESS;
    }

}