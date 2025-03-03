package dev.kipischill.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ModFoodComponents {
    public static final FoodComponent BUCKET_OF_CHICKEN = new FoodComponent.Builder().hunger(4).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), 600, 0), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 2), 1f)
            .alwaysEdible().build();

    public static final FoodComponent NAPPING_PILLS = new FoodComponent.Builder().hunger(0).saturationModifier(0f)
            .statusEffect(new StatusEffectInstance(dev.kipischill.registry.ModEffects.NAPTIME, 600, 0), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 2), 1f)
            .alwaysEdible().build();
}
