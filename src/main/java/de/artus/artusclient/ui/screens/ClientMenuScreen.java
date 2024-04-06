package de.artus.artusclient.ui.screens;


import de.artus.artusclient.ui.Colors;
import de.artus.artusclient.ui.Position;
import de.artus.artusclient.ui.Size;
import de.artus.artusclient.ui.components.ClientMenuComponent;
import de.artus.artusclient.utils.Texts;
import lombok.Getter;
import lombok.Setter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;


@Environment(EnvType.CLIENT)
public class ClientMenuScreen extends BaseScreen {

    @Getter @Setter
    private ClientMenuComponent clientMenuComponent;

    @Getter
    private final Size menuOffset = new Size(50, 30);

    public ClientMenuScreen() {
        super(Texts.CLIENT_MENU_TITLE.get());

        setClientMenuComponent(new ClientMenuComponent(new Position(), new Size(), this));
    }

    @Override
    protected void init() {
        Position pos = new Position(getMenuOffset().getWidth(), getMenuOffset().getHeight());
        Size size = new Size(this.width - (getMenuOffset().getWidth() * 2), this.height - (getMenuOffset().getHeight() * 2));

        getClientMenuComponent().setPosition(pos);
        getClientMenuComponent().setSize(size);
    }

    private void renderBackground(DrawContext context) {
        context.fillGradient(0, 0, width, height,
                Colors.SCREEN_DIM_BACKGROUND_START.getColor(), Colors.SCREEN_DIM_BACKGROUND_END.getColor());
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        getClientMenuComponent().render(context);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        super.mouseMoved(mouseX, mouseY);
    }
}
