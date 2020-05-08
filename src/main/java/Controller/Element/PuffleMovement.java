package Controller.Element;

import Model.Elements.Puffle;
import Model.Position;

public class PuffleMovement {
    Puffle puffle;

    public PuffleMovement(Puffle h) {
        this.puffle = h;
    }

    public Position moveUp() {
        return new Position(puffle.getPosition().getX(), puffle.getPosition().getY() - 1);
    }

    public Position moveDown() {
        return new Position(puffle.getPosition().getX(), puffle.getPosition().getY() + 1);
    }

    public Position moveRight() {
        return new Position(puffle.getPosition().getX() + 1, puffle.getPosition().getY());
    }

    public Position moveLeft() {
        return new Position(puffle.getPosition().getX() - 1, puffle.getPosition().getY());
    }

    public boolean atPosition(Position target) {
        return puffle.getPosition().equals(target);
    }

}
