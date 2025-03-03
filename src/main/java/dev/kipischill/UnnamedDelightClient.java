package dev.kipischill;

import ladysnake.satin.api.event.ShaderEffectRenderCallback;
import ladysnake.satin.api.managed.ManagedShaderEffect;
import ladysnake.satin.api.managed.ShaderEffectManager;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

public class UnnamedDelightClient implements ClientModInitializer {
    private static final ManagedShaderEffect BLACK_SCREEN = ShaderEffectManager.getInstance()
            .manage(new Identifier("unnameddelight", "shaders/post/blackscreen.json"));

    @Override
    public void onInitializeClient() {

        ShaderEffectRenderCallback.EVENT.register(tickDelta -> {
            if (UnnamedDelight.isComatose(MinecraftClient.getInstance().player)) {
                BLACK_SCREEN.render(tickDelta);
            }
        });
    }
}
