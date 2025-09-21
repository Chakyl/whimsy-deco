package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DuckBlock extends RotatingBlock {
    public static final VoxelShape SHAPE = box(4, 0, 4, 12, 6, 14);


    public DuckBlock(Properties props) {
        super(props, createShapeBuilder(SHAPE));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, WATERLOGGED);
    }

}