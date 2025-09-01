package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import io.github.chakyl.whimsydeco.util.ShapeBuilder;
import io.github.chakyl.whimsydeco.util.ShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PhoneBlock extends RotatingBlock {
    public static final VoxelShape SHAPE = Shapes.or(
            box(2, 0, 3, 14, 3, 16),
            box(11, 3, 3, 14, 5, 16));
    public static final VoxelShape SHAPE_WALL = Shapes.or(
            box(2, 3, 13, 14, 16, 16),
            box(11, 3, 11, 14, 16, 13));

    public static final BooleanProperty WALL = BooleanProperty.create("wall");

    public PhoneBlock(Properties props) {
        super(props, createShapeBuilder(SHAPE));
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

    public static ShapeBuilder createShapeBuilder(final VoxelShape shape) {
        return blockState -> {
            final Boolean flying = blockState.getValue(WALL);
            final Direction facing = blockState.getValue(FACING);
            return flying ? ShapeUtils.rotateShape(Direction.NORTH, facing, SHAPE_WALL) : ShapeUtils.rotateShape(Direction.NORTH, facing, SHAPE);
        };
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pLevel.setBlockAndUpdate(pPos, pState.setValue(WALL, !pState.getValue(WALL)));
        return InteractionResult.SUCCESS;
    }
}