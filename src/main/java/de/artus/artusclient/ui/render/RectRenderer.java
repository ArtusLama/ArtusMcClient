package de.artus.artusclient.ui.render;

import de.artus.artusclient.ui.Position;
import de.artus.artusclient.ui.Size;
import de.artus.artusclient.ui.screens.BaseScreen;
import lombok.NonNull;
import net.minecraft.client.gui.DrawContext;

public class RectRenderer extends Renderer {


    public RectRenderer(@NonNull Position position, @NonNull Size size, @NonNull BaseScreen screen) {
        super(position, size, screen);
    }

    @Override
    public void render(DrawContext context, Position position, Size size, int color) {
        context.fill(position.getX(), position.getY(), position.getX() + size.getWidth(), position.getY() + size.getHeight(), color);
    }

    @Override
    public void renderBorder(DrawContext context, Position position, Size size, int color, int borderWidth) { //TODO: border as variable not as parameter
        context.fill(position.getX(), position.getY(), position.getX() + size.getWidth(), position.getY() + borderWidth, color);
        context.fill(position.getX(), position.getY(), position.getX() + borderWidth, position.getY() + size.getHeight(), color);
        context.fill(position.getX() + size.getWidth() - borderWidth, position.getY(), position.getX() + size.getWidth(), position.getY() + size.getHeight(), color);
        context.fill(position.getX(), position.getY() + size.getHeight() - borderWidth, position.getX() + size.getWidth(), position.getY() + size.getHeight(), color);
    }

}
