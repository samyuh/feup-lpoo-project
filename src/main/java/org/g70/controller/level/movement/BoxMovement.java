package org.g70.controller.level.movement;

import org.g70.model.Position;
import org.g70.model.drawable.element.Box;
import org.g70.model.drawable.element.Puffle;


public class BoxMovement extends Movement{
    public enum ORIENTATION {UP, RIGHT, DOWN, LEFT};

    public BoxMovement(Box box) {
        super(box);
    }

    public Position moveDirection(ORIENTATION direction){
        switch(direction){
            case UP:
                return moveUp();
            case DOWN:
                return moveDown();
            case LEFT:
                return moveLeft();
            case RIGHT:
                return moveRight();
            default:
                return null;
        }
    }

    public ORIENTATION pufflePushedDirection(Puffle puffle){
        if(puffle.getPosition().equals(moveLeft())) return ORIENTATION.RIGHT;
        if(puffle.getPosition().equals(moveRight())) return ORIENTATION.LEFT;
        if(puffle.getPosition().equals(moveDown())) return ORIENTATION.UP;
        return ORIENTATION.DOWN;
    }
}
