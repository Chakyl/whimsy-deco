package io.github.chakyl.whimsydeco.blockentities;

import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import static io.github.chakyl.whimsydeco.blocks.FanBlock.ON;

public class FanBlockEntity extends BlockEntity implements GeoBlockEntity {
    protected static final RawAnimation FAN = RawAnimation.begin().thenPlay("fanloop").thenLoop("fanloop");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public FanBlockEntity(BlockPos pos, BlockState state) {
        super(WhimsyRegistry.BlockEntityRegistry.FAN.get(), pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, (state) -> ((FanBlockEntity) state.getAnimatable()).getBlockState().getValue(ON) ? state.setAndContinue(FAN) : PlayState.STOP));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}