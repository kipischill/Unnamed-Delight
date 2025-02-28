package dev.kipischill;

import dev.kipischill.registry.ModItemGroups;
import dev.kipischill.registry.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnnamedDelight implements ModInitializer {
	public static final String MOD_ID = "unnameddelight";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		ModItemGroups.registerItemGroups();
	}
}