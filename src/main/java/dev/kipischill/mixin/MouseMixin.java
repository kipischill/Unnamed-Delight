package dev.kipischill.mixin;

import dev.kipischill.registry.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public abstract class MouseMixin {
    @Inject(method = "onMouseButton", at = @At("HEAD"), cancellable = true)
    private void onMouseButton(long window, int button, int action, int mods, CallbackInfo callbackInfo) {
        if (MinecraftClient.getInstance().player != null &&
                MinecraftClient.getInstance().player.hasStatusEffect(ModEffects.NAPTIME) &&
                !MinecraftClient.getInstance().player.isSpectator() &&
                !MinecraftClient.getInstance().player.isCreative() &&
                !MinecraftClient.getInstance().isPaused()
        ) {
            KeyBinding.unpressAll();
            callbackInfo.cancel();
        }
    }

    @Inject(method = "onMouseScroll", at = @At("HEAD"), cancellable = true)
    private void onMouseScroll(long window, double horizontal, double vertical, CallbackInfo callbackInfo) {
        if (MinecraftClient.getInstance().player != null &&
                MinecraftClient.getInstance().player.hasStatusEffect(ModEffects.NAPTIME) &&
                !MinecraftClient.getInstance().player.isSpectator() &&
                !MinecraftClient.getInstance().player.isCreative() &&
                !MinecraftClient.getInstance().isPaused()) {
            KeyBinding.unpressAll();
            callbackInfo.cancel();
        }
    }
}
