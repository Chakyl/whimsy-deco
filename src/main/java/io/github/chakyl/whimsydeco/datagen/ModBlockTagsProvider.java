//package io.github.chakyl.whimsydeco.datagen;
//
//import io.github.chakyl.whimsydeco.WhimsyDeco;
//import io.github.chakyl.whimsydeco.registry.ModElements;
//import net.minecraft.core.HolderLookup;
//import net.minecraft.data.PackOutput;
//import net.minecraftforge.common.data.BlockTagsProvider;
//import net.minecraftforge.common.data.ExistingFileHelper;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.concurrent.CompletableFuture;
//
//public class ModBlockTagsProvider extends BlockTagsProvider {
//	public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper exFileHelper) {
//        super(output, lookupProvider, WhimsyDeco.MODID, exFileHelper);
//    }
//
//    @Override
//    protected void addTags(HolderLookup.@NotNull Provider provider) {
//        this.registerMinecraftTags();
//    }
//
//    protected void registerMinecraftTags() {
//        ModElements.CROP_BLOCKS.getEntries().forEach(entry -> {
//            tag(net.minecraft.tags.BlockTags.CROPS).add(entry.get());
//        });
//    }
//}
