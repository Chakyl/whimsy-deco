package io.github.chakyl.whimsydeco.registry;

import com.google.common.base.Suppliers;
import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blockentities.*;
import io.github.chakyl.whimsydeco.blocks.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class WhimsyRegistry {

    private static final String MODID = WhimsyDeco.MODID;

    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void register() {
        BlockRegistry.register();
        BlockEntityRegistry.register();
        ItemRegistry.register();
        CreativeTabReg.register();
    }

    public static final class BlockRegistry {

        private static void register() {
            BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        // ATM
        public static final RegistryObject<Block> BLACK_ATM = registerWithItem("black_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> GREEN_ATM = registerWithItem("green_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> RED_ATM = registerWithItem("red_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> YELLOW_ATM = registerWithItem("yellow_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_ATM = registerWithItem("blue_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Bamboo Candle
        public static final RegistryObject<Block> BAMBOO_CANDLE = registerWithItem("bamboo_candle", () ->
                new BambooCandleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO).noOcclusion().strength(1.5F, 6.0F)));

        // Bathroom Rack
        public static final RegistryObject<Block> BATHROOM_RACK = registerWithItem("bathroom_rack", () ->
                new BathroomRackBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Brooms
        public static final RegistryObject<Block> BROOM = registerWithItem("broom", () ->
                new BroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> PUSH_BROOM = registerWithItem("push_broom", () ->
                new BroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Cash Register
        public static final RegistryObject<Block> CASH_REGISTER = registerWithItem("cash_register", () ->
                new CashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLACK_CASH_REGISTER = registerWithItem("black_cash_register", () ->
                new CashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> GRAY_CASH_REGISTER = registerWithItem("gray_cash_register", () ->
                new CashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Curio Cash Register
        public static final RegistryObject<Block> BLACK_CURIO_CASH_REGISTER = registerWithItem("black_curio_cash_register", () ->
                new CurioCashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> GOLD_CURIO_CASH_REGISTER = registerWithItem("gold_curio_cash_register", () ->
                new CurioCashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> COPPER_CURIO_CASH_REGISTER = registerWithItem("copper_curio_cash_register", () ->
                new CurioCashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> IRON_CURIO_CASH_REGISTER = registerWithItem("iron_curio_cash_register", () ->
                new CurioCashRegisterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Cast Iron Ledge
        public static final RegistryObject<Block> CAST_IRON_LEDGE = registerWithItem("cast_iron_ledge", () ->
                new LedgeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Cast Iron Trap Door
        public static final RegistryObject<Block> CAST_IRON_TRAPDOOR = registerWithItem("cast_iron_trapdoor", () ->
                new ThinTrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F), BlockSetType.IRON));

        // Caution Floor Sign
        public static final RegistryObject<Block> CAUTION_FLOOR_SIGN = registerWithItem("caution_floor_sign", () ->
                new FloorSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Cowbell
        public static final RegistryObject<Block> COWBELL = registerWithItem("cowbell", () ->
                new CowbellBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BRONZE_COWBELL = registerWithItem("bronze_cowbell", () ->
                new BronzeCowbellBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));

        // Dartboard
        public static final RegistryObject<Block> DARTBOARD = registerWithItem("dartboard", () ->
                new DartboardBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Desk Mirror
        public static final RegistryObject<Block> OAK_DESK_MIRROR = registerWithItem("oak_desk_mirror", () ->
                new DeskMirrorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> SPRUCE_DESK_MIRROR = registerWithItem("spruce_desk_mirror", () ->
                new DeskMirrorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> DARK_OAK_DESK_MIRROR = registerWithItem("dark_oak_desk_mirror", () ->
                new DeskMirrorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Fan
        public static final RegistryObject<Block> FAN = registerWithItem("fan", () ->
                new FanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));

        // Froggy Chair
        public static final RegistryObject<Block> FROGGY_CHAIR = registerWithItem("froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> ORANGE_FROGGY_CHAIR = registerWithItem("orange_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> YELLOW_FROGGY_CHAIR = registerWithItem("yellow_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_FROGGY_CHAIR = registerWithItem("blue_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> PINK_FROGGY_CHAIR = registerWithItem("pink_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));


        // Gatcha Machine
        public static final RegistryObject<Block> GATCHA_MACHINE = registerWithItem("gatcha_machine", () ->
                new GachaponMachineBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Gnome
        public static final RegistryObject<Block> GNOME = registerWithItem("gnome", () ->
                new GnomeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> LANTERN_GNOME = registerWithItem("lantern_gnome", () ->
                new LanternGnomeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));

        // Horseshoe
        public static final RegistryObject<Block> HORSESHOE = registerWithItem("horseshoe", () ->
                new HorseshoeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> GOLDEN_HORSESHOE = registerWithItem("golden_horseshoe", () ->
                new HorseshoeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Lawn Mower
        public static final RegistryObject<Block> RED_LAWN_MOWER = registerWithItem("red_lawn_mower", () ->
                new LawnmowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> ORANGE_LAWN_MOWER = registerWithItem("orange_lawn_mower", () ->
                new LawnmowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> YELLOW_LAWN_MOWER = registerWithItem("yellow_lawn_mower", () ->
                new LawnmowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_LAWN_MOWER = registerWithItem("blue_lawn_mower", () ->
                new LawnmowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> MATRYOSHKA_DOLL = registerWithItem("matryoshka_doll", () ->
                new MatryoshkaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Life Preserver Block
        public static final RegistryObject<Block> RED_LIFE_PRESERVER_RING = registerWithItem("red_life_preserver_ring", () ->
                new LifePreserverRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> ORANGE_LIFE_PRESERVER_RING = registerWithItem("orange_life_preserver_ring", () ->
                new LifePreserverRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> YELLOW_LIFE_PRESERVER_RING = registerWithItem("yellow_life_preserver_ring", () ->
                new LifePreserverRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_LIFE_PRESERVER_RING = registerWithItem("blue_life_preserver_ring", () ->
                new LifePreserverRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));


        // Lucky Cat
        public static final RegistryObject<Block> LUCKY_CAT = registerWithItem("lucky_cat", () ->
                new LuckyCatBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> GOLD_LUCKY_CAT = registerWithItem("gold_lucky_cat", () ->
                new GoldLuckyCatBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));

        // Paper Lantern
        public static final RegistryObject<Block> PAPER_LANTERN = registerWithItem("paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOL).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> RED_PAPER_LANTERN = registerWithItem("red_paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOL).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_PAPER_LANTERN = registerWithItem("blue_paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOL).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> WOOD_FRAMED_PAPER_LANTERN = registerWithItem("wood_framed_paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOD).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BAMBOO_FRAMED_PAPER_LANTERN = registerWithItem("bamboo_framed_paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.BAMBOO_WOOD).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> TREE_PAPER_LANTERN = registerWithItem("tree_paper_lantern", () ->
                new PaperLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOL).lightLevel(blockState -> 15).noOcclusion().strength(1.5F, 6.0F)));

        // Phone
        public static final RegistryObject<Block> PHONE = registerWithItem("phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLACK_PHONE = registerWithItem("black_phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> RED_PHONE = registerWithItem("red_phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_PHONE = registerWithItem("blue_phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Rattan Chair
        public static final RegistryObject<Block> VINE_RATTAN_CHAIR = registerWithItem("vine_rattan_chair", () ->
                new RattanChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO_WOOD).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> WARPED_RATTAN_CHAIR = registerWithItem("warped_rattan_chair", () ->
                new RattanChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.NETHER_WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Rattan Sofa
        public static final RegistryObject<Block> RATTAN_SOFA = registerWithItem("rattan_sofa", () ->
                new SofaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO_WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Rattan Stool
        public static final RegistryObject<Block> RATTAN_STOOL = registerWithItem("rattan_stool", () ->
                new RattanStoolBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO_WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Recorder
        public static final RegistryObject<Block> RECORDER = registerWithItem("recorder", () ->
                new RecorderBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));

        // Rubber Duck
        public static final RegistryObject<Block> RUBBER_DUCK = registerWithItem("rubber_duck", () ->
                new DuckBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.SHROOMLIGHT).noOcclusion().strength(1.5F, 6.0F)));

        // Ship Helm
        public static final RegistryObject<Block> SHIP_HELM = registerWithItem("ship_helm", () ->
                new ShipHelmBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Shower
        public static final RegistryObject<Block> SHOWER = registerWithItem("shower", () ->
                new ShowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Singing Frog
        public static final RegistryObject<Block> SINGING_FROG = registerWithItem("singing_frog", () ->
                new SingingFrogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.COPPER).noOcclusion().strength(1.5F, 6.0F)));

        // Stockings
        public static final RegistryObject<Block> RED_STOCKING = registerWithItem("red_stocking", () ->
                new StockingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> GREEN_STOCKING = registerWithItem("green_stocking", () ->
                new StockingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_STOCKING = registerWithItem("blue_stocking", () ->
                new StockingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> ORANGE_STOCKING = registerWithItem("orange_stocking", () ->
                new StockingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));

        // Swimming Rings
        public static final RegistryObject<Block> FLAMINGO_SWIMMING_RING = registerWithItem("flamingo_swimming_ring", () ->
                new SwimmingRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.MOSS).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> SWAN_SWIMMING_RING = registerWithItem("swan_swimming_ring", () ->
                new SwimmingRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.MOSS).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLACK_SWAN_SWIMMING_RING = registerWithItem("black_swan_swimming_ring", () ->
                new SwimmingRingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Toy Plane
        public static final RegistryObject<Block> RED_TOY_PLANE = registerWithItem("red_toy_plane", () ->
                new ToyPlaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> YELLOW_TOY_PLANE = registerWithItem("yellow_toy_plane", () ->
                new ToyPlaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_TOY_PLANE = registerWithItem("blue_toy_plane", () ->
                new ToyPlaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Traffic Cone
        public static final RegistryObject<Block> TRAFFIC_CONE = registerWithItem("traffic_cone", () ->
                new TrafficConeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.SHROOMLIGHT).noOcclusion().strength(1.5F, 6.0F)));

        // Vintage Globe
        public static final RegistryObject<Block> VINTAGE_GLOBE = registerWithItem("vintage_globe", () ->
                new VintageGlobeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> ANTIQUE_VINTAGE_GLOBE = registerWithItem("antique_vintage_globe", () ->
                new AntiqueVintageGlobeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.WOOD).noOcclusion().strength(1.5F, 6.0F)));

        // Washing Machine
        public static final RegistryObject<Block> WASHING_MACHINE = registerWithItem("washing_machine", () ->
                new WashingMachineBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Plushies
        public static final RegistryObject<Block> BIG_PANDA_PLUSHIE = registerWithItem("big_panda_plushie", () ->
                new BigPandaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> FUFU_PLUSHIE = registerWithItem("fufu_plushie", () ->
                new PlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> FLOWER_PIG_PLUSHIE = registerWithItem("flower_pig_plushie", () ->
                new PigPlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> GOLDEN_PIG_PLUSHIE = registerWithItem("golden_pig_plushie", () ->
                new PigPlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> VOCAL_DOLL = registerWithItem("vocal_doll", () ->
                new PlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> RED_VOCAL_DOLL = registerWithItem("red_vocal_doll", () ->
                new PlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).noOcclusion().strength(1.5F, 6.0F)));

        // Tile Blocks
        public static final RegistryObject<Block> CLASSIC_TILE = registerWithItem("classic_tile", () ->
                new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> LIGHT_TILE = registerWithItem("light_tile", () ->
                new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.5F, 6.0F)));

        private static RegistryObject<Block> registerWithItem(final String name, final Supplier<Block> supplier) {
            return registerWithItem(name, supplier, ItemRegistry::registerBlockItem);
        }

        private static RegistryObject<Block> registerWithItem(final String name, final Supplier<Block> blockSupplier, final Function<RegistryObject<Block>, RegistryObject<Item>> itemSupplier) {
            final RegistryObject<Block> block = BLOCKS.register(name, blockSupplier);
            final RegistryObject<Item> item = itemSupplier.apply(block);
            return block;
        }

        private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
            return false;
        }
    }

    public static final class BlockEntityRegistry {
        private static void register() {
            BLOCK_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        public static final RegistryObject<BlockEntityType<CowbellBlockEntity>> COWBELL = BLOCK_ENTITY_TYPES.register("cowbell",
                () -> BlockEntityType.Builder.of(CowbellBlockEntity::new, BlockRegistry.COWBELL.get()).build(null));
        public static final RegistryObject<BlockEntityType<BronzeCowbellBlockEntity>> BRONZE_COWBELL = BLOCK_ENTITY_TYPES.register("bronze_cowbell",
                () -> BlockEntityType.Builder.of(BronzeCowbellBlockEntity::new, BlockRegistry.BRONZE_COWBELL.get()).build(null));

        public static final RegistryObject<BlockEntityType<LuckyCatBlockEntity>> LUCKY_CAT = BLOCK_ENTITY_TYPES.register("lucky_cat",
                () -> BlockEntityType.Builder.of(LuckyCatBlockEntity::new, BlockRegistry.LUCKY_CAT.get()).build(null));
        public static final RegistryObject<BlockEntityType<GoldLuckyCatBlockEntity>> GOLD_LUCKY_CAT = BLOCK_ENTITY_TYPES.register("gold_lucky_cat",
                () -> BlockEntityType.Builder.of(GoldLuckyCatBlockEntity::new, BlockRegistry.GOLD_LUCKY_CAT.get()).build(null));

        public static final RegistryObject<BlockEntityType<SingingFrogBlockEntity>> SINGING_FROG = BLOCK_ENTITY_TYPES.register("singing_frog",
                () -> BlockEntityType.Builder.of(SingingFrogBlockEntity::new, BlockRegistry.SINGING_FROG.get()).build(null));

        public static final RegistryObject<BlockEntityType<FanBlockEntity>> FAN = BLOCK_ENTITY_TYPES.register("fan",
                () -> BlockEntityType.Builder.of(FanBlockEntity::new, BlockRegistry.FAN.get()).build(null));

        public static final RegistryObject<BlockEntityType<VintageGlobeBlockEntity>> VINTAGE_GLOBE = BLOCK_ENTITY_TYPES.register("vintage_globe",
                () -> BlockEntityType.Builder.of(VintageGlobeBlockEntity::new, BlockRegistry.VINTAGE_GLOBE.get()).build(null));
        public static final RegistryObject<BlockEntityType<AntiqueVintageGlobeBlockEntity>> ANTIQUE_VINTAGE_GLOBE = BLOCK_ENTITY_TYPES.register("antique_vintage_globe",
                () -> BlockEntityType.Builder.of(AntiqueVintageGlobeBlockEntity::new, BlockRegistry.ANTIQUE_VINTAGE_GLOBE.get()).build(null));
    }


    public static final class ItemRegistry {

        private static final List<RegistryObject<Item>> ALL_ITEMS = new ArrayList<>();

        private static void register() {
            ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        /**
         * Creates a registry object for a block item and adds it to the mod creative tab
         *
         * @param block the block
         * @return the registry object
         */
        private static RegistryObject<Item> registerBlockItem(final RegistryObject<Block> block) {
            return register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
        }

        /**
         * Creates a registry object for the given item and adds it to the mod creative tab
         *
         * @param name     the registry name
         * @param supplier the item supplier
         * @return the item registry object
         */
        private static RegistryObject<Item> register(final String name, final Supplier<Item> supplier) {
            final RegistryObject<Item> item = ITEMS.register(name, supplier);
            ALL_ITEMS.add(item);
            return item;
        }
    }

    public static final class CreativeTabReg {

        private static void register() {
            CREATIVE_MODE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("tab", () ->
                CreativeModeTab.builder()
                        .icon(Suppliers.memoize(() -> new ItemStack(BlockRegistry.BLUE_TOY_PLANE.get())))
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