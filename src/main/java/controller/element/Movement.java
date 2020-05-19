package controller.element;

import model.Position;
import model.drawable.element.ElementModel;


public class Movement {
    protected ElementModel element;

    public Movement(ElementModel element) {
        this.element = element;
    }

    public Position moveUp() {
        return new Position(element.getPosition().getX(), element.getPosition().getY() - 1);
    }

    public Position moveDown() {
        return new Position(element.getPosition().getX(), element.getPosition().getY() + 1);
    }

    public Position moveRight() {
        return new Position(element.getPosition().getX() + 1, element.getPosition().getY());
    }

    public Position moveLeft() {
        return new Position(element.getPosition().getX() - 1, element.getPosition().getY());
    }

    public boolean atPosition(Position target) {
        return element.getPosition().equals(target);
    }
}
