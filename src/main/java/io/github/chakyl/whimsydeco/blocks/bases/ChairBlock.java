package io.github.chakyl.whimsydeco.blocks.bases;

import io.github.chakyl.whimsydeco.blocks.providers.ISeatProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;
/**
 * @author skyjay1
 * [https://github.com/skyjay1/Tanuki-Decor/blob/main-1.20.1/src/main/java/tanukidecor/block/seat/ChairBlock.java]
 * Used with permission under the GNU LGPLv3 license
 */
public class ChairBlock extends RotatingBlock implements ISeatProvider {

    public static final VoxelShape SHAPE = Shapes.or(
            box(0, 0, 3, 4, 5, 13),
            box(12, 0, 3, 16, 5, 13),
            box(0, 5, 3, 16, 10, 13));
    private double seatYOffset;

    public ChairBlock(final VoxelShape shape, final double seatYOffset, Properties pProperties) {
        super(pProperties, RotatingBlock.createShapeBuilder(shape));
        this.seatYOffset = seatYOffset;
    }

    //// SEAT PROVIDER ////

    @Override
    public double getSeatYOffset(BlockState blockState, Level level, BlockPos blockPos) {
        return this.seatYOffset;
    }

    @Override
    public Direction getSeatDirection(BlockState blockState, Level level, BlockPos blockPos) {
        return blockState.getValue(FACING);
    }

    //// METHODS ////

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        despawnSeat(pState, pLevel, pPos, false);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(pLevel.isClientSide()) {
            return InteractionResult.SUCCESS;
        }
        if(!pPlayer.isShiftKeyDown() && startSitting(pLevel.getBlockState(pPos), pLevel, pPos, pPlayer)) {
            return InteractionResult.SUCCESS;
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        despawnSeat(pState, pLevel, pPos, true);
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }
}