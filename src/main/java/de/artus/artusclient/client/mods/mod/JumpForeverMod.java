package de.artus.artusclient.client.mods.mod;

import de.artus.artusclient.client.ArtusClient;
import de.artus.artusclient.client.mods.ClientMod;
import net.minecraft.entity.MovementType;

public class JumpForeverMod extends ClientMod {


    public JumpForeverMod() {
        super("JumpForever");
    }

    @Override
    public void init() {}

    @Override
    public void onEnable() {}

    @Override
    public void onDisable() {}

    @Override
    public void onTick() {
        if (isEnabled()) {
            if (ArtusClient.getClient().player != null) {
                if (ArtusClient.getClient().player.isOnGround())
                    ArtusClient.getClient().player.jump();

            }
        }
    }
}
