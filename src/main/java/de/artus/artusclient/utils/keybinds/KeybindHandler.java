package de.artus.artusclient.utils.keybinds;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import java.util.concurrent.Callable;

public class KeybindHandler {

    public static void onPressed(KeyBind key, Runnable action) {
        onPressed(key, action, true);
    }
    public static void onPressed(KeyBind key, Runnable action, boolean waitUntilKeyUp) {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (waitUntilKeyUp) {
                while (key.get().wasPressed()) {
                    action.run();
                }
            } else {
                if (key.get().isPressed()) {
                    action.run();
                }
            }
        });
    }



}
