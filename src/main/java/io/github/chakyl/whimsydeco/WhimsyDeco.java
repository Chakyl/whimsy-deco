package io.github.chakyl.whimsydeco;

import com.mojang.logging.LogUtils;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod(WhimsyDeco.MODID)
public class WhimsyDeco {
    public static final String MODID = "whimsy_deco";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WhimsyDeco(ModContainer container) {
        IEventBus modEventBus = container.getEventBus();
        WhimsyRegistry.register(modEventBus);
        modEventBus.addListener(this::commonSetup);

    }
    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}