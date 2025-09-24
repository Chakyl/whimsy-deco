//package io.github.chakyl.whimsydeco.datagen;
//
//import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
//import net.minecraft.data.PackOutput;
//import net.minecraft.data.recipes.FinishedRecipe;
//import net.minecraft.data.recipes.RecipeCategory;
//import net.minecraft.data.recipes.RecipeProvider;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.ItemLike;
//import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
//
//import java.util.function.Consumer;
//
//public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
//    public ModRecipeProvider(PackOutput pOutput) {
//        super(pOutput);
//    }
//
//    @Override
//    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLACK_ATM.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.GREEN_ATM.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.RED_ATM.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.YELLOW_ATM.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLUE_ATM.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BAMBOO_CANDLE.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BATHROOM_RACK.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.CAUTION_FLOOR_SIGN.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.OAK_DESK_MIRROR.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.SPRUCE_DESK_MIRROR.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.DARK_OAK_DESK_MIRROR.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.CASH_REGISTER.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLACK_CASH_REGISTER.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.GRAY_CASH_REGISTER.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLACK_CURIO_CASH_REGISTER.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.IRON_CURIO_CASH_REGISTER.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.COPPER_CURIO_CASH_REGISTER.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.GOLD_CURIO_CASH_REGISTER.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.DARTBOARD.get());
//
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.FROGGY_CHAIR.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.YELLOW_FROGGY_CHAIR.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.PINK_FROGGY_CHAIR.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.ORANGE_FROGGY_CHAIR.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLUE_FROGGY_CHAIR.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.GATCHA_MACHINE.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.GNOME.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.LANTERN_GNOME.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.HORSESHOE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.GOLDEN_HORSESHOE.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.RED_LAWN_MOWER.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.ORANGE_LAWN_MOWER.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLUE_LAWN_MOWER.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.YELLOW_LAWN_MOWER.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.MATRYOSHKA_DOLL.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.PAPER_LANTERN.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLUE_PAPER_LANTERN.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.RED_PAPER_LANTERN.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.WOOD_FRAMED_PAPER_LANTERN.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BAMBOO_FRAMED_PAPER_LANTERN.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.TREE_PAPER_LANTERN.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.PHONE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLACK_PHONE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.RED_PHONE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLUE_PHONE.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.VINE_RATTAN_CHAIR.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.WARPED_RATTAN_CHAIR.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.RATTAN_STOOL.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.RUBBER_DUCK.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.SHIP_HELM.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.SHOWER.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.RED_STOCKING.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.GREEN_STOCKING.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLUE_STOCKING.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.ORANGE_STOCKING.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.FLAMINGO_SWIMMING_RING.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.SWAN_SWIMMING_RING.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLACK_SWAN_SWIMMING_RING.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.TRAFFIC_CONE.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLUE_TOY_PLANE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.RED_TOY_PLANE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.YELLOW_TOY_PLANE.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.WASHING_MACHINE.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BIG_PANDA_PLUSHIE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.FUFU_PLUSHIE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.FLOWER_PIG_PLUSHIE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.GOLDEN_PIG_PLUSHIE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.VOCAL_DOLL.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.RED_VOCAL_DOLL.get());
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.CLASSIC_TILE.get(), 8);
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.LIGHT_TILE.get(), 8);
//
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.CAST_IRON_LEDGE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.CAST_IRON_TRAPDOOR.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BROOM.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.PUSH_BROOM.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.RECORDER.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.MOROCCAN_SOFA.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.YELLOW_LIFE_PRESERVER_RING.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.RED_LIFE_PRESERVER_RING.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.ORANGE_LIFE_PRESERVER_RING.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BLUE_LIFE_PRESERVER_RING.get());
//
//        // Animated
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.COWBELL.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.BRONZE_COWBELL.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.LUCKY_CAT.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.GOLD_LUCKY_CAT.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.SINGING_FROG.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.FAN.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.VINTAGE_GLOBE.get());
//        stoneCutting(pWriter, WhimsyRegistry.BlockRegistry.ANTIQUE_VINTAGE_GLOBE.get());
//
//    }
//
//    protected static void stoneCutting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pResult) {
//        stoneCutting(pFinishedRecipeConsumer, pResult, 1);
//    }
//
//    protected static void stoneCutting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pResult, int count) {
//        stonecutterResultFromBase(pFinishedRecipeConsumer, RecipeCategory.MISC, pResult, Items.ACACIA_BOAT, count);
//    }
//
//}