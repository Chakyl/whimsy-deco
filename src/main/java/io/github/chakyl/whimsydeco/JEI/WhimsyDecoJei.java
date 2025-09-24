package io.github.chakyl.whimsydeco.JEI;


import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import io.github.chakyl.whimsydeco.tags.WhimsyItemTags;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class WhimsyDecoJei implements IModPlugin {

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(WhimsyDeco.MODID, "plugin");


    @Override
    public void registerCategories(IRecipeCategoryRegistration reg) {
        reg.addRecipeCategories(new GatchaOpeningCategory(reg.getJeiHelpers().getGuiHelper()));
        reg.addRecipeCategories(new PurchasingCategory(reg.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<PurchasingRecipe> purchasingRecipes = new ArrayList<>();
        List<GatchaOpeningRecipe> gatchaRecipes = new ArrayList<>();
        for (ItemStack stack : Ingredient.of(WhimsyItemTags.GATCHA_DROPS).getItems()) {
            gatchaRecipes.add(new GatchaOpeningRecipe(WhimsyRegistry.ItemRegistry.GATCHA_CAPSULE.get().getDefaultInstance(), stack));
        }
        for (ItemStack stack : Ingredient.of(WhimsyItemTags.GATCHA_MACHINE_ACCEPTS).getItems()) {
            purchasingRecipes.add(new PurchasingRecipe(stack, WhimsyRegistry.ItemRegistry.GATCHA_CAPSULE.get().getDefaultInstance()));
        }
        registration.addRecipes(PurchasingCategory.TYPE, purchasingRecipes);
        registration.addRecipes(GatchaOpeningCategory.TYPE, gatchaRecipes);

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration reg) {
        reg.addRecipeCatalyst(new ItemStack(WhimsyRegistry.BlockRegistry.GATCHA_MACHINE.get()), PurchasingCategory.TYPE);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

}