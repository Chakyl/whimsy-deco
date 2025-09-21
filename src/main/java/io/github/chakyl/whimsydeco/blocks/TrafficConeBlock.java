package io.github.chakyl.whimsydeco.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TrafficConeBlock extends Block {
    public static final VoxelShape SHAPE = box(1, 0, 1, 15, 16, 15);


    public TrafficConeBlock(Properties props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

}