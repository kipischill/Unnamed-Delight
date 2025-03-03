package dev.kipischill;

import dev.kipischill.effect.NaptimeEffect;
import dev.kipischill.registry.ModEffects;
import dev.kipischill.registry.ModItemGroups;
import dev.kipischill.registry.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnnamedDelight implements ModInitializer {
	public static final String MOD_ID = "unnameddelight";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static boolean isComatose(@Nullable LivingEntity entity) {
		return entity != null &&
				entity.hasStatusEffect(ModEffects.NAPTIME) &&
				!entity.isSpectator() &&
				!(entity instanceof PlayerEntity player && player.isCreative());
	}

	@Override
	public void onInitialize() {
		ModEffects.registerEffects();
		ModItems.registerModItems();

		ModItemGroups.registerItemGroups();

	}
}