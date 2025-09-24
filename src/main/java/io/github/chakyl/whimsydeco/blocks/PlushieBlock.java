package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PlushieBlock extends RotatingBlock {

    public static final VoxelShape SHAPE = box(4, 0, 4, 12, 11, 12);

    public PlushieBlock(Properties props) {
        super(props, RotatingBlock.createShapeBuilder(SHAPE));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pLevel.playSound((Player) null, pPlayer.getOnPos(), WhimsyRegistry.SoundRegistry.SQUEAK.get(), SoundSource.BLOCKS, 1F, 1.0F);
        return InteractionResult.SUCCESS;
    }

}