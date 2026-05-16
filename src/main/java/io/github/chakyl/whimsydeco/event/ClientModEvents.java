package io.github.chakyl.whimsydeco.event;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.client.rederer.*;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry.BlockEntityRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(value = Dist.CLIENT, modid = WhimsyDeco.MODID)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntityRegistry.COWBELL.get(), CowbellEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.BRONZE_COWBELL.get(), BronzeCowbellEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.LUCKY_CAT.get(), LuckyCatEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.GOLD_LUCKY_CAT.get(), GoldLuckyCatEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.SINGING_FROG.get(), SingingFrogEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.FAN.get(), FanEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.VINTAGE_GLOBE.get(), VintageGlobeEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.ANTIQUE_VINTAGE_GLOBE.get(), AntiqueVintageGlobeEntityRenderer::new);
    }
}
