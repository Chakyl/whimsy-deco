package io.github.chakyl.whimsydeco.client.model;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blockentities.FanBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.LuckyCatBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FanBlockModel extends GeoModel<FanBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "geo/block/fan.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "textures/block/fan.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "animations/block/fan.animation.json");

    @Override
    public ResourceLocation getModelResource(FanBlockEntity fanBlockEntity) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(FanBlockEntity fanBlockEntity) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(FanBlockEntity fanBlockEntity) {
        return this.animations;
    }
}