package io.github.chakyl.whimsydeco.client.model;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blockentities.GoldLuckyCatBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.LuckyCatBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GoldLuckyCatBlockModel extends GeoModel<GoldLuckyCatBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "geo/block/lucky_cat.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "textures/block/gold_lucky_cat.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "animations/block/lucky_cat.animation.json");

    @Override
    public ResourceLocation getModelResource(GoldLuckyCatBlockEntity goldLuckyCatBlockEntity) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(GoldLuckyCatBlockEntity goldLuckyCatBlockEntity) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(GoldLuckyCatBlockEntity goldLuckyCatBlockEntity) {
        return this.animations;
    }
}