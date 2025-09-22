package io.github.chakyl.whimsydeco.client.model;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blockentities.CowbellBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.SingingFrogBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SingingFrogBlockModel extends GeoModel<SingingFrogBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "geo/block/singing_frog.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "textures/block/singing_frog.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "animations/block/singing_frog.animation.json");

    @Override
    public ResourceLocation getModelResource(SingingFrogBlockEntity singingFrogBlockEntity) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(SingingFrogBlockEntity singingFrogBlockEntity) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(SingingFrogBlockEntity singingFrogBlockEntity) {
        return this.animations;
    }
}