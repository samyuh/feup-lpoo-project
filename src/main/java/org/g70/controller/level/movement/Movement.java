package org.g70.controller.level.movement;

import org.g70.controller.level.LevelItemsFacade;
import org.g70.model.Position;
import org.g70.model.drawable.element.ElementModel;

public abstract class Movement {
    protected ElementModel element;
    protected LevelItemsFacade.ORIENTATION dir;

    public Movement(ElementModel element) {
        this.element = element;
    }

    public LevelItemsFacade.ORIENTATION getDir() {
        return dir;
    }

    public void setDir(LevelItemsFacade.ORIENTATION n) {
        this.dir = n;
    }

    public Position moveUp() {
        dir = LevelItemsFacade.ORIENTATION.UP;
        return new Position(element.getPosition().getX(), element.getPosition().getY() - 1);
    }

    public Position moveDown() {
        dir = LevelItemsFacade.ORIENTATION.DOWN;
        return new Position(element.getPosition().getX(), element.getPosition().getY() + 1);
    }

    public Position moveRight() {
        dir = LevelItemsFacade.ORIENTATION.RIGHT;
        return new Position(element.getPosition().getX() + 1, element.getPosition().getY());
    }

    public Position moveLeft() {
        dir = LevelItemsFacade.ORIENTATION.LEFT;
        return new Position(element.getPosition().getX() - 1, element.getPosition().getY());
    }

    public boolean atPosition(Position target) {
        return element.getPosition().equals(target);
    }
}
