package org.g70.controller.level.movement;

import org.g70.model.Position;
import org.g70.model.drawable.element.ElementModel;

public abstract class Movement {
    public enum ORIENTATION {UP, RIGHT, DOWN, LEFT}

    protected ElementModel element;
    protected ORIENTATION orientationFaced;

    public Movement(ElementModel element) {
        this.element = element;
    }

    public ORIENTATION getOrientationFaced() {
        return orientationFaced;
    }

    public Position moveUp() {
        orientationFaced = ORIENTATION.UP;
        return new Position(element.getPosition().getX(), element.getPosition().getY() - 1);
    }

    public Position moveDown() {
        orientationFaced = ORIENTATION.DOWN;
        return new Position(element.getPosition().getX(), element.getPosition().getY() + 1);
    }

    public Position moveRight() {
        orientationFaced = ORIENTATION.RIGHT;
        return new Position(element.getPosition().getX() + 1, element.getPosition().getY());
    }

    public Position moveLeft() {
        orientationFaced = ORIENTATION.LEFT;
        return new Position(element.getPosition().getX() - 1, element.getPosition().getY());
    }

    public Position getPosition() {
        return element.getPosition();
    }

    public boolean atPosition(Position target) {
        return element.getPosition().equals(target);
    }
}
