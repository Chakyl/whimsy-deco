package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StockingBlock extends RotatingBlock {
    public static final VoxelShape SHAPE = box(0, 0, 14,16, 16, 16);


    public StockingBlock(Properties props) {
        super(props, createShapeBuilder(SHAPE));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForWallPlacement(pContext);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return super.canSurviveOnWall(pState,pLevel,pPos);
    }
}