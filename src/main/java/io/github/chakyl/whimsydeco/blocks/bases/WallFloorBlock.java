package io.github.chakyl.whimsydeco.blocks.bases;

import io.github.chakyl.whimsydeco.util.ShapeBuilder;
import io.github.chakyl.whimsydeco.util.ShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WallFloorBlock extends RotatingBlock {
    public static final BooleanProperty WALL = BooleanProperty.create("wall");

    public WallFloorBlock(Properties props, ShapeBuilder shapeBuilder) {
        super(props, shapeBuilder);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WALL, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, WALL, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        if (pContext.getClickedFace().getAxis() != Direction.Axis.Y) {
            return getStateForWallPlacement(pContext).setValue(WALL, true);
        } else {
            return super.getStateForPlacement(pContext);
        }
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return !pState.getValue(WALL) || canSurviveOnWall(pState, pLevel, pPos);
    }

}