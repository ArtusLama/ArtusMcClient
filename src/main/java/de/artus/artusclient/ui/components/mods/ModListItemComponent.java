package de.artus.artusclient.ui.components.mods;

import de.artus.artusclient.client.ArtusClient;
import de.artus.artusclient.client.mods.ClientMod;
import de.artus.artusclient.ui.ClientTextRenderer;
import de.artus.artusclient.ui.Colors;
import de.artus.artusclient.ui.Position;
import de.artus.artusclient.ui.Size;
import de.artus.artusclient.ui.render.RectRenderer;
import de.artus.artusclient.ui.screens.BaseScreen;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import me.x150.renderer.render.Renderer2d;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;


public class ModListItemComponent extends RectRenderer {

    @Getter
    private final ClientMod mod;

    @Getter @Setter
    private int padding = 4;


    public ModListItemComponent(ClientMod mod, @NonNull Position position, @NonNull Size size, @NonNull BaseScreen screen) {
        super(position, size, screen);
        this.mod = mod;

        getScreen().getOnMouseClicked().add((e) -> {
            if (e.getMouseX() >= getPosition().getX() && e.getMouseX() <= getPosition().getX() + getSize().getWidth() &&
                    e.getMouseY() >= getPosition().getY() && e.getMouseY() <= getPosition().getY() + getSize().getHeight()) {

                if (e.getButton() == 0) getMod().setEnabled(!getMod().isEnabled());
            }
        });

        setRenderOutline(true);
    }


    private Identifier getModIcon() {
        Identifier icon = new Identifier("artusclient", "textures/mod_icons/" + getMod().getIconName() + ".png");
        if (ArtusClient.getClient().getResourceManager().getResource(icon).isPresent()) {
            return icon;
        }
        return new Identifier("artusclient", "textures/mod_icons/default_icon.png");
    }

    public void render(DrawContext context) {

        if (isRenderBackground()) render(context, getPosition(), getSize(), Colors.UI_BACKGROUND_COLOR.getColor());
        if (isRenderOutline()) renderBorder(context, getPosition(), getSize(),
                getMod().isEnabled() ? Colors.UI_MOD_BORDER_ACTIVE.getColor() : Colors.UI_MOD_BORDER_DISABLED.getColor(),
                1);

        // Draw the mod icon
        int spareSpace = getSize().getHeight() / 5;
        int iconSize = (getSize().getHeight() - getPadding() * 2) - spareSpace;
        Renderer2d.renderTexture(context.getMatrices(), getModIcon(), getPosition().getX() + getPadding() + spareSpace / 2f, getPosition().getY() + getPadding(),
                iconSize, iconSize);

        // Draw the mod name
        context.drawCenteredTextWithShadow(ClientTextRenderer.getTextRenderer(), getMod().getName(),
                getPosition().getX() + getSize().getWidth() / 2, getPosition().getY() + getSize().getHeight() - getPadding() - (int) (spareSpace * 0.75),
                Colors.TEXT_NORMAL_COLOR.getColor());

    }
}
