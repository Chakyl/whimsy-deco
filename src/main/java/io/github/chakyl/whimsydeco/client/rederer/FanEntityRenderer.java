package io.github.chakyl.whimsydeco.client.rederer;

import io.github.chakyl.whimsydeco.blockentities.FanBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.LuckyCatBlockEntity;
import io.github.chakyl.whimsydeco.client.model.FanBlockModel;
import io.github.chakyl.whimsydeco.client.model.LuckyCatBlockModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class FanEntityRenderer extends GeoBlockRenderer<FanBlockEntity> {

    public FanEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new FanBlockModel());
    }
}