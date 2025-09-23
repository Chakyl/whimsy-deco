package io.github.chakyl.whimsydeco.client.rederer;

import io.github.chakyl.whimsydeco.blockentities.BronzeCowbellBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.CowbellBlockEntity;
import io.github.chakyl.whimsydeco.client.model.BronzeCowbellBlockModel;
import io.github.chakyl.whimsydeco.client.model.CowbellBlockModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BronzeCowbellEntityRenderer extends GeoBlockRenderer<BronzeCowbellBlockEntity> {

    public BronzeCowbellEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new BronzeCowbellBlockModel());
    }
}