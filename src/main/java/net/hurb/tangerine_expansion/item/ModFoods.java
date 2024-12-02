package net.hurb.tangerine_expansion.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TANGERINE = new FoodProperties.Builder().
            nutrition(2).fast().saturationMod(.2f).
            effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100), 0.2f).build();

    public static final FoodProperties PEELED_TANGERINE = new FoodProperties.Builder().
            nutrition(2).fast().saturationMod(.2f).
            effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100), 0.2f).build();


}
