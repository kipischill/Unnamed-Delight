package dev.kipischill.mixin;

import dev.kipischill.registry.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LivingEntity.class, PlayerEntity.class})
public class PlayerEntityFromLivingEntityMixin {
    @Inject(method = "applyDamage", at = @At("HEAD"), cancellable = true)
    protected void applyDamage(DamageSource source, float amount, CallbackInfo callbackInfo) {
        LivingEntity livingEntity = LivingEntity.class.cast(this);
        if (livingEntity.hasStatusEffect(ModEffects.NAPTIME)) {
            livingEntity.removeStatusEffect(ModEffects.NAPTIME);
            callbackInfo.cancel();
        }
    }

}
