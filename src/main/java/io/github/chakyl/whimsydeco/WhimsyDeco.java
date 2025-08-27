package io.github.chakyl.whimsydeco;

import com.mojang.logging.LogUtils;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(WhimsyDeco.MODID)
public class WhimsyDeco {
    public static final String MODID = "whimsy_deco";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WhimsyDeco() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        WhimsyRegistry.register();

    }
}