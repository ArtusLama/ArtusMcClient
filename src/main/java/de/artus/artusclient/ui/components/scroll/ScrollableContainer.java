package de.artus.artusclient.ui.components.scroll;

import de.artus.artusclient.ui.Colors;
import de.artus.artusclient.ui.Position;
import de.artus.artusclient.ui.Size;
import de.artus.artusclient.ui.render.RectRenderer;
import de.artus.artusclient.ui.screens.BaseScreen;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.minecraft.client.gui.DrawContext;

public class ScrollableContainer extends RectRenderer {



    @Getter @Setter
    private ScrollBar scrollBar;

    public ScrollableContainer(@NonNull Position position, @NonNull Size size, @NonNull BaseScreen screen) {
        super(position, size, screen);

        setScrollBar(new ScrollBar(new Position(), new Size(), screen));

        getScreen().getOnScroll().add((scrollEvent) -> {
            // check if the mouse is inside the container
            if (scrollEvent.getMouseX() >= getPosition().getX() && scrollEvent.getMouseX() <= getPosition().getX() + getSize().getWidth() &&
                    scrollEvent.getMouseY() >= getPosition().getY() && scrollEvent.getMouseY() <= getPosition().getY() + getSize().getHeight()) {
                getScrollBar().scrollBy(scrollEvent.getVerticalAmount());
            }
        });
    }



    public void render(DrawContext context) {
        getScrollBar().setSize(new Size(10, getSize().getHeight())); //FIXME: hardcoded size
        getScrollBar().setPosition(new Position(getPosition().getX() + getSize().getWidth() - getScrollBar().getSize().getWidth(), getPosition().getY()));


        if (isRenderBackground()) render(context, getPosition(), getSize(), Colors.UI_BACKGROUND_COLOR.getColor());


        getScrollBar().render(context);

        if (isRenderOutline()) renderBorder(context, getPosition(), getSize(), Colors.UI_BORDER_COLOR.getColor(), 1);
    }

}
