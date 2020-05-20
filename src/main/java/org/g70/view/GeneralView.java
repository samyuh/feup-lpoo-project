package org.g70.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.g70.view.handler.KeyHandler;

import java.io.IOException;

public abstract class GeneralView {
    protected Screen screen;
    protected TextGraphics graphics;

    public GeneralView(Screen screen) {
        this.screen = screen;
        this.graphics = screen.newTextGraphics();
    }

    public KeyHandler.DIRECTION handler() throws IOException {
        KeyHandler k = new KeyHandler();
        return k.processKey(screen);
    }

    abstract public void draw() throws IOException;
}
