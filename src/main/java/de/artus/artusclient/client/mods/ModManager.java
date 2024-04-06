package de.artus.artusclient.client.mods;

import de.artus.artusclient.client.ArtusClient;
import lombok.Getter;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModManager {

    @Getter
    private static List<ClientMod> mods = new ArrayList<>();


    public static void register(ClientMod mod) {
        mods.add(mod);
    }
    public static void initMods() {
        getMods().forEach(ClientMod::init);
        ClientTickEvents.END_CLIENT_TICK.register(client -> getMods().forEach(ClientMod::onTick));
    }
    public static ClientMod getModByClass(Class<? extends ClientMod> clazz) {
        return getMods().stream().filter(mod -> mod.getClass().equals(clazz)).findFirst().orElse(null);
    }
    public static ClientMod getModByName(String name) {
        return getMods().stream().filter(mod -> mod.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    public static List<ClientMod> getActiveMods() {
        return getMods().stream().filter(ClientMod::isEnabled).collect(Collectors.toList());
    }

}
