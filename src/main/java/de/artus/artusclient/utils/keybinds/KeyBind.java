package de.artus.artusclient.utils.keybinds;

import net.minecraft.client.option.KeyBinding;

public enum KeyBind {

    OPEN_CLIENT_MENU

    ;

    public KeyBinding get() {
        KeyBinding key = KeyBinds.getKeybinds().get(this);
        if (key == null) {
            throw new RuntimeException("Key has to be registered before using it!");
        } else return key;
    }

}
