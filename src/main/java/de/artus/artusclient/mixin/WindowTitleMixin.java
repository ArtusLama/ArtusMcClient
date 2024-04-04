package de.artus.artusclient.mixin;

import de.artus.artusclient.client.ArtusClient;
import net.minecraft.SharedConstants;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class WindowTitleMixin {

    @Inject(method = "getWindowTitle", at = @At("RETURN"), cancellable = true)
    private void updateWindowTitle(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue(ArtusClient.getWindowTitle() + " | " + SharedConstants.getGameVersion().getName());
    }

}
