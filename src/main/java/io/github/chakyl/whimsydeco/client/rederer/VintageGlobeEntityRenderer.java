package io.github.chakyl.whimsydeco.client.rederer;

import io.github.chakyl.whimsydeco.blockentities.VintageGlobeBlockEntity;
import io.github.chakyl.whimsydeco.client.model.VintageBlockModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class VintageGlobeEntityRenderer extends GeoBlockRenderer<VintageGlobeBlockEntity> {

    public VintageGlobeEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new VintageBlockModel());
    }
}