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
        itemModelDisplay(WhimsyRegistry.BlockReg.FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockReg.GATCHAPON_MACHINE);
        itemModelDisplay(WhimsyRegistry.BlockReg.YELLOW_FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockReg.PINK_FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockReg.ORANGE_FROGGY_CHAIR);
        itemModelDisplay(WhimsyRegistry.BlockReg.BLUE_FROGGY_CHAIR);

        itemModel(WhimsyRegistry.BlockReg.BLUE_TOY_PLANE);
        itemModel(WhimsyRegistry.BlockReg.RED_TOY_PLANE);
        itemModel(WhimsyRegistry.BlockReg.YELLOW_TOY_PLANE);

        itemModelDisplay(WhimsyRegistry.BlockReg.BIG_PANDA_PLUSHIE);
        itemModel(WhimsyRegistry.BlockReg.FUFU_PLUSHIE);
        itemModel(WhimsyRegistry.BlockReg.FLOWER_PIG_PLUSHIE);
        itemModel(WhimsyRegistry.BlockReg.GOLDEN_PIG_PLUSHIE);
        itemModel(WhimsyRegistry.BlockReg.VOCAL_DOLL);
    }

    public void itemModel(RegistryObject<Block> block) {
        withExistingParent(block.getId().getPath(), WhimsyDeco.MODID + ":block/" + block.getId().getPath());
    }
    public void itemModelDisplay(RegistryObject<Block> block) {
        withExistingParent(block.getId().getPath(), WhimsyDeco.MODID + ":block/" + block.getId().getPath() + "/display");
    }
}
