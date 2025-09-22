package io.github.chakyl.whimsydeco.datagen;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WhimsyDeco.MODID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        itemModelDisplay(WhimsyRegistry.BlockRegistry.BLACK_ATM);
        itemModelDisplay(WhimsyRegistry.BlockRegistry.GREEN_ATM);
        itemModelDisplay(WhimsyRegistry.BlockRegistry.RED_ATM);
        itemModelDisplay(WhimsyRegistry.BlockRegistry.YELLOW_ATM);
        itemModelDisplay(WhimsyRegistry.BlockRegistry.BLUE_ATM);

        itemModel(WhimsyRegistry.BlockRegistry.BAMBOO_CANDLE);

        itemModel(WhimsyRegistry.BlockRegistry.BATHROOM_RACK);

        itemModel(WhimsyRegistry.BlockRegistry.CAUTION_FLOOR_SIGN);

        itemModel(WhimsyRegistry.BlockRegistry.OAK_DESK_MIRROR);
        itemModel(WhimsyRegistry.BlockRegistry.SPRUCE_DESK_MIRROR);
        itemModel(WhimsyRegistry.BlockRegistry.DARK_OAK_DESK_MIRROR);

        itemModel(WhimsyRegistry.BlockRegistry.CASH_REGISTER);
        itemModel(WhimsyRegistry.BlockRegistry.BLACK_CASH_REGISTER);
        itemModel(WhimsyRegistry.BlockRegistry.GRAY_CASH_REGISTER);

        itemModel(WhimsyRegistry.BlockRegistry.BLACK_CURIO_CASH_REGISTER);
        itemModel(WhimsyRegistry.BlockRegistry.IRON_CURIO_CASH_REGISTER);
        itemModel(WhimsyRegistry.BlockRegistry.COPPER_CURIO_CASH_REGISTER);
        itemModel(WhimsyRegistry.BlockRegistry.GOLD_CURIO_CASH_REGISTER);

        itemModel(WhimsyRegistry.BlockRegistry.DARTBOARD);


        itemModelDisplay(WhimsyRegistry.BlockRegistry.FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockRegistry.YELLOW_FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockRegistry.PINK_FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockRegistry.ORANGE_FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockRegistry.BLUE_FROGGY_CHAIR);

        itemModelDisplay(WhimsyRegistry.BlockRegistry.GATCHA_MACHINE);

        itemModelDisplay(WhimsyRegistry.BlockRegistry.GNOME);
        itemModel(WhimsyRegistry.BlockRegistry.LANTERN_GNOME);

        itemModel(WhimsyRegistry.BlockRegistry.HORSESHOE);
        itemModel(WhimsyRegistry.BlockRegistry.GOLDEN_HORSESHOE);

        itemModel(WhimsyRegistry.BlockRegistry.RED_LAWN_MOWER);
        itemModel(WhimsyRegistry.BlockRegistry.ORANGE_LAWN_MOWER);
        itemModel(WhimsyRegistry.BlockRegistry.BLUE_LAWN_MOWER);
        itemModel(WhimsyRegistry.BlockRegistry.YELLOW_LAWN_MOWER);

        itemModel(WhimsyRegistry.BlockRegistry.MATRYOSHKA_DOLL);

        itemModel(WhimsyRegistry.BlockRegistry.PAPER_LANTERN);
        itemModel(WhimsyRegistry.BlockRegistry.BLUE_PAPER_LANTERN);
        itemModel(WhimsyRegistry.BlockRegistry.RED_PAPER_LANTERN);
        itemModel(WhimsyRegistry.BlockRegistry.WOOD_FRAMED_PAPER_LANTERN);
        itemModel(WhimsyRegistry.BlockRegistry.BAMBOO_FRAMED_PAPER_LANTERN);
        itemModel(WhimsyRegistry.BlockRegistry.TREE_PAPER_LANTERN);

        itemModel(WhimsyRegistry.BlockRegistry.PHONE);
        itemModel(WhimsyRegistry.BlockRegistry.BLACK_PHONE);
        itemModel(WhimsyRegistry.BlockRegistry.RED_PHONE);
        itemModel(WhimsyRegistry.BlockRegistry.BLUE_PHONE);

        itemModelDisplay(WhimsyRegistry.BlockRegistry.VINE_RATTAN_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockRegistry.WARPED_RATTAN_CHAIR);

        itemModel(WhimsyRegistry.BlockRegistry.RATTAN_STOOL);

        itemModel(WhimsyRegistry.BlockRegistry.RUBBER_DUCK);

        itemModel(WhimsyRegistry.BlockRegistry.SHIP_HELM);

        itemModel(WhimsyRegistry.BlockRegistry.SHOWER);

        itemModel(WhimsyRegistry.BlockRegistry.RED_STOCKING);
        itemModel(WhimsyRegistry.BlockRegistry.GREEN_STOCKING);
        itemModel(WhimsyRegistry.BlockRegistry.BLUE_STOCKING);
        itemModel(WhimsyRegistry.BlockRegistry.ORANGE_STOCKING);

        itemModel(WhimsyRegistry.BlockRegistry.FLAMINGO_SWIMMING_RING);
        itemModel(WhimsyRegistry.BlockRegistry.SWAN_SWIMMING_RING);
        itemModel(WhimsyRegistry.BlockRegistry.BLACK_SWAN_SWIMMING_RING);

        itemModel(WhimsyRegistry.BlockRegistry.TRAFFIC_CONE);

        itemModel(WhimsyRegistry.BlockRegistry.BLUE_TOY_PLANE);
        itemModel(WhimsyRegistry.BlockRegistry.RED_TOY_PLANE);
        itemModel(WhimsyRegistry.BlockRegistry.YELLOW_TOY_PLANE);

        itemModel(WhimsyRegistry.BlockRegistry.WASHING_MACHINE);

        itemModelDisplay(WhimsyRegistry.BlockRegistry.BIG_PANDA_PLUSHIE);
        itemModel(WhimsyRegistry.BlockRegistry.FUFU_PLUSHIE);
        itemModel(WhimsyRegistry.BlockRegistry.FLOWER_PIG_PLUSHIE);
        itemModel(WhimsyRegistry.BlockRegistry.GOLDEN_PIG_PLUSHIE);
        itemModel(WhimsyRegistry.BlockRegistry.VOCAL_DOLL);
        itemModel(WhimsyRegistry.BlockRegistry.RED_VOCAL_DOLL);

        itemModel(WhimsyRegistry.BlockRegistry.CLASSIC_TILE);
        itemModel(WhimsyRegistry.BlockRegistry.LIGHT_TILE);

        itemModel(WhimsyRegistry.BlockRegistry.CAST_IRON_LEDGE);
        itemModel(WhimsyRegistry.BlockRegistry.BROOM);
        itemModel(WhimsyRegistry.BlockRegistry.PUSH_BROOM);

        // Animated
        itemModel(WhimsyRegistry.BlockRegistry.COWBELL);
        itemModel(WhimsyRegistry.BlockRegistry.LUCKY_CAT);
        itemModel(WhimsyRegistry.BlockRegistry.GOLD_LUCKY_CAT);
        itemModel(WhimsyRegistry.BlockRegistry.SINGING_FROG);
    }

    public void itemModel(RegistryObject<Block> block) {
        withExistingParent(block.getId().getPath(), WhimsyDeco.MODID + ":block/" + block.getId().getPath());
    }
    public void itemModelDisplay(RegistryObject<Block> block) {
        withExistingParent(block.getId().getPath(), WhimsyDeco.MODID + ":block/" + block.getId().getPath() + "/display");
    }
}
