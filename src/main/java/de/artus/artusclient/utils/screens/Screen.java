package de.artus.artusclient.utils.screens;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.client.MinecraftClient;

@AllArgsConstructor
public enum Screen {


    //CLIENT_MENU(ClientMenuScreen.class)
    ;

    @Getter
    private Class<? extends net.minecraft.client.gui.screen.Screen> screen;

    public void open() {
        try {
            MinecraftClient.getInstance().setScreen(getScreen().getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
