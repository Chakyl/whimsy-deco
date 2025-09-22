package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BathroomRackBlock extends RotatingBlock {
    public static final VoxelShape SHAPE = box(0, 12, 10, 16, 16, 16);


    public static final BooleanProperty TOILET_PAPER = BooleanProperty.create("toilet_paper");
    public static final BooleanProperty TOWEL = BooleanProperty.create("towel");

    public BathroomRackBlock(Properties props) {
        super(props, createShapeBuilder(SHAPE));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TOWEL, false).setValue(TOILET_PAPER, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, TOILET_PAPER, TOWEL, WATERLOGGED);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pHand == InteractionHand.MAIN_HAND) {
            boolean paper = pState.getValue(TOILET_PAPER);
            boolean towel = pState.getValue(TOWEL);
            if (!towel && pPlayer.getItemInHand(pHand).getItem() == Items.PAPER) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(TOILET_PAPER, true));
                pPlayer.getItemInHand(pHand).shrink(1);
            } else if (!paper && pPlayer.getItemInHand(pHand).getItem() == Items.WHITE_CARPET) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(TOWEL, true));
                pPlayer.getItemInHand(pHand).shrink(1);
            } else if (pPlayer.isCrouching() && pPlayer.getItemInHand(pHand).isEmpty()) {
                if (paper) {
                    pLevel.setBlockAndUpdate(pPos, pState.setValue(TOILET_PAPER, false));
                    pPlayer.addItem(Items.PAPER.getDefaultInstance());
                } else if (towel) {
                    pPlayer.addItem(Items.WHITE_CARPET.getDefaultInstance());
                    pLevel.setBlockAndUpdate(pPos, pState.setValue(TOWEL, false));
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForWallPlacement(pContext);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return super.canSurviveOnWall(pState, pLevel, pPos);
    }
}
