package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blockentities.CowbellBlockEntity;
import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BellBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CowbellBlock extends RotatingBlock implements EntityBlock {

    public static final VoxelShape SHAPE =  box(3, 6, 5, 13, 16, 11);

    public CowbellBlock(Properties props) {
        super(props, RotatingBlock.createShapeBuilder(SHAPE));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CowbellBlockEntity(pPos, pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity entity = pLevel.getBlockEntity(pPos);
        if (entity instanceof CowbellBlockEntity) {

            ((CowbellBlockEntity) entity).stopTriggeredAnimation("controller", "bell");
            ((CowbellBlockEntity) entity).triggerAnim("controller", "bell");
            pLevel.playSound((Player)null, pPos, SoundEvents.BELL_BLOCK, SoundSource.BLOCKS, 2.0F, 1.0F);
        }
        return InteractionResult.SUCCESS;
    }
}