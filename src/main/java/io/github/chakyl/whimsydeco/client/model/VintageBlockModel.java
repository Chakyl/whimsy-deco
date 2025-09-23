package io.github.chakyl.whimsydeco.client.model;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blockentities.VintageGlobeBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VintageBlockModel extends GeoModel<VintageGlobeBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "geo/block/vintage_globe.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "textures/block/vintage_globe.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "animations/block/vintage_globe.animation.json");

    @Override
    public ResourceLocation getModelResource(VintageGlobeBlockEntity globeBlockEntity) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(VintageGlobeBlockEntity globeBlockEntity) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(VintageGlobeBlockEntity globeBlockEntity) {
        return this.animations;
    }
}