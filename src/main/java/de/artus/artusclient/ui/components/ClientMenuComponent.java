package de.artus.artusclient.ui.components;

import de.artus.artusclient.ui.ClientTextRenderer;
import de.artus.artusclient.ui.Colors;
import de.artus.artusclient.ui.Position;
import de.artus.artusclient.ui.Size;
import de.artus.artusclient.ui.components.mods.ModListComponent;
import de.artus.artusclient.ui.render.RectRenderer;
import de.artus.artusclient.ui.screens.BaseScreen;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.minecraft.client.gui.DrawContext;


public class ClientMenuComponent extends RectRenderer {


    @Getter @Setter
    private ModListComponent modList;

    public ClientMenuComponent(@NonNull Position position, @NonNull Size size, @NonNull BaseScreen screen) {
        super(position, size, screen);

        setModList(new ModListComponent(new Position(), new Size(), screen));
    }


    public void render(DrawContext context) {
        getModList().setSize(new Size(getSize().getWidth() - 20, getSize().getHeight() - 40));
        getModList().setPosition(new Position(getPosition().getX() + 10, getPosition().getY() + 30)); // At top more space


        if (isRenderBackground()) render(context, getPosition(), getSize(), Colors.UI_BACKGROUND_COLOR.getColor());
        context.drawCenteredTextWithShadow(ClientTextRenderer.getTextRenderer(), getScreen().getTitle(), getPosition().getX() + getSize().getWidth() / 2, getPosition().getY() + 10, Colors.TEXT_NORMAL_COLOR.getColor());
        getModList().render(context);
    }
}
