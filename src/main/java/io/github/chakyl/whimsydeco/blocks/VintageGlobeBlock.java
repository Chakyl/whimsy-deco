package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blockentities.CowbellBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.VintageGlobeBlockEntity;
import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VintageGlobeBlock extends RotatingBlock implements EntityBlock {
    public static final VoxelShape SHAPE = Shapes.or(box(4, 8, 4, 12, 16, 12), box(0, 0, 0, 16, 8, 16));

    public VintageGlobeBlock(Properties props) {
        super(props, RotatingBlock.createShapeBuilder(SHAPE));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new VintageGlobeBlockEntity(pPos, pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity entity = pLevel.getBlockEntity(pPos);
        if (entity instanceof VintageGlobeBlockEntity) {
            ((VintageGlobeBlockEntity) entity).stopTriggeredAnimation("controller", "spin");
            ((VintageGlobeBlockEntity) entity).triggerAnim("controller", "spin");
            pLevel.playSound((Player)null, pPos, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 0.2F, 1.0F);
        }
        return InteractionResult.SUCCESS;
    }
}