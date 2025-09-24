package io.github.chakyl.whimsydeco.tags;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class WhimsyItemTags {
    public static final TagKey<Item> GATCHA_DROPS = tag("gatcha_drops");
    public static final TagKey<Item> GATCHA_MACHINE_ACCEPTS = tag("gatcha_machine_accepts");

    public static TagKey<Item> tag(String name) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, name));
    }
}