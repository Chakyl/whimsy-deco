package io.github.chakyl.whimsydeco.client.rederer;

import io.github.chakyl.whimsydeco.blockentities.GoldLuckyCatBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.LuckyCatBlockEntity;
import io.github.chakyl.whimsydeco.client.model.GoldLuckyCatBlockModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GoldLuckyCatEntityRenderer extends GeoBlockRenderer<GoldLuckyCatBlockEntity> {

    public GoldLuckyCatEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new GoldLuckyCatBlockModel());
    }
}