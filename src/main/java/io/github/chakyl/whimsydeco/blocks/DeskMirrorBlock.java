package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DeskMirrorBlock extends RotatingBlock {
    public static final VoxelShape SHAPE = box(1, 0, 4, 15, 16, 12);


    public DeskMirrorBlock(Properties props) {
        super(props, createShapeBuilder(SHAPE));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, WATERLOGGED);
    }

}