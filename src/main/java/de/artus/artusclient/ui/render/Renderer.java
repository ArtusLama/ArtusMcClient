package de.artus.artusclient.ui.render;


import de.artus.artusclient.client.ArtusClient;
import de.artus.artusclient.ui.Position;
import de.artus.artusclient.ui.Size;
import de.artus.artusclient.ui.screens.BaseScreen;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public abstract class Renderer implements Renderable {


    @Getter @Setter @NonNull
    private Position position;

    @Getter @Setter @NonNull
    private Size size;

    @Getter @Setter @NonNull
    private BaseScreen screen;


    @Getter @Setter
    private boolean renderBackground = true;

    @Getter @Setter
    private boolean renderOutline = false;


    public int getScreenWidth() {
        return ArtusClient.getClient().getWindow().getScaledWidth();
    }

    public int getScreenHeight() {
        return ArtusClient.getClient().getWindow().getScaledHeight();
    }

}
