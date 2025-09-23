package io.github.chakyl.whimsydeco.client.rederer;

import io.github.chakyl.whimsydeco.blockentities.AntiqueVintageGlobeBlockEntity;
import io.github.chakyl.whimsydeco.blockentities.VintageGlobeBlockEntity;
import io.github.chakyl.whimsydeco.client.model.AntiqueVintageBlockModel;
import io.github.chakyl.whimsydeco.client.model.VintageBlockModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AntiqueVintageGlobeEntityRenderer extends GeoBlockRenderer<AntiqueVintageGlobeBlockEntity> {

    public AntiqueVintageGlobeEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new AntiqueVintageBlockModel());
    }
}