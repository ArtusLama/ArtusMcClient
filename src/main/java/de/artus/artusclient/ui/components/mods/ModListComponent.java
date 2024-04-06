package de.artus.artusclient.ui.components.mods;

import com.mojang.blaze3d.systems.RenderSystem;
import de.artus.artusclient.client.ArtusClient;
import de.artus.artusclient.client.mods.ClientMod;
import de.artus.artusclient.client.mods.ModManager;
import de.artus.artusclient.ui.Position;
import de.artus.artusclient.ui.Size;
import de.artus.artusclient.ui.components.scroll.ScrollableContainer;
import de.artus.artusclient.ui.screens.BaseScreen;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModListComponent extends ScrollableContainer {

    @Getter @Setter
    private List<ModListItemComponent> modListItems = new ArrayList<>();

    @Getter @Setter
    private Size modItemSize = new Size(70, 70);
    @Getter @Setter
    private int modItemsPadding = 5;
    @Getter @Setter
    private int frameContentPadding = 10;

    public ModListComponent(@NonNull Position position, @NonNull Size size, @NonNull BaseScreen screen) {
        super(position, size, screen);

        setRenderBackground(false);
        setRenderOutline(true);

        List<ClientMod> mods = ModManager.getMods();
        setModListItems(mods.stream().map(mod -> new ModListItemComponent(mod, new Position(), getModItemSize(), getScreen())).collect(Collectors.toList()));
    }


    public void enableScissor() {
        RenderSystem.enableScissor(0, getSize().getHeight(), getScreenWidth(), getSize().getHeight());

        Window window = ArtusClient.getClient().getWindow();
        int height = window.getHeight();
        double scale = window.getScaleFactor();

        // define the clipping area
        int left = getPosition().getX();
        int right = getPosition().getX() + getSize().getWidth();
        int top = getPosition().getY();
        int bottom = getPosition().getY() + getSize().getHeight();



        double x0 = (double) left * scale;
        double y0 = (double) height - (double) bottom * scale;
        double x1 = (double) (right - left) * scale;
        double y1 = (double) (bottom - top) * scale;

        RenderSystem.enableScissor((int) x0, (int) y0, Math.max(0, (int) x1), Math.max(0, (int) y1));
    }

    public void render(DrawContext context) {

        int currX = getPosition().getX() + getFrameContentPadding();
        int currY = getPosition().getY() + getFrameContentPadding() - getScrollBar().getScrollPosition();

        // For clipping the content
        enableScissor();

        int totalHeight = getModItemSize().getHeight();
        for (int i = 0; i < getModListItems().size(); i++) {
            ModListItemComponent modListItem = getModListItems().get(i);
            modListItem.setSize(getModItemSize());

            if (currX + getModItemSize().getWidth() > getPosition().getX() + getSize().getWidth() - getFrameContentPadding() * 2) {
                currX = getPosition().getX() + getFrameContentPadding();

                currY += getModItemSize().getHeight() + getModItemsPadding();
                totalHeight += getModItemSize().getHeight() + getModItemsPadding();
            }
            modListItem.setPosition(new Position(currX, currY));
            currX += getModItemSize().getWidth() + getModItemsPadding();

            modListItem.render(context);
        }

        // end of rendering the mods
        RenderSystem.disableScissor();

        totalHeight += getFrameContentPadding() * 2;
        getScrollBar().setContentSize(totalHeight);

        super.render(context);
    }

}
