package io.github.chakyl.whimsydeco.registry;

import com.google.common.base.Suppliers;
import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blocks.*;
import io.github.chakyl.whimsydeco.blocks.PigPlushieBlock;
import io.github.chakyl.whimsydeco.blocks.PlushieBlock;
import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void register() {
        BlockReg.register();
        ItemReg.register();
        CreativeTabReg.register();
    }

    public static final class BlockReg {

        private static void register() {
            BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        // ATM:
        public static final RegistryObject<Block> BLACK_ATM = registerWithItem("black_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> GREEN_ATM = registerWithItem("green_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> YELLOW_ATM = registerWithItem("yellow_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> RED_ATM = registerWithItem("red_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_ATM = registerWithItem("blue_atm", () ->
                new ATMBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Floor Sign
        public static final RegistryObject<Block> CAUTION_FLOOR_SIGN = registerWithItem("caution_floor_sign", () ->
                new FloorSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Dartboard
        public static final RegistryObject<Block> DARTBOARD = registerWithItem("dartboard", () ->
                new DartboardBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Froggy Chair
        public static final RegistryObject<Block> FROGGY_CHAIR = registerWithItem("froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> YELLOW_FROGGY_CHAIR = registerWithItem("yellow_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> PINK_FROGGY_CHAIR = registerWithItem("pink_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> ORANGE_FROGGY_CHAIR = registerWithItem("orange_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_FROGGY_CHAIR = registerWithItem("blue_froggy_chair", () ->
                new FroggyChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));


        // Gatcha Machine
        public static final RegistryObject<Block> GATCHA_MACHINE = registerWithItem("gatcha_machine", () ->
                new GachaponMachineBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Horseshoe
        public static final RegistryObject<Block> HORSESHOE = registerWithItem("horseshoe", () ->
                new HorseshoeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> GOLDEN_HORSESHOE = registerWithItem("golden_horseshoe", () ->
                new HorseshoeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Phone
        public static final RegistryObject<Block> PHONE = registerWithItem("phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLACK_PHONE = registerWithItem("black_phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> RED_PHONE = registerWithItem("red_phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_PHONE = registerWithItem("blue_phone", () ->
                new PhoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Toy Plane
        public static final RegistryObject<Block> YELLOW_TOY_PLANE = registerWithItem("yellow_toy_plane", () ->
                new ToyPlaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> RED_TOY_PLANE = registerWithItem("red_toy_plane", () ->
                new ToyPlaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> BLUE_TOY_PLANE = registerWithItem("blue_toy_plane", () ->
                new ToyPlaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Washing Machine
        public static final RegistryObject<Block> WASHING_MACHINE = registerWithItem("washing_machine", () ->
                new WashingMachineBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));

        // Plushies
        public static final RegistryObject<Block> BIG_PANDA_PLUSHIE = registerWithItem("big_panda_plushie", () ->
                new BigPandaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> FUFU_PLUSHIE = registerWithItem("fufu_plushie", () ->
                new PlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> FLOWER_PIG_PLUSHIE = registerWithItem("flower_pig_plushie", () ->
                new PigPlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> GOLDEN_PIG_PLUSHIE = registerWithItem("golden_pig_plushie", () ->
                new PigPlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> VOCAL_DOLL = registerWithItem("vocal_doll", () ->
                new PlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));
        public static final RegistryObject<Block> RED_VOCAL_DOLL = registerWithItem("red_vocal_doll", () ->
                new PlushieBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(1.5F, 6.0F)));


        private static RegistryObject<Block> registerWithItem(final String name, final Supplier<Block> supplier) {
            return registerWithItem(name, supplier, ItemReg::registerBlockItem);
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

    public static final class ItemReg {

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
                        .icon(Suppliers.memoize(() -> new ItemStack(BlockReg.BLUE_TOY_PLANE.get())))
                        .title(Component.translatable("itemGroup." + WhimsyDeco.MODID))
                        .withSearchBar()
                        .displayItems((parameters, output) ->
                                output.acceptAll(ItemReg.ALL_ITEMS
                                        .stream()
                                        .map(o -> new ItemStack(o.get()))
                                        .toList())
                        )
                        .build()
        );
    }

}