package de.artus.artusclient.ui.screens;


import de.artus.artusclient.ui.screens.screenEvents.MouseClickEvent;
import de.artus.artusclient.ui.screens.screenEvents.MouseMovedEvent;
import de.artus.artusclient.ui.screens.screenEvents.MouseScrollEvent;
import lombok.Getter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


@Environment(EnvType.CLIENT)
public abstract class BaseScreen extends Screen {

    public BaseScreen(Text title) {
        super(title);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Getter
    public List<Consumer<MouseMovedEvent>> onMouseMove = new ArrayList<>();
    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        onMouseMove.forEach(consumer -> consumer.accept(new MouseMovedEvent(mouseX, mouseY)));
    }

    @Getter
    public List<Consumer<MouseClickEvent>> onMouseClicked = new ArrayList<>();
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        onMouseClicked.forEach(consumer -> consumer.accept(new MouseClickEvent(mouseX, mouseY, button)));

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Getter
    public List<Consumer<MouseScrollEvent>> onScroll = new ArrayList<>();

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        onScroll.forEach(consumer -> consumer.accept(new MouseScrollEvent(mouseX, mouseY, horizontalAmount, verticalAmount)));
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }
}

