package io.github.chakyl.whimsydeco.blockentities;

import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
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
        controllers.add(new AnimationController(this, (state) -> ((SingingFrogBlockEntity) state.getAnimatable()).getBlockState().getValue(SINGING) ? state.setAndContinue(SING) : PlayState.STOP));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}