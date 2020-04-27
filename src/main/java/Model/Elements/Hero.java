package Model.Elements;

import Model.Position;

public class Hero extends ElementModel {
    public Hero(Position position) {
        super("H", "#000000", position);
    }

    public Position moveUp() {
        return new Position(super.getPosition().getX(), super.getPosition().getY() - 1);
    }

    public Position moveDown() {
        return new Position(super.getPosition().getX(), super.getPosition().getY() + 1);
    }

    public Position moveRight() {
        return new Position(super.getPosition().getX() + 1, super.getPosition().getY());
    }

    public Position moveLeft() {
        return new Position(super.getPosition().getX() - 1, super.getPosition().getY());
    }
}
