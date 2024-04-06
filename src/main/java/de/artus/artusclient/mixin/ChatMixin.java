package de.artus.artusclient.mixin;

import de.artus.artusclient.client.mods.ModManager;
import de.artus.artusclient.client.mods.mod.ChatHistory;
import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatHud.class)
public class ChatMixin {

    @Inject(method = "clear", at = @At("HEAD"), cancellable = true)
    private void clearChat(boolean clearHistory, CallbackInfo ci) {
        if (ModManager.getModByClass(ChatHistory.class).isEnabled()) {
            ci.cancel();
        }
    }

}
