package io.github.chakyl.whimsydeco.client.model;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blockentities.CowbellBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CowbellBlockModel extends GeoModel<CowbellBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "geo/block/cowbell.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "textures/block/cowbell.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "animations/block/cowbell.animation.json");

    @Override
    public ResourceLocation getModelResource(CowbellBlockEntity cowbellBlockEntity) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(CowbellBlockEntity cowbellBlockEntity) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(CowbellBlockEntity cowbellBlockEntity) {
        return this.animations;
    }
}