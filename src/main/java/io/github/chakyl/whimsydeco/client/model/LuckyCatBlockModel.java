package io.github.chakyl.whimsydeco.client.model;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blockentities.LuckyCatBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LuckyCatBlockModel extends GeoModel<LuckyCatBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "geo/block/lucky_cat.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "textures/block/lucky_cat.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "animations/block/lucky_cat.animation.json");

    @Override
    public ResourceLocation getModelResource(LuckyCatBlockEntity luckyCatBlockEntity) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(LuckyCatBlockEntity luckyCatBlockEntity) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(LuckyCatBlockEntity luckyCatBlockEntity) {
        return this.animations;
    }
}