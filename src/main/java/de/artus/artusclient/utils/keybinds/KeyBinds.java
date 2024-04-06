package de.artus.artusclient.utils.keybinds;

import de.artus.artusclient.utils.Texts;
import lombok.Getter;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.HashMap;
import java.util.Map;

public class KeyBinds {

    @Getter
    private static Map<KeyBind, KeyBinding> keybinds = new HashMap<>();


    public static void register() {
        registerKey(
                KeyBind.OPEN_CLIENT_MENU,
                new KeyBinding(
                        Texts.KEYSTROKE_OPEN_CLIENT_MENU.getTranslationKey(),
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_RIGHT_SHIFT,
                        Texts.KEYSTROKE_CATEGORY.getTranslationKey()
                )
        );

    }
    public static void registerKey(KeyBind keyBind, KeyBinding keyBinding) {
        KeyBindingHelper.registerKeyBinding(keyBinding);
        getKeybinds().put(keyBind, keyBinding);
    }

}
