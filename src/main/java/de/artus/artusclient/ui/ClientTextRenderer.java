package de.artus.artusclient.ui;

import de.artus.artusclient.client.ArtusClient;
import net.minecraft.client.font.TextRenderer;

public class ClientTextRenderer {


    public static TextRenderer getTextRenderer() {
        return ArtusClient.getClient().textRenderer; // TODO: add own text renderer
    }


}
