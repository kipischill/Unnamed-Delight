
package dev.kipischill.mixin;

import dev.kipischill.UnnamedDelight;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Shadow
    public float prevHeadYaw;
    float stuckYaw = 0;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract void setHeadYaw(float headYaw);

    @Shadow
    public abstract void setSprinting(boolean sprinting);

    @Shadow
    public abstract boolean damage(DamageSource source, float amount);

    @Shadow
    public abstract void equipStack(EquipmentSlot slot, ItemStack stack);


    @Inject(method = "canSee", at = @At("HEAD"), cancellable = true)
    public void canSee(Entity entity, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (UnnamedDelight.isComatose((LivingEntity) (Object) this)) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void tick(CallbackInfo callbackInfo) {
        if (UnnamedDelight.isComatose((LivingEntity) (Object) this)) {
            this.setPitch(90);
            this.prevPitch = 90;
            this.setHeadYaw(stuckYaw);
            this.prevHeadYaw = stuckYaw;
            this.setYaw(stuckYaw);
            this.setSneaking(false);
            this.setSprinting(false);
        } else {
            this.stuckYaw = this.getYaw();
        }

    }

}
