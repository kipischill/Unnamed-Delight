package dev.kipischill.mixin;

import dev.kipischill.UnnamedDelight;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraMixin {
    @Inject(method = "update", at = @At("HEAD"), cancellable = true)
    public void update(BlockView area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo callbackInfo) {
        if (UnnamedDelight.isComatose(MinecraftClient.getInstance().player)) {
            callbackInfo.cancel();
        }
    }
}
