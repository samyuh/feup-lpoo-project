package org.g70.model.drawable.element.movable;

import org.g70.model.Position;
import org.g70.model.drawable.element.ElementModel;

public abstract class MovableElement extends ElementModel {
    private int x;
    private int y;

    public MovableElement(String image, String colorForeground, Position position) {
        super(image, colorForeground, "#8dc5f0", position);
    }

    public int lastDisplacementX() {
        return x;
    }

    public int lastDisplacementY() {
        return y;
    }

    public Position moveDisplacement(int x, int y) {
        return new Position(position.getX() + x, position.getY() + y);
    }

    public Position moveUp() {
        x = 0;
        y = -1;
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown() {
        x = 0;
        y = 1;
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveRight() {
        x = 1;
        y = 0;
        return new Position(position.getX() + 1, position.getY());
    }

    public Position moveLeft() {
        x = -1;
        y = 0;
        return new Position(position.getX() - 1, position.getY());
    }
}
