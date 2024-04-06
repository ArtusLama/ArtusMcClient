package de.artus.artusclient.ui.components.scroll;

import de.artus.artusclient.client.ArtusClient;
import de.artus.artusclient.ui.Colors;
import de.artus.artusclient.ui.Position;
import de.artus.artusclient.ui.Size;
import de.artus.artusclient.ui.render.RectRenderer;
import de.artus.artusclient.ui.screens.BaseScreen;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.minecraft.client.gui.DrawContext;


public class ScrollBar extends RectRenderer {

    @Getter @Setter
    private int contentSize = 0;

    @Getter @Setter
    private int scrollPosition = 0;
    @Getter @Setter
    private int scrollThumbHeight = 0;

    @Getter
    private final int scrollSpeed = 10; //FIXME: hardcoded scroll speed
    @Getter
    private final int scrollThumbPadding = 2; //FIXME: hardcoded padding


    //TODO make draggable thumb
    public ScrollBar(@NonNull Position position, @NonNull Size size, @NonNull BaseScreen screen) {
        super(position, size, screen);
    }


    public void render(DrawContext context) {
        // render background
        if (isRenderBackground()) render(context, getPosition(), getSize(), Colors.UI_SCROLLBAR_BACKGROUND.getColor());

        // render thumb
        float v = getSize().getHeight() / (getContentSize() + 1f);

        int newScrollThumbHeight = (int) (getSize().getHeight() * v);
        if (newScrollThumbHeight > getSize().getHeight()) { // if thumb is bigger than the scrollbar
            newScrollThumbHeight = getSize().getHeight();
        }
        setScrollThumbHeight(newScrollThumbHeight);
        render(context, new Position(getPosition().getX() + getScrollThumbPadding(), (int) (getPosition().getY() + getScrollThumbPadding() + getScrollPosition() * v)), new Size(getSize().getWidth() - getScrollThumbPadding() * 2, getScrollThumbHeight() - getScrollThumbPadding() * 2), Colors.UI_SCROLLBAR_THUMB_COLOR.getColor());
    }

    public void scrollBy(double amount) { // amount is 1 or -1
        amount *= -1; // invert scroll direction

        float v = getSize().getHeight() / (getContentSize() + 1f);
        double newPosition = getScrollPosition() + amount * getScrollSpeed();
        if (newPosition < 0) {
            newPosition = 0;
        } else if (newPosition * v > getSize().getHeight() - getScrollThumbHeight()) {
            newPosition = (getSize().getHeight() - getScrollThumbHeight()) / v;
        }
        setScrollPosition((int) newPosition);
    }
}
