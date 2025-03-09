package dev.kipischill.registry;

import dev.kipischill.UnnamedDelight;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup UNNAMED_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(UnnamedDelight.MOD_ID, "unnameddelight"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.unnameddelight"))
                    .icon(() -> new ItemStack(ModItems.BUCKET_OF_CHICKEN)).entries(((displayContext, entries) -> {
                        entries.add(ModItems.BUCKET_OF_CHICKEN);
                        entries.add(ModItems.NAPPING_PILLS);
                    })).build());

    public static void registerItemGroups() {
        UnnamedDelight.LOGGER.info("Registering Item Groups for " + UnnamedDelight.MOD_ID);
    }
}
