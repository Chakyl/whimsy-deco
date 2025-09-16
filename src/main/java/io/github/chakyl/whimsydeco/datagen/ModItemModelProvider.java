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
        itemModelDisplay(WhimsyRegistry.BlockReg.BLACK_ATM);
        itemModelDisplay(WhimsyRegistry.BlockReg.GREEN_ATM);
        itemModelDisplay(WhimsyRegistry.BlockReg.RED_ATM);
        itemModelDisplay(WhimsyRegistry.BlockReg.YELLOW_ATM);
        itemModelDisplay(WhimsyRegistry.BlockReg.BLUE_ATM);

        itemModel(WhimsyRegistry.BlockReg.CAUTION_FLOOR_SIGN);

        itemModel(WhimsyRegistry.BlockReg.DARTBOARD);


        itemModelDisplay(WhimsyRegistry.BlockReg.FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockReg.YELLOW_FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockReg.PINK_FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockReg.ORANGE_FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockReg.BLUE_FROGGY_CHAIR);

        itemModelDisplay(WhimsyRegistry.BlockReg.GATCHA_MACHINE);

        itemModelDisplay(WhimsyRegistry.BlockReg.GNOME);
        itemModel(WhimsyRegistry.BlockReg.LANTERN_GNOME);

        itemModel(WhimsyRegistry.BlockReg.HORSESHOE);
        itemModel(WhimsyRegistry.BlockReg.GOLDEN_HORSESHOE);

        itemModel(WhimsyRegistry.BlockReg.RED_LAWN_MOWER);
        itemModel(WhimsyRegistry.BlockReg.ORANGE_LAWN_MOWER);
        itemModel(WhimsyRegistry.BlockReg.BLUE_LAWN_MOWER);
        itemModel(WhimsyRegistry.BlockReg.YELLOW_LAWN_MOWER);

        itemModel(WhimsyRegistry.BlockReg.PAPER_LANTERN);
        itemModel(WhimsyRegistry.BlockReg.BLUE_PAPER_LANTERN);
        itemModel(WhimsyRegistry.BlockReg.RED_PAPER_LANTERN);
        itemModel(WhimsyRegistry.BlockReg.WOOD_FRAMED_PAPER_LANTERN);
        itemModel(WhimsyRegistry.BlockReg.BAMBOO_FRAMED_PAPER_LANTERN);
        itemModel(WhimsyRegistry.BlockReg.TREE_PAPER_LANTERN);

        itemModel(WhimsyRegistry.BlockReg.PHONE);
        itemModel(WhimsyRegistry.BlockReg.BLACK_PHONE);
        itemModel(WhimsyRegistry.BlockReg.RED_PHONE);
        itemModel(WhimsyRegistry.BlockReg.BLUE_PHONE);

        itemModelDisplay(WhimsyRegistry.BlockReg.VINE_RATTAN_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockReg.WARPED_RATTAN_CHAIR);

        itemModel(WhimsyRegistry.BlockReg.SHOWER);

        itemModel(WhimsyRegistry.BlockReg.FLAMINGO_SWIMMING_RING);
        itemModel(WhimsyRegistry.BlockReg.SWAN_SWIMMING_RING);
        itemModel(WhimsyRegistry.BlockReg.BLACK_SWAN_SWIMMING_RING);

        itemModel(WhimsyRegistry.BlockReg.BLUE_TOY_PLANE);
        itemModel(WhimsyRegistry.BlockReg.RED_TOY_PLANE);
        itemModel(WhimsyRegistry.BlockReg.YELLOW_TOY_PLANE);

        itemModel(WhimsyRegistry.BlockReg.WASHING_MACHINE);

        itemModelDisplay(WhimsyRegistry.BlockReg.BIG_PANDA_PLUSHIE);
        itemModel(WhimsyRegistry.BlockReg.FUFU_PLUSHIE);
        itemModel(WhimsyRegistry.BlockReg.FLOWER_PIG_PLUSHIE);
        itemModel(WhimsyRegistry.BlockReg.GOLDEN_PIG_PLUSHIE);
        itemModel(WhimsyRegistry.BlockReg.VOCAL_DOLL);
        itemModel(WhimsyRegistry.BlockReg.RED_VOCAL_DOLL);
    }

    public void itemModel(RegistryObject<Block> block) {
        withExistingParent(block.getId().getPath(), WhimsyDeco.MODID + ":block/" + block.getId().getPath());
    }
    public void itemModelDisplay(RegistryObject<Block> block) {
        withExistingParent(block.getId().getPath(), WhimsyDeco.MODID + ":block/" + block.getId().getPath() + "/display");
    }
}
