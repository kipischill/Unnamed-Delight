package dev.kipischill.registry;

import dev.kipischill.UnnamedDelight;
import dev.kipischill.item.BucketOfChickenItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item BUCKET_OF_CHICKEN = registerItem("bucket_of_chicken", new BucketOfChickenItem(new FabricItemSettings().food(ModFoodComponents.BUCKET_OF_CHICKEN).maxCount(32).rarity(Rarity.RARE)));


    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(UnnamedDelight.MOD_ID, name), item);
    }

    public static void registerModItems() {
        UnnamedDelight.LOGGER.info("Registering Mod Items for " + UnnamedDelight.MOD_ID);
    }
}
