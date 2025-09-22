package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GnomeBlock extends RotatingBlock {
    public static final VoxelShape SHAPE = box(0, 0, 0, 16, 16, 16);

    public static final IntegerProperty TYPE = IntegerProperty.create("type", 0, 3);

    public GnomeBlock(Properties props) {
        super(props, createShapeBuilder(SHAPE));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TYPE, 0).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, TYPE, WATERLOGGED);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pHand == InteractionHand.MAIN_HAND) {
            if (pPlayer.getItemInHand(pHand) == Items.LANTERN.getDefaultInstance()) {
                pLevel.setBlockAndUpdate(pPos, WhimsyRegistry.BlockRegistry.LANTERN_GNOME.get().defaultBlockState());
                pPlayer.getItemInHand(pHand).shrink(1);
            } else {

                int type = pState.getValue(TYPE);
                pLevel.setBlockAndUpdate(pPos, pState.setValue(TYPE, type == 3 ? 0 : type + 1));
            }
        }
        return InteractionResult.SUCCESS;
    }

}