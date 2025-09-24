package io.github.chakyl.whimsydeco.blockentities;

import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import software.bernie.example.block.entity.FertilizerBlockEntity;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import static io.github.chakyl.whimsydeco.blocks.SingingFrogBlock.SINGING;

public class SingingFrogBlockEntity extends BlockEntity implements GeoBlockEntity {
    protected static final RawAnimation SING = RawAnimation.begin().thenPlay("sing").thenLoop("sing");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SingingFrogBlockEntity(BlockPos pos, BlockState state) {
        super(WhimsyRegistry.BlockEntityRegistry.SINGING_FROG.get(), pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, (state) -> ((SingingFrogBlockEntity)state.getAnimatable()).getBlockState().getValue(SINGING)? state.setAndContinue(SING) : PlayState.STOP));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}