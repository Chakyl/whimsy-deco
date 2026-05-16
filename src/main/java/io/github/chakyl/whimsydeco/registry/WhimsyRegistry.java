package io.github.chakyl.whimsydeco.registry;

import com.google.common.base.Suppliers;
import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blockentities.*;
import io.github.chakyl.whimsydeco.blocks.*;
import io.github.chakyl.whimsydeco.items.GatchaCapsuleItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class WhimsyRegistry {

    private static final String MODID = WhimsyDeco.MODID;

    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    private static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, MODID);

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        BLOCK_ENTITY_TYPES.register(modEventBus);
        SOUND_EVENTS.register(modEventBus);

        // Force initialization of all registry holder classes
        // This ensures all static fields are initialized during the registration phase
        BlockRegistry.init();
        ItemRegistry.init();
        CreativeTabReg.init();
        BlockEntityRegistry.init();
        SoundRegistry.init();
    }

    public static final class BlockRegistry {
        /**
         * Forces initialization of this class and all its static fields.
         * Called during mod initialization to ensure all blocks are registered.
         */
        public static void init() {
            // Method intentionally empty - the act of calling it triggers class initialization
        }

        // ATM
        public static final DeferredHolder<Block, Block> BLACK_ATM = registerWithItem("black_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> GREEN_ATM = registerWithItem("green_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> RED_ATM = registerWithItem("red_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> YELLOW_ATM = registerWithItem("yellow_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BLUE_ATM = registerWithItem("blue_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Bamboo Candle
        public static final DeferredHolder<Block, Block> BAMBOO_CANDLE = registerWithItem("bamboo_candle", () ->
                new BambooCandleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO).noOcclusion().lightLevel(BambooCandleBlock.LIGHT_EMISSION).strength(1.5F, 6.0F)));

        // Bathroom Rack
        public static final DeferredHolder<Block, Block> BATHROOM_RACK = registerWithItem("bathroom_rack", () ->
                new BathroomRackBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Brooms
        public static final DeferredHolder<Block, Block> BROOM = registerWithItem("broom", () ->
                new BroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> PUSH_BROOM = registerWithItem("push_broom", () ->
                new BroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Cash Register
        public static final DeferredHolder<Block, Block> CASH_REGISTER = registerWithItem("cash_register", () ->
                new CashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BLACK_CASH_REGISTER = registerWithItem("black_cash_register", () ->
                new CashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> GRAY_CASH_REGISTER = registerWithItem("gray_cash_register", () ->
                new CashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Curio Cash Register
        public static final DeferredHolder<Block, Block> BLACK_CURIO_CASH_REGISTER = registerWithItem("black_curio_cash_register", () ->
                new CurioCashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> GOLD_CURIO_CASH_REGISTER = registerWithItem("gold_curio_cash_register", () ->
                new CurioCashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> COPPER_CURIO_CASH_REGISTER = registerWithItem("copper_curio_cash_register", () ->
                new CurioCashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> IRON_CURIO_CASH_REGISTER = registerWithItem("iron_curio_cash_register", () ->
                new CurioCashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Cast Iron Ledge
        public static final DeferredHolder<Block, Block> CAST_IRON_LEDGE = registerWithItem("cast_iron_ledge", () ->
                new LedgeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Cast Iron Trap Door
        public static final DeferredHolder<Block, Block> CAST_IRON_TRAPDOOR = registerWithItem("cast_iron_trapdoor", () ->
                new ThinTrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F), BlockSetType.OAK));

        // Caution Floor Sign
        public static final DeferredHolder<Block, Block> CAUTION_FLOOR_SIGN = registerWithItem("caution_floor_sign", () ->
                new FloorSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Cowbell
        public static final DeferredHolder<Block, Block> COWBELL = registerWithItem("cowbell", () ->
                new CowbellBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BRONZE_COWBELL = registerWithItem("bronze_cowbell", () ->
                new BronzeCowbellBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));

        // Dartboard
        public static final DeferredHolder<Block, Block> DARTBOARD = registerWithItem("dartboard", () ->
                new DartboardBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Desk Mirror
        public static final DeferredHolder<Block, Block> OAK_DESK_MIRROR = registerWithItem("oak_desk_mirror", () ->
                new DeskMirrorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> SPRUCE_DESK_MIRROR = registerWithItem("spruce_desk_mirror", () ->
                new DeskMirrorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> DARK_OAK_DESK_MIRROR = registerWithItem("dark_oak_desk_mirror", () ->
                new DeskMirrorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Fan
        public static final DeferredHolder<Block, Block> FAN = registerWithItem("fan", () ->
                new FanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));

        // Froggy Chair
        public static final DeferredHolder<Block, Block> FROGGY_CHAIR = registerWithItem("froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> ORANGE_FROGGY_CHAIR = registerWithItem("orange_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> YELLOW_FROGGY_CHAIR = registerWithItem("yellow_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BLUE_FROGGY_CHAIR = registerWithItem("blue_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> PINK_FROGGY_CHAIR = registerWithItem("pink_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));


        // Gatcha Machine
        public static final DeferredHolder<Block, Block> GATCHA_MACHINE = registerWithItem("gatcha_machine", () ->
                new GachaponMachineBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Gnome
        public static final DeferredHolder<Block, Block> GNOME = registerWithItem("gnome", () ->
                new GnomeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> LANTERN_GNOME = registerWithItem("lantern_gnome", () ->
                new LanternGnomeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));

        // Horseshoe
        public static final DeferredHolder<Block, Block> HORSESHOE = registerWithItem("horseshoe", () ->
                new HorseshoeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> GOLDEN_HORSESHOE = registerWithItem("golden_horseshoe", () ->
                new HorseshoeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Lawn Mower
        public static final DeferredHolder<Block, Block> RED_LAWN_MOWER = registerWithItem("red_lawn_mower", () ->
                new LawnmowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> ORANGE_LAWN_MOWER = registerWithItem("orange_lawn_mower", () ->
                new LawnmowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> YELLOW_LAWN_MOWER = registerWithItem("yellow_lawn_mower", () ->
                new LawnmowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BLUE_LAWN_MOWER = registerWithItem("blue_lawn_mower", () ->
                new LawnmowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> MATRYOSHKA_DOLL = registerWithItem("matryoshka_doll", () ->
                new MatryoshkaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Life Preserver Block
        public static final DeferredHolder<Block, Block> RED_LIFE_PRESERVER_RING = registerWithItem("red_life_preserver_ring", () ->
                new LifePreserverRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> ORANGE_LIFE_PRESERVER_RING = registerWithItem("orange_life_preserver_ring", () ->
                new LifePreserverRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> YELLOW_LIFE_PRESERVER_RING = registerWithItem("yellow_life_preserver_ring", () ->
                new LifePreserverRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BLUE_LIFE_PRESERVER_RING = registerWithItem("blue_life_preserver_ring", () ->
                new LifePreserverRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));


        // Lucky Cat
        public static final DeferredHolder<Block, Block> LUCKY_CAT = registerWithItem("lucky_cat", () ->
                new LuckyCatBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> GOLD_LUCKY_CAT = registerWithItem("gold_lucky_cat", () ->
                new GoldLuckyCatBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));

        // Moroccan Sofa
        public static final DeferredHolder<Block, Block> MOROCCAN_SOFA = registerWithItem("moroccan_sofa", () ->
                new SofaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO_WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Paper Lantern
        public static final DeferredHolder<Block, Block> PAPER_LANTERN = registerWithItem("paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOL).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> RED_PAPER_LANTERN = registerWithItem("red_paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOL).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BLUE_PAPER_LANTERN = registerWithItem("blue_paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOL).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> WOOD_FRAMED_PAPER_LANTERN = registerWithItem("wood_framed_paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOD).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BAMBOO_FRAMED_PAPER_LANTERN = registerWithItem("bamboo_framed_paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.BAMBOO_WOOD).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> TREE_PAPER_LANTERN = registerWithItem("tree_paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOL).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));

        // Phone
        public static final DeferredHolder<Block, Block> PHONE = registerWithItem("phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BLACK_PHONE = registerWithItem("black_phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> RED_PHONE = registerWithItem("red_phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BLUE_PHONE = registerWithItem("blue_phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Rattan Chair
        public static final DeferredHolder<Block, Block> VINE_RATTAN_CHAIR = registerWithItem("vine_rattan_chair", () ->
                new RattanChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO_WOOD).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> WARPED_RATTAN_CHAIR = registerWithItem("warped_rattan_chair", () ->
                new RattanChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.NETHER_WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Rattan Stool
        public static final DeferredHolder<Block, Block> RATTAN_STOOL = registerWithItem("rattan_stool", () ->
                new RattanStoolBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO_WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Recorder
        public static final DeferredHolder<Block, Block> RECORDER = registerWithItem("recorder", () ->
                new RecorderBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));

        // Rubber Duck
        public static final DeferredHolder<Block, Block> RUBBER_DUCK = registerWithItem("rubber_duck", () ->
                new DuckBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.SHROOMLIGHT).noOcclusion().strength(1.5F, 6.0F)));

        // Ship Helm
        public static final DeferredHolder<Block, Block> SHIP_HELM = registerWithItem("ship_helm", () ->
                new ShipHelmBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Shower
        public static final DeferredHolder<Block, Block> SHOWER = registerWithItem("shower", () ->
                new ShowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Singing Frog
        public static final DeferredHolder<Block, Block> SINGING_FROG = registerWithItem("singing_frog", () ->
                new SingingFrogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));

        // Stockings
        public static final DeferredHolder<Block, Block> RED_STOCKING = registerWithItem("red_stocking", () ->
                new StockingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> GREEN_STOCKING = registerWithItem("green_stocking", () ->
                new StockingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BLUE_STOCKING = registerWithItem("blue_stocking", () ->
                new StockingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> ORANGE_STOCKING = registerWithItem("orange_stocking", () ->
                new StockingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));

        // Swimming Rings
        public static final DeferredHolder<Block, Block> FLAMINGO_SWIMMING_RING = registerWithItem("flamingo_swimming_ring", () ->
                new SwimmingRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.MOSS).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> SWAN_SWIMMING_RING = registerWithItem("swan_swimming_ring", () ->
                new SwimmingRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.MOSS).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BLACK_SWAN_SWIMMING_RING = registerWithItem("black_swan_swimming_ring", () ->
                new SwimmingRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Toy Plane
        public static final DeferredHolder<Block, Block> RED_TOY_PLANE = registerWithItem("red_toy_plane", () ->
                new ToyPlaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> YELLOW_TOY_PLANE = registerWithItem("yellow_toy_plane", () ->
                new ToyPlaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> BLUE_TOY_PLANE = registerWithItem("blue_toy_plane", () ->
                new ToyPlaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Traffic Cone
        public static final DeferredHolder<Block, Block> TRAFFIC_CONE = registerWithItem("traffic_cone", () ->
                new TrafficConeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.SHROOMLIGHT).noOcclusion().strength(1.5F, 6.0F)));

        // Vintage Globe
        public static final DeferredHolder<Block, Block> VINTAGE_GLOBE = registerWithItem("vintage_globe", () ->
                new VintageGlobeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> ANTIQUE_VINTAGE_GLOBE = registerWithItem("antique_vintage_globe", () ->
                new AntiqueVintageGlobeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Washing Machine
        public static final DeferredHolder<Block, Block> WASHING_MACHINE = registerWithItem("washing_machine", () ->
                new WashingMachineBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Plushies
        public static final DeferredHolder<Block, Block> BIG_PANDA_PLUSHIE = registerWithItem("big_panda_plushie", () ->
                new BigPandaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> FUFU_PLUSHIE = registerWithItem("fufu_plushie", () ->
                new PlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> FLOWER_PIG_PLUSHIE = registerWithItem("flower_pig_plushie", () ->
                new PigPlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> GOLDEN_PIG_PLUSHIE = registerWithItem("golden_pig_plushie", () ->
                new PigPlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> VOCAL_DOLL = registerWithItem("vocal_doll", () ->
                new PlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> RED_VOCAL_DOLL = registerWithItem("red_vocal_doll", () ->
                new PlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));

        // Tile Blocks
        public static final DeferredHolder<Block, Block> CLASSIC_TILE = registerWithItem("classic_tile", () ->
                new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.5F, 6.0F)));
        public static final DeferredHolder<Block, Block> LIGHT_TILE = registerWithItem("light_tile", () ->
                new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.5F, 6.0F)));

        private static DeferredHolder<Block, Block> registerWithItem(final String name, final Supplier<Block> supplier) {
            return registerWithItem(name, supplier, ItemRegistry::registerBlockItem);
        }

        private static DeferredHolder<Block, Block> registerWithItem(final String name, final Supplier<Block> blockSupplier, final Function<DeferredHolder<Block, Block>, DeferredHolder<Item, Item>> itemSupplier) {
            final DeferredHolder<Block, Block> block = BLOCKS.register(name, blockSupplier);
            final DeferredHolder<Item, Item> item = itemSupplier.apply(block);
            return block;
        }
//
//        private static DeferredHolder<Block, Block> registerWithMultiblockItem(final String name, final Supplier<Block> supplier) {
//            return registerWithItem(name, supplier, block -> ItemRegistry.register(block.getId().getPath(), () -> new MultiblockItem(block.get(), new Item.Properties().stacksTo(1))));
//        }
//
//        private static DeferredHolder<Block, Block> registerWithWallMultiblockItem(final String name, final Supplier<Block> supplier) {
//            return registerWithItem(name, supplier, block -> ItemRegistry.register(block.getId().getPath(), () -> new WallMultiblockItem(block.get(), new Item.Properties().stacksTo(1))));
//        }

        private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
            return false;
        }
    }

    public static final class BlockEntityRegistry {
        /**
         * Forces initialization of this class and all its static fields.
         * Called during mod initialization to ensure all blocks are registered.
         */
        public static void init() {
            // Method intentionally empty - the act of calling it triggers class initialization
        }

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CowbellBlockEntity>> COWBELL = BLOCK_ENTITY_TYPES.register("cowbell",
                () -> BlockEntityType.Builder.of(CowbellBlockEntity::new, BlockRegistry.COWBELL.get()).build(null));
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BronzeCowbellBlockEntity>> BRONZE_COWBELL = BLOCK_ENTITY_TYPES.register("bronze_cowbell",
                () -> BlockEntityType.Builder.of(BronzeCowbellBlockEntity::new, BlockRegistry.BRONZE_COWBELL.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LuckyCatBlockEntity>> LUCKY_CAT = BLOCK_ENTITY_TYPES.register("lucky_cat",
                () -> BlockEntityType.Builder.of(LuckyCatBlockEntity::new, BlockRegistry.LUCKY_CAT.get()).build(null));
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoldLuckyCatBlockEntity>> GOLD_LUCKY_CAT = BLOCK_ENTITY_TYPES.register("gold_lucky_cat",
                () -> BlockEntityType.Builder.of(GoldLuckyCatBlockEntity::new, BlockRegistry.GOLD_LUCKY_CAT.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SingingFrogBlockEntity>> SINGING_FROG = BLOCK_ENTITY_TYPES.register("singing_frog",
                () -> BlockEntityType.Builder.of(SingingFrogBlockEntity::new, BlockRegistry.SINGING_FROG.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FanBlockEntity>> FAN = BLOCK_ENTITY_TYPES.register("fan",
                () -> BlockEntityType.Builder.of(FanBlockEntity::new, BlockRegistry.FAN.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VintageGlobeBlockEntity>> VINTAGE_GLOBE = BLOCK_ENTITY_TYPES.register("vintage_globe",
                () -> BlockEntityType.Builder.of(VintageGlobeBlockEntity::new, BlockRegistry.VINTAGE_GLOBE.get()).build(null));
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AntiqueVintageGlobeBlockEntity>> ANTIQUE_VINTAGE_GLOBE = BLOCK_ENTITY_TYPES.register("antique_vintage_globe",
                () -> BlockEntityType.Builder.of(AntiqueVintageGlobeBlockEntity::new, BlockRegistry.ANTIQUE_VINTAGE_GLOBE.get()).build(null));
    }


    public static final class ItemRegistry {
        /**
         * Forces initialization of this class and all its static fields.
         * Called during mod initialization to ensure all items are registered.
         */
        public static void init() {
            // Method intentionally empty - the act of calling it triggers class initialization
        }

        public static final DeferredHolder<Item, Item> GATCHA_CAPSULE = ITEMS.register("gatcha_capsule", () -> new GatchaCapsuleItem(new Item.Properties().component(DataComponents.RARITY, Rarity.RARE).stacksTo(64)));

        private static final List<DeferredHolder<Item, Item>> ALL_ITEMS = new ArrayList<>();

        /**
         * Creates a registry object for a block item and adds it to the mod creative tab
         *
         * @param block the block
         * @return the registry object
         */
        private static DeferredHolder<Item, Item> registerBlockItem(final DeferredHolder<Block, Block> block) {
            return register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
        }

        /**
         * Creates a registry object for the given item and adds it to the mod creative tab
         *
         * @param name     the registry name
         * @param supplier the item supplier
         * @return the item registry object
         */
        private static DeferredHolder<Item, Item> register(final String name, final Supplier<Item> supplier) {
            final DeferredHolder<Item, Item> item = ITEMS.register(name, supplier);
            ALL_ITEMS.add(item);
            return item;
        }
    }

    public static final class SoundRegistry {
        /**
         * Forces initialization of this class and all its static fields.
         * Called during mod initialization to ensure all blocks are registered.
         */
        public static void init() {
            // Method intentionally empty - the act of calling it triggers class initialization
        }

        public static final DeferredHolder<SoundEvent, SoundEvent> SQUEAK = register("squeak");
        public static final DeferredHolder<SoundEvent, SoundEvent> KACHING = register("kaching");

        /*
         * @param name the sound name as specified in the sounds.json file
         * @return a registered sound event for the TanukiDecor namespace and the given sound name
         */
        private static DeferredHolder<SoundEvent, SoundEvent> register(final String name) {
            return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, name)));
        }
    }

    public static final class CreativeTabReg {
        /**
         * Forces initialization of this class and all its static fields.
         * Called during mod initialization to ensure all blocks are registered.
         */
        public static void init() {
            // Method intentionally empty - the act of calling it triggers class initialization
        }


        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
                .icon(Suppliers.memoize(() -> new ItemStack(BlockRegistry.GNOME.get())))
                .title(Component.translatable("itemGroup." + WhimsyDeco.MODID))
                .withSearchBar()
                .displayItems((parameters, output) ->
                        output.acceptAll(ItemRegistry.ALL_ITEMS
                                .stream()
                                .map(o -> new ItemStack(o.get()))
                                .toList())
                )
                .build()
        );
    }

}