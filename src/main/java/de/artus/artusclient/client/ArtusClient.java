package de.artus.artusclient.client;

import de.artus.artusclient.client.mods.ModManager;
import de.artus.artusclient.client.mods.mod.ChatHistory;
import de.artus.artusclient.client.mods.mod.JumpForeverMod;
import de.artus.artusclient.utils.keybinds.KeyBind;
import de.artus.artusclient.utils.keybinds.KeyBinds;
import de.artus.artusclient.utils.keybinds.KeybindHandler;
import de.artus.artusclient.ui.screens.Screen;
import lombok.Getter;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class ArtusClient implements ClientModInitializer {

    @Getter
    private static final String windowTitle = "Artus Client";

    @Getter
    private static MinecraftClient client;

    @Override
    public void onInitializeClient() {

        client = MinecraftClient.getInstance();

        KeyBinds.register();
        KeybindHandler.onPressed(KeyBind.OPEN_CLIENT_MENU, () -> Screen.CLIENT_MENU.open());


        ModManager.register(new JumpForeverMod());
        ModManager.register(new ChatHistory());
        ModManager.initMods();
    }

}
