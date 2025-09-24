package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blockentities.FanBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.SingingFrogBlockEntity;
import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import software.bernie.geckolib.core.animation.AnimationController;

public class FanBlock extends RotatingBlock implements EntityBlock {
    public static final BooleanProperty ON = BooleanProperty.create("on");
    public static final VoxelShape SHAPE =  box(0, 0, 0, 16, 16, 16);

    public FanBlock(Properties props) {
        super(props, RotatingBlock.createShapeBuilder(SHAPE));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(ON, false).setValue(WATERLOGGED, false));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new FanBlockEntity(pPos, pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, ON,WATERLOGGED);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pLevel.setBlockAndUpdate(pPos, pState.setValue(ON, !pState.getValue(ON)));
        return InteractionResult.SUCCESS;
    }
}