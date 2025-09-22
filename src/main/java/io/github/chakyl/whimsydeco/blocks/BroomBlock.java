package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import io.github.chakyl.whimsydeco.util.ShapeBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BroomBlock extends RotatingBlock {
    public static final VoxelShape SHAPE = box(0, 0, 0, 16, 11, 16);
    public static final VoxelShape SHAPE_LEANING = box(0, 6, 0, 16, 16, 16);

    public static final BooleanProperty LEANING = BooleanProperty.create("leaning");

    public BroomBlock(Properties props) {
        super(props, createShapeBuilder(SHAPE));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LEANING, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LEANING, WATERLOGGED);
    }

    public static ShapeBuilder createShapeBuilder(final VoxelShape shape) {
        return blockState -> {
            final Boolean leaning = blockState.getValue(LEANING);
            return leaning ? SHAPE_LEANING : SHAPE;
        };
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pLevel.setBlockAndUpdate(pPos, pState.setValue(LEANING, !pState.getValue(LEANING)));
        return InteractionResult.SUCCESS;
    }

}