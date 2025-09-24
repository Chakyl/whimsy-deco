package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blockentities.SingingFrogBlockEntity;
import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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

public class SingingFrogBlock extends RotatingBlock implements EntityBlock {
    public static final BooleanProperty SINGING = BooleanProperty.create("singing");
    public static final VoxelShape SHAPE =  box(0, 0, 0, 16, 16, 16);

    public SingingFrogBlock(Properties props) {
        super(props, RotatingBlock.createShapeBuilder(SHAPE));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SINGING, false).setValue(WATERLOGGED, false));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SingingFrogBlockEntity(pPos, pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, SINGING,WATERLOGGED);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pLevel.setBlockAndUpdate(pPos, pState.setValue(SINGING, !pState.getValue(SINGING)));
        return InteractionResult.SUCCESS;
    }
}