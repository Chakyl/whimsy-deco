package io.github.chakyl.whimsydeco.datagen;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
	public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper exFileHelper) {
        super(output, lookupProvider, WhimsyDeco.MODID, exFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.registerMinecraftTags();
    }

    protected void registerMinecraftTags() {
        generateBlockTags(WhimsyRegistry.BlockRegistry.BLACK_ATM);
        generateBlockTags(WhimsyRegistry.BlockRegistry.GREEN_ATM);
        generateBlockTags(WhimsyRegistry.BlockRegistry.RED_ATM);
        generateBlockTags(WhimsyRegistry.BlockRegistry.YELLOW_ATM);
        generateBlockTags(WhimsyRegistry.BlockRegistry.BLUE_ATM);

        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.BAMBOO_CANDLE);

        generateBlockTags(WhimsyRegistry.BlockRegistry.BATHROOM_RACK);

        generateBlockTags(WhimsyRegistry.BlockRegistry.CAUTION_FLOOR_SIGN);

        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.OAK_DESK_MIRROR);
        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.SPRUCE_DESK_MIRROR);
        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.DARK_OAK_DESK_MIRROR);

        generateBlockTags(WhimsyRegistry.BlockRegistry.CASH_REGISTER);
        generateBlockTags(WhimsyRegistry.BlockRegistry.BLACK_CASH_REGISTER);
        generateBlockTags(WhimsyRegistry.BlockRegistry.GRAY_CASH_REGISTER);

        generateBlockTags(WhimsyRegistry.BlockRegistry.BLACK_CURIO_CASH_REGISTER);
        generateBlockTags(WhimsyRegistry.BlockRegistry.IRON_CURIO_CASH_REGISTER);
        generateBlockTags(WhimsyRegistry.BlockRegistry.COPPER_CURIO_CASH_REGISTER);
        generateBlockTags(WhimsyRegistry.BlockRegistry.GOLD_CURIO_CASH_REGISTER);

        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.DARTBOARD);


        generateBlockTags(WhimsyRegistry.BlockRegistry.FROGGY_CHAIR);
        generateBlockTags(WhimsyRegistry.BlockRegistry.YELLOW_FROGGY_CHAIR);
        generateBlockTags(WhimsyRegistry.BlockRegistry.PINK_FROGGY_CHAIR);
        generateBlockTags(WhimsyRegistry.BlockRegistry.ORANGE_FROGGY_CHAIR);
        generateBlockTags(WhimsyRegistry.BlockRegistry.BLUE_FROGGY_CHAIR);

        generateBlockTags(WhimsyRegistry.BlockRegistry.GATCHA_MACHINE);

        generateBlockTags(WhimsyRegistry.BlockRegistry.GNOME);
        generateBlockTags(WhimsyRegistry.BlockRegistry.LANTERN_GNOME);

        generateBlockTags(WhimsyRegistry.BlockRegistry.HORSESHOE);
        generateBlockTags(WhimsyRegistry.BlockRegistry.GOLDEN_HORSESHOE);

        generateBlockTags(WhimsyRegistry.BlockRegistry.RED_LAWN_MOWER);
        generateBlockTags(WhimsyRegistry.BlockRegistry.ORANGE_LAWN_MOWER);
        generateBlockTags(WhimsyRegistry.BlockRegistry.BLUE_LAWN_MOWER);
        generateBlockTags(WhimsyRegistry.BlockRegistry.YELLOW_LAWN_MOWER);

        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.MATRYOSHKA_DOLL);

        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.PAPER_LANTERN);
        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.BLUE_PAPER_LANTERN);
        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.RED_PAPER_LANTERN);
        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.WOOD_FRAMED_PAPER_LANTERN);
        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.BAMBOO_FRAMED_PAPER_LANTERN);
        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.TREE_PAPER_LANTERN);

        generateBlockTags(WhimsyRegistry.BlockRegistry.PHONE);
        generateBlockTags(WhimsyRegistry.BlockRegistry.BLACK_PHONE);
        generateBlockTags(WhimsyRegistry.BlockRegistry.RED_PHONE);
        generateBlockTags(WhimsyRegistry.BlockRegistry.BLUE_PHONE);

        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.VINE_RATTAN_CHAIR);
        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.WARPED_RATTAN_CHAIR);

        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.RATTAN_STOOL);

        generateBlockTags(WhimsyRegistry.BlockRegistry.RUBBER_DUCK);

        generateBlockTagsWood(WhimsyRegistry.BlockRegistry.SHIP_HELM);

        generateBlockTags(WhimsyRegistry.BlockRegistry.SHOWER);

        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.RED_STOCKING);
        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.GREEN_STOCKING);
        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.BLUE_STOCKING);
        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.ORANGE_STOCKING);

        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.FLAMINGO_SWIMMING_RING);
        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.SWAN_SWIMMING_RING);
        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.BLACK_SWAN_SWIMMING_RING);

        generateBlockTags(WhimsyRegistry.BlockRegistry.TRAFFIC_CONE);

        generateBlockTags(WhimsyRegistry.BlockRegistry.BLUE_TOY_PLANE);
        generateBlockTags(WhimsyRegistry.BlockRegistry.RED_TOY_PLANE);
        generateBlockTags(WhimsyRegistry.BlockRegistry.YELLOW_TOY_PLANE);

        generateBlockTags(WhimsyRegistry.BlockRegistry.WASHING_MACHINE);

        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.BIG_PANDA_PLUSHIE);
        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.FUFU_PLUSHIE);
        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.FLOWER_PIG_PLUSHIE);
        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.GOLDEN_PIG_PLUSHIE);
        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.VOCAL_DOLL);
        generateBlockTagsSoft(WhimsyRegistry.BlockRegistry.RED_VOCAL_DOLL);

        generateBlockTags(WhimsyRegistry.BlockRegistry.CLASSIC_TILE);
        generateBlockTags(WhimsyRegistry.BlockRegistry.LIGHT_TILE);

        generateBlockTags(WhimsyRegistry.BlockRegistry.CAST_IRON_LEDGE);
        generateBlockTags(WhimsyRegistry.BlockRegistry.BROOM);
        generateBlockTags(WhimsyRegistry.BlockRegistry.PUSH_BROOM);
        generateBlockTags(WhimsyRegistry.BlockRegistry.RECORDER);
        generateBlockTags(WhimsyRegistry.BlockRegistry.RATTAN_SOFA);
        generateBlockTags(WhimsyRegistry.BlockRegistry.YELLOW_LIFE_PRESERVER_RING);
        generateBlockTags(WhimsyRegistry.BlockRegistry.RED_LIFE_PRESERVER_RING);
        generateBlockTags(WhimsyRegistry.BlockRegistry.ORANGE_LIFE_PRESERVER_RING);
        generateBlockTags(WhimsyRegistry.BlockRegistry.BLUE_LIFE_PRESERVER_RING);

        // Animated
        generateBlockTags(WhimsyRegistry.BlockRegistry.COWBELL);
        generateBlockTags(WhimsyRegistry.BlockRegistry.BRONZE_COWBELL);
        generateBlockTags(WhimsyRegistry.BlockRegistry.LUCKY_CAT);
        generateBlockTags(WhimsyRegistry.BlockRegistry.GOLD_LUCKY_CAT);
        generateBlockTags(WhimsyRegistry.BlockRegistry.SINGING_FROG);
        generateBlockTags(WhimsyRegistry.BlockRegistry.FAN);
        generateBlockTags(WhimsyRegistry.BlockRegistry.VINTAGE_GLOBE);
        generateBlockTags(WhimsyRegistry.BlockRegistry.ANTIQUE_VINTAGE_GLOBE);

    }

    public void generateBlockTags(RegistryObject<Block> block) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get());
    }
    public void generateBlockTagsWood(RegistryObject<Block> block) {
        tag(BlockTags.MINEABLE_WITH_AXE).add(block.get());
    }

    public void generateBlockTagsSoft(RegistryObject<Block> block) {
//        tag(net.minecraft.tags.BlockTags.WOO).add(block.get());
    }
}
