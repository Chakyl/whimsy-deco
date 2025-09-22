package io.github.chakyl.whimsydeco.client.rederer;

import io.github.chakyl.whimsydeco.blockentities.LuckyCatBlockEntity;
import io.github.chakyl.whimsydeco.client.model.LuckyCatBlockModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class LuckyCatEntityRenderer extends GeoBlockRenderer<LuckyCatBlockEntity> {

    public LuckyCatEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new LuckyCatBlockModel());
    }
}