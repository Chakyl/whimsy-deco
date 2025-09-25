package io.github.chakyl.whimsydeco.items;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.tags.WhimsyItemTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class GatchaCapsuleItem extends Item {
    public GatchaCapsuleItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {

        pLevel.playSound((Player) null, pPlayer.getOnPos(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 0.5F, 1.0F);
        pLevel.playSound((Player) null, pPlayer.getOnPos(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, 1.0F);
        if (!pLevel.isClientSide()) {
            ItemStack[] gatchaDrops = Ingredient.of(WhimsyItemTags.GATCHA_DROPS).getItems();
            if (!pPlayer.isCreative()) pPlayer.getItemInHand(pHand).shrink(1);
            pPlayer.getInventory().add(gatchaDrops[Mth.floor(Mth.randomBetween(pLevel.getRandom(), 0f, gatchaDrops.length))].copy());
            return InteractionResultHolder.success(pPlayer.getItemInHand(pHand));
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pHand));
    }
}
