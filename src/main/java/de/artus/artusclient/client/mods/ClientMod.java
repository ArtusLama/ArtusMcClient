package de.artus.artusclient.client.mods;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public abstract class ClientMod {

    @Getter
    private final String name;

    public String getIconName() {
        return getName().toLowerCase().replace(" ", "_");
    }


    @Getter
    private boolean enabled;
    public void setEnabled(boolean enabled) {
        if (isEnabled() == enabled) return;

        this.enabled = enabled;
        if (isEnabled()) onEnable();
        else onDisable();
    }


    public abstract void init();
    public abstract void onEnable();
    public abstract void onDisable();
    public abstract void onTick();

}
