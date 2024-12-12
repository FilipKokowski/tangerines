package net.hurb.tangerines.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModFoods {
    public static final FoodProperties TANGERINE = new FoodProperties.Builder().
            nutrition(3).fast().saturationMod(.3f).
            effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.3f).alwaysEat().build();

    public static final FoodProperties PEELED_TANGERINE = new FoodProperties.Builder().
            nutrition(3).fast().saturationMod(.3f).
            effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.3f).build();

}
