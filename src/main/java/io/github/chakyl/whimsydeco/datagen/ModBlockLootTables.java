package io.github.chakyl.whimsydeco.datagen;

import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        generateDropSelf(WhimsyRegistry.BlockRegistry.BLACK_ATM);
        generateDropSelf(WhimsyRegistry.BlockRegistry.GREEN_ATM);
        generateDropSelf(WhimsyRegistry.BlockRegistry.RED_ATM);
        generateDropSelf(WhimsyRegistry.BlockRegistry.YELLOW_ATM);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BLUE_ATM);

        generateDropSelf(WhimsyRegistry.BlockRegistry.BAMBOO_CANDLE);

        generateDropSelf(WhimsyRegistry.BlockRegistry.BATHROOM_RACK);

        generateDropSelf(WhimsyRegistry.BlockRegistry.CAUTION_FLOOR_SIGN);

        generateDropSelf(WhimsyRegistry.BlockRegistry.OAK_DESK_MIRROR);
        generateDropSelf(WhimsyRegistry.BlockRegistry.SPRUCE_DESK_MIRROR);
        generateDropSelf(WhimsyRegistry.BlockRegistry.DARK_OAK_DESK_MIRROR);

        generateDropSelf(WhimsyRegistry.BlockRegistry.CASH_REGISTER);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BLACK_CASH_REGISTER);
        generateDropSelf(WhimsyRegistry.BlockRegistry.GRAY_CASH_REGISTER);

        generateDropSelf(WhimsyRegistry.BlockRegistry.BLACK_CURIO_CASH_REGISTER);
        generateDropSelf(WhimsyRegistry.BlockRegistry.IRON_CURIO_CASH_REGISTER);
        generateDropSelf(WhimsyRegistry.BlockRegistry.COPPER_CURIO_CASH_REGISTER);
        generateDropSelf(WhimsyRegistry.BlockRegistry.GOLD_CURIO_CASH_REGISTER);

        generateDropSelf(WhimsyRegistry.BlockRegistry.DARTBOARD);


        generateDropSelf(WhimsyRegistry.BlockRegistry.FROGGY_CHAIR);
        generateDropSelf(WhimsyRegistry.BlockRegistry.YELLOW_FROGGY_CHAIR);
        generateDropSelf(WhimsyRegistry.BlockRegistry.PINK_FROGGY_CHAIR);
        generateDropSelf(WhimsyRegistry.BlockRegistry.ORANGE_FROGGY_CHAIR);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BLUE_FROGGY_CHAIR);

        generateDropSelf(WhimsyRegistry.BlockRegistry.GATCHA_MACHINE);

        generateDropSelf(WhimsyRegistry.BlockRegistry.GNOME);
        generateDropSelf(WhimsyRegistry.BlockRegistry.LANTERN_GNOME);

        generateDropSelf(WhimsyRegistry.BlockRegistry.HORSESHOE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.GOLDEN_HORSESHOE);

        generateDropSelf(WhimsyRegistry.BlockRegistry.RED_LAWN_MOWER);
        generateDropSelf(WhimsyRegistry.BlockRegistry.ORANGE_LAWN_MOWER);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BLUE_LAWN_MOWER);
        generateDropSelf(WhimsyRegistry.BlockRegistry.YELLOW_LAWN_MOWER);

        generateDropSelf(WhimsyRegistry.BlockRegistry.MATRYOSHKA_DOLL);

        generateDropSelf(WhimsyRegistry.BlockRegistry.PAPER_LANTERN);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BLUE_PAPER_LANTERN);
        generateDropSelf(WhimsyRegistry.BlockRegistry.RED_PAPER_LANTERN);
        generateDropSelf(WhimsyRegistry.BlockRegistry.WOOD_FRAMED_PAPER_LANTERN);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BAMBOO_FRAMED_PAPER_LANTERN);
        generateDropSelf(WhimsyRegistry.BlockRegistry.TREE_PAPER_LANTERN);

        generateDropSelf(WhimsyRegistry.BlockRegistry.PHONE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BLACK_PHONE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.RED_PHONE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BLUE_PHONE);

        generateDropSelf(WhimsyRegistry.BlockRegistry.VINE_RATTAN_CHAIR);
        generateDropSelf(WhimsyRegistry.BlockRegistry.WARPED_RATTAN_CHAIR);

        generateDropSelf(WhimsyRegistry.BlockRegistry.RATTAN_STOOL);

        generateDropSelf(WhimsyRegistry.BlockRegistry.RUBBER_DUCK);

        generateDropSelf(WhimsyRegistry.BlockRegistry.SHIP_HELM);

        generateDropSelf(WhimsyRegistry.BlockRegistry.SHOWER);

        generateDropSelf(WhimsyRegistry.BlockRegistry.RED_STOCKING);
        generateDropSelf(WhimsyRegistry.BlockRegistry.GREEN_STOCKING);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BLUE_STOCKING);
        generateDropSelf(WhimsyRegistry.BlockRegistry.ORANGE_STOCKING);

        generateDropSelf(WhimsyRegistry.BlockRegistry.FLAMINGO_SWIMMING_RING);
        generateDropSelf(WhimsyRegistry.BlockRegistry.SWAN_SWIMMING_RING);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BLACK_SWAN_SWIMMING_RING);

        generateDropSelf(WhimsyRegistry.BlockRegistry.TRAFFIC_CONE);

        generateDropSelf(WhimsyRegistry.BlockRegistry.BLUE_TOY_PLANE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.RED_TOY_PLANE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.YELLOW_TOY_PLANE);

        generateDropSelf(WhimsyRegistry.BlockRegistry.WASHING_MACHINE);

        generateDropSelf(WhimsyRegistry.BlockRegistry.BIG_PANDA_PLUSHIE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.FUFU_PLUSHIE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.FLOWER_PIG_PLUSHIE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.GOLDEN_PIG_PLUSHIE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.VOCAL_DOLL);
        generateDropSelf(WhimsyRegistry.BlockRegistry.RED_VOCAL_DOLL);

        generateDropSelf(WhimsyRegistry.BlockRegistry.CLASSIC_TILE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.LIGHT_TILE);

        generateDropSelf(WhimsyRegistry.BlockRegistry.CAST_IRON_LEDGE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.CAST_IRON_TRAPDOOR);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BROOM);
        generateDropSelf(WhimsyRegistry.BlockRegistry.PUSH_BROOM);
        generateDropSelf(WhimsyRegistry.BlockRegistry.RECORDER);
        generateDropSelf(WhimsyRegistry.BlockRegistry.RATTAN_SOFA);
        generateDropSelf(WhimsyRegistry.BlockRegistry.YELLOW_LIFE_PRESERVER_RING);
        generateDropSelf(WhimsyRegistry.BlockRegistry.RED_LIFE_PRESERVER_RING);
        generateDropSelf(WhimsyRegistry.BlockRegistry.ORANGE_LIFE_PRESERVER_RING);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BLUE_LIFE_PRESERVER_RING);

        // Animated
        generateDropSelf(WhimsyRegistry.BlockRegistry.COWBELL);
        generateDropSelf(WhimsyRegistry.BlockRegistry.BRONZE_COWBELL);
        generateDropSelf(WhimsyRegistry.BlockRegistry.LUCKY_CAT);
        generateDropSelf(WhimsyRegistry.BlockRegistry.GOLD_LUCKY_CAT);
        generateDropSelf(WhimsyRegistry.BlockRegistry.SINGING_FROG);
        generateDropSelf(WhimsyRegistry.BlockRegistry.FAN);
        generateDropSelf(WhimsyRegistry.BlockRegistry.VINTAGE_GLOBE);
        generateDropSelf(WhimsyRegistry.BlockRegistry.ANTIQUE_VINTAGE_GLOBE);

    }

    public void generateDropSelf(RegistryObject<Block> block) {
        this.dropSelf(block.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return WhimsyRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}