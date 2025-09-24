package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import io.github.chakyl.whimsydeco.util.ShapeBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CashRegisterBlock extends RotatingBlock {
    public static final VoxelShape SHAPE = Shapes.or(
            box(0, 13, 10, 16, 16, 16),
            box(0, 11, 8, 16, 16, 16),
            box(0, 9, 6, 16, 12, 16),
            box(0, 7, 4, 16, 9, 16),
            box(0, 5, 2, 16, 7, 16),
            box(0, 0, 0, 16, 5, 16));

    public static final BooleanProperty OPEN = BooleanProperty.create("open");

    public CashRegisterBlock(Properties props, VoxelShape pShape) {
        super(props, createShapeBuilder(pShape));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false).setValue(WATERLOGGED, false));
    }

    public CashRegisterBlock(Properties props) {
        super(props, createShapeBuilder(SHAPE));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, OPEN, WATERLOGGED);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pLevel.setBlockAndUpdate(pPos, pState.setValue(OPEN, !pState.getValue(OPEN)));
        if (!pState.getValue(OPEN)) pLevel.playSound((Player) null, pPlayer.getOnPos(), WhimsyRegistry.SoundRegistry.KACHING.get(), SoundSource.BLOCKS, 0.5F, 1.0F);
        return InteractionResult.SUCCESS;
    }

}