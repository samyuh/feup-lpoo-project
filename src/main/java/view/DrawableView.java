package view;

import model.drawable.Drawable;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DrawableView {
    public void draw(Drawable drawable, TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(drawable.getColorBackground()));

        graphics.setForegroundColor(TextColor.Factory.fromString(drawable.getColorForeground()));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(drawable.getPosition().getX(), drawable.getPosition().getY()), drawable.getImage());
    }
}
