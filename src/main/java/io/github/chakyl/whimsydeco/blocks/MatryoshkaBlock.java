package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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

public class MatryoshkaBlock extends RotatingBlock {
    public static final VoxelShape SHAPE = box(1, 0, 1, 15, 11, 15);

    public static final IntegerProperty TYPE = IntegerProperty.create("type", 0, 3);

    public MatryoshkaBlock(Properties props) {
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
            int type = pState.getValue(TYPE);
            if (pPlayer.isCrouching() && type > 0) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(TYPE, type - 1));
                pLevel.playSound(pPlayer, pPos, SoundEvents.CHICKEN_EGG, SoundSource.BLOCKS, 0.5F, 1.0F - ((type - 1) * 0.25F));
            } else if (!pPlayer.isCrouching() && type < 3) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(TYPE, type + 1));
                pLevel.playSound(pPlayer, pPos, SoundEvents.CHICKEN_EGG, SoundSource.BLOCKS, 0.5F, 1.0F + (type * 0.25F));
            }
        }
        return InteractionResult.SUCCESS;
    }

}