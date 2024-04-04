package de.artus.artusclient.mixin;

import net.minecraft.client.gui.screen.SplashTextRenderer;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(TitleScreen.class)
public class TitleScreenMixin {

    @Shadow private @Nullable SplashTextRenderer splashText;

    @Mutable
    @Shadow @Final public static Text COPYRIGHT;

    @Inject(method = "init", at = @At("HEAD"))
    private void init(CallbackInfo ci) {
        splashText = new SplashTextRenderer(""); // remove splash Text
        COPYRIGHT = Text.of("");           // remove this copyright text
    }

    @ModifyVariable(method = "render", at = @At("STORE"), ordinal = 0)
    private String versionText(String in) {
        return ""; // remove mc version text
    }

}
