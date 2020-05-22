package org.g70.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.g70.view.handler.KeyHandler;

import java.io.IOException;

public abstract class GeneralView {
    protected Screen screen;
    protected TextGraphics graphics;

    public GeneralView(Screen screen) {
        this.screen = screen;
        graphics = screen.newTextGraphics();
    }

    public KeyHandler.KEY handler() throws IOException {
        KeyHandler k = new KeyHandler();
        return k.processKey(screen);
    }

    abstract public void draw() throws IOException;
}
