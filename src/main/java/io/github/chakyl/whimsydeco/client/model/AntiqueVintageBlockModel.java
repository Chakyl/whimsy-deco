package io.github.chakyl.whimsydeco.client.model;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blockentities.AntiqueVintageGlobeBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.CowbellBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AntiqueVintageBlockModel extends GeoModel<AntiqueVintageGlobeBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "geo/block/vintage_globe.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "textures/block/antique_vintage_globe.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "animations/block/vintage_globe.animation.json");

    @Override
    public ResourceLocation getModelResource(AntiqueVintageGlobeBlockEntity globeBlockEntity) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(AntiqueVintageGlobeBlockEntity globeBlockEntity) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(AntiqueVintageGlobeBlockEntity globeBlockEntity) {
        return this.animations;
    }
}