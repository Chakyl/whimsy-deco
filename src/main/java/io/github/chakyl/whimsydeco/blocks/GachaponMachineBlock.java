package io.github.chakyl.whimsydeco.blocks;


import io.github.chakyl.whimsydeco.blocks.bases.RotatingTallBlock;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import io.github.chakyl.whimsydeco.tags.WhimsyItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GachaponMachineBlock extends RotatingTallBlock {
    public static final VoxelShape SHAPE_UPPER = box(0, 0, 0, 16, 11, 16);
    public static final VoxelShape SHAPE_LOWER = box(0, 0, 0, 16, 16, 16);

    public GachaponMachineBlock(Properties pProperties) {
        super(pProperties, RotatingTallBlock.createShapeBuilder(SHAPE_UPPER, SHAPE_LOWER));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pHand == InteractionHand.MAIN_HAND && pPlayer.getItemInHand(pHand).is(WhimsyItemTags.GATCHA_MACHINE_ACCEPTS)) {
            pLevel.playSound((Player) null, pPlayer.getOnPos(), WhimsyRegistry.SoundRegistry.KACHING.get(), SoundSource.BLOCKS, 0.5F, 1.0F);
            if (!pLevel.isClientSide()) {
                if (!pPlayer.isCreative()) pPlayer.getItemInHand(pHand).shrink(1);
                Block.popResourceFromFace(pLevel, pPos, pState.getValue(FACING), WhimsyRegistry.ItemRegistry.GATCHA_CAPSULE.get().getDefaultInstance().copy());
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

}