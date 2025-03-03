package dev.kipischill.registry;

import dev.kipischill.UnnamedDelight;
import dev.kipischill.effect.NaptimeEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static StatusEffect NAPTIME;

    public static StatusEffect registerNaptimeEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(UnnamedDelight.MOD_ID, name),
                new NaptimeEffect(StatusEffectCategory.NEUTRAL, 0x63a1ff));
    }

    public static void registerEffects() {
        NAPTIME = registerNaptimeEffect("naptime");
        UnnamedDelight.LOGGER.info("Registering Mod Effects for " + UnnamedDelight.MOD_ID);
    }
}
