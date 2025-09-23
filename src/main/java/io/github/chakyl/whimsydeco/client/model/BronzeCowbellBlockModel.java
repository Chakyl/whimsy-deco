package io.github.chakyl.whimsydeco.client.model;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blockentities.BronzeCowbellBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.CowbellBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BronzeCowbellBlockModel extends GeoModel<BronzeCowbellBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "geo/block/cowbell.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "textures/block/bronze_cowbell.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "animations/block/cowbell.animation.json");

    @Override
    public ResourceLocation getModelResource(BronzeCowbellBlockEntity cowbellBlockEntity) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(BronzeCowbellBlockEntity cowbellBlockEntity) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(BronzeCowbellBlockEntity cowbellBlockEntity) {
        return this.animations;
    }
}