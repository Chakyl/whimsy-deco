package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blockentities.GoldLuckyCatBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.LuckyCatBlockEntity;
import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GoldLuckyCatBlock extends RotatingBlock implements EntityBlock {

    public static final VoxelShape SHAPE =  box(0, 0, 0, 16, 16, 16);

    public GoldLuckyCatBlock(Properties props) {
        super(props, RotatingBlock.createShapeBuilder(SHAPE));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new GoldLuckyCatBlockEntity(pPos, pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

}