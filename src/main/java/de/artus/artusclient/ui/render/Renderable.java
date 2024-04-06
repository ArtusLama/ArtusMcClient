package de.artus.artusclient.ui.render;

import de.artus.artusclient.ui.Position;
import de.artus.artusclient.ui.Size;
import net.minecraft.client.gui.DrawContext;

public interface Renderable {

    void render(DrawContext context, Position position, Size size, int color);

    void renderBorder(DrawContext context, Position position, Size size, int color, int borderWidth);

}
