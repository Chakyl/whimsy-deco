package io.github.chakyl.whimsydeco.client.rederer;

import io.github.chakyl.whimsydeco.blockentities.CowbellBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.SingingFrogBlockEntity;
import io.github.chakyl.whimsydeco.client.model.CowbellBlockModel;
import io.github.chakyl.whimsydeco.client.model.SingingFrogBlockModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SingingFrogEntityRenderer extends GeoBlockRenderer<SingingFrogBlockEntity> {

    public SingingFrogEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new SingingFrogBlockModel());
    }
}