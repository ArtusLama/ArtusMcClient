package de.artus.artusclient.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.text.Text;


@AllArgsConstructor
public enum Texts {

    // Client Menu
    CLIENT_MENU_TITLE("clientmenu.artusclient.title"),



    // Keybinds
    KEYSTROKE_CATEGORY("category.artusclient.keybindings"),
    KEYSTROKE_OPEN_CLIENT_MENU("key.artusclient.open_client_menu"),

    ;

    @Getter
    private final String translationKey;

    public Text get() {
        return Text.translatable(getTranslationKey());
    }



}
