package io.github.chakyl.whimsydeco.JEI;

import net.minecraft.world.item.ItemStack;

public class PurchasingRecipe {
    final ItemStack currency;
    final ItemStack output;

    public PurchasingRecipe(ItemStack currency, ItemStack output) {
        this.currency = currency;
        this.output = output;
    }
}
