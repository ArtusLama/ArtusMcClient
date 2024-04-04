package de.artus.artusclient.client;

import de.artus.artusclient.utils.keybinds.KeyBinds;
import lombok.Getter;
import net.fabricmc.api.ClientModInitializer;

public class ArtusClient implements ClientModInitializer {

    @Getter
    private static final String windowTitle = "Artus Client";

    @Override
    public void onInitializeClient() {

        KeyBinds.register();
        //KeybindHandler.onPressed(KeyBind.OPEN_CLIENT_MENU, () -> Screen.CLIENT_MENU.open());

    }


}
