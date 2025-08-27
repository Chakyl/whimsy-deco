package io.github.chakyl.whimsydeco.blocks.bases;

import io.github.chakyl.whimsydeco.util.ShapeBuilder;
import io.github.chakyl.whimsydeco.util.ShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skyjay1
 * [https://github.com/skyjay1/Tanuki-Decor/blob/main-1.20.1/src/main/java/tanukidecor/block/RotatingBlock.java]
 * Used with permission under the GNU LGPLv3 license
 */
public class RotatingBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected final Map<BlockState, VoxelShape> blockShapes = new HashMap<>();
    protected final ShapeBuilder shapeBuilder;

    public RotatingBlock(Properties pProperties, ShapeBuilder shapeBuilder) {
        super(pProperties);
        this.shapeBuilder = shapeBuilder;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
        precalculateShapes();
    }

    //// METHODS ////

    protected void precalculateShapes() {
        blockShapes.clear();
        for(BlockState blockState : this.stateDefinition.getPossibleStates()) {
            blockShapes.put(blockState, this.shapeBuilder.apply(blockState));
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return blockShapes.get(pState);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        boolean waterlogged = fluidstate.getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, waterlogged);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING).add(WATERLOGGED);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
        if(pLevel.getBlockState(pCurrentPos).is(this) && !pState.canSurvive(pLevel, pCurrentPos)) {
            pLevel.destroyBlock(pCurrentPos, true);
            return pState.getFluidState().createLegacyBlock();
        }
        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    public static ShapeBuilder createShapeBuilder(final VoxelShape shape) {
        return blockState -> {
            final Direction facing =  blockState.getValue(FACING);
            return ShapeUtils.rotateShape(Direction.NORTH, facing, shape);
        };
    }

    //// HELPER METHODS ////

    /**
     * @param context the block place context
     * @return the {@link BlockState} of the block only if it was placed against a horizontal face
     */
    @Nullable
    public BlockState getStateForWallPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean waterlogged = fluidstate.getType() == Fluids.WATER;
        if (context.getClickedFace().getAxis() != Direction.Axis.Y) {
            return this.defaultBlockState()
                    .setValue(FACING, context.getClickedFace())
                    .setValue(WATERLOGGED, waterlogged);
        } else {
            return null;
        }
    }

    /**
     * @param state the block state
     * @param level the level
     * @param pos the block position
     * @return true if the block behind this one has a solid face
     * @see BlockState#isFaceSturdy(BlockGetter, BlockPos, Direction)
     */
    public boolean canSurviveOnWall(BlockState state, LevelReader level, BlockPos pos) {
        final Direction facing = state.getValue(FACING);
        final BlockPos supportingPos = pos.relative(facing.getOpposite());
        final BlockState supportingState = level.getBlockState(supportingPos);
        return supportingState.isFaceSturdy(level, supportingPos, facing);
    }
}