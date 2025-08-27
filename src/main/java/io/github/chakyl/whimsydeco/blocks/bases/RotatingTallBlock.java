package io.github.chakyl.whimsydeco.blocks.bases;

import io.github.chakyl.whimsydeco.blocks.providers.IDelegateProvider;
import io.github.chakyl.whimsydeco.util.MultiblockHandler;
import io.github.chakyl.whimsydeco.util.ShapeBuilder;
import io.github.chakyl.whimsydeco.util.ShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
/**
 * @author skyjay1
 * [https://github.com/skyjay1/Tanuki-Decor/blob/main-1.20.1/src/main/java/tanukidecor/block/RotatingTallBlock.java]
 * Used with permission under the GNU LGPLv3 license
 */
public class RotatingTallBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock, IDelegateProvider {

    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected final ShapeBuilder shapeBuilder;
    protected final Map<BlockState, VoxelShape> blockShapes = new HashMap<>();
    protected final Map<BlockState, VoxelShape> multiblockShapes = new HashMap<>();

    public RotatingTallBlock(Properties pProperties, ShapeBuilder shapeBuilder) {
        super(pProperties);
        this.shapeBuilder = shapeBuilder;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(HALF, DoubleBlockHalf.LOWER));
        precalculateShapes();
    }

    //// SHAPE ////

    protected void precalculateShapes() {
        blockShapes.clear();
        multiblockShapes.clear();
        // create double block shape
        final Map<Direction, VoxelShape> doubleBlockShapes = new EnumMap<>(Direction.class);
        doubleBlockShapes.putAll(ShapeUtils.rotateShapes(MultiblockHandler.ORIGIN_DIRECTION, createDoubleBlockShape()));
        // create shapes for all possible block states
        for(BlockState blockState : this.stateDefinition.getPossibleStates()) {
            // calculate block shape
            blockShapes.put(blockState, this.shapeBuilder.apply(blockState));
            // calculate multiblock shape
            double offset = blockState.getValue(HALF) == DoubleBlockHalf.UPPER ? 0 : 1;
            VoxelShape shape = doubleBlockShapes.get(blockState.getValue(FACING))
                    .move(0, offset, 0);
            multiblockShapes.put(blockState, shape);
        }
    }

    /**
     * @return a newly created multiblock {@link VoxelShape}, centered around the center block
     */
    protected VoxelShape createDoubleBlockShape() {
        BlockState upperState = defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER);
        BlockState lowerState = defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
        return Shapes.or(
                blockShapes.computeIfAbsent(upperState, this.shapeBuilder),
                blockShapes.computeIfAbsent(lowerState, this.shapeBuilder).move(0, -1, 0));
    }

    /**
     * @param blockState the block state
     * @return the cached shape for the given block state
     */
    public VoxelShape getBlockShape(final BlockState blockState) {
        return blockShapes.get(blockState);
    }

    /**
     * @param blockState the block state
     * @return the cached multiblock shape for the given block state
     */
    public VoxelShape getMultiblockShape(final BlockState blockState) {
        return multiblockShapes.get(blockState);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return this.hasCollision ? getBlockShape(pState) : Shapes.empty();
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return getMultiblockShape(pState);
    }

    //// DELEGATE PROVIDER ////

    @Override
    public BlockPos getDelegatePos(BlockState blockState, BlockPos blockPos) {
        return blockState.getValue(HALF) == DoubleBlockHalf.UPPER ? blockPos : blockPos.above();
    }

    //// METHODS ////

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        boolean waterlogged = fluidstate.getType() == Fluids.WATER;
        if (blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(pContext)) {
            return this.defaultBlockState()
                    .setValue(FACING, pContext.getHorizontalDirection().getOpposite())
                    .setValue(WATERLOGGED, waterlogged)
                    .setValue(HALF, DoubleBlockHalf.LOWER);
        } else {
            return null;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING).add(WATERLOGGED).add(HALF);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        // update fluid
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
        // update half
        DoubleBlockHalf half = pState.getValue(HALF);
        if (pFacing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (pFacing == Direction.UP)) {
            return pFacingState.is(this) && pFacingState.getValue(HALF) != half ? pState.setValue(FACING, pFacingState.getValue(FACING)) : getFluidState(pState).createLegacyBlock();
        }
        return half == DoubleBlockHalf.LOWER && pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? getFluidState(pState).createLegacyBlock() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack) {
        boolean waterlogged = pLevel.getFluidState(pPos.above()).getType() == Fluids.WATER;
        pLevel.setBlock(pPos.above(), pState.setValue(HALF, DoubleBlockHalf.UPPER).setValue(WATERLOGGED, waterlogged), Block.UPDATE_ALL);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return pState.getValue(HALF) == DoubleBlockHalf.LOWER || pLevel.getBlockState(pPos.below()).is(this);
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide && pPlayer.isCreative()) {
//            DoublePlantBlock.preventCreativeDropFromBottomPart(pLevel, pPos, pState, pPlayer);
        }
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState pState) {
        return PushReaction.BLOCK;
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    public static ShapeBuilder createShapeBuilder(final VoxelShape upperShape, final VoxelShape lowerShape) {
        return blockState -> {
            final Direction facing =  blockState.getValue(FACING);
            final DoubleBlockHalf half = blockState.getValue(HALF);
            final VoxelShape shape = half == DoubleBlockHalf.UPPER ? upperShape : lowerShape;
            return ShapeUtils.rotateShape(MultiblockHandler.ORIGIN_DIRECTION, facing, shape);
        };
    }
}