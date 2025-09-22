package io.github.chakyl.whimsydeco.client.rederer;

import io.github.chakyl.whimsydeco.blockentities.CowbellBlockEntity;
import io.github.chakyl.whimsydeco.client.model.CowbellBlockModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class CowbellEntityRenderer extends GeoBlockRenderer<CowbellBlockEntity> {

    public CowbellEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new CowbellBlockModel());
    }
}