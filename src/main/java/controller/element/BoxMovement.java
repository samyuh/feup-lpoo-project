package controller.element;

import model.Position;
import model.drawable.element.Box;
import model.drawable.element.Puffle;

import static controller.level.LevelUpdateModel.*;
import static controller.level.LevelUpdateModel.DIRECTION.*;

public class BoxMovement extends Movement{

    public BoxMovement(Box box) {
        super(box);
    }

    public Position moveDirection(DIRECTION direction){
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

    public DIRECTION pufflePushedDirection(Puffle puffle){
        if(puffle.getPosition().equals(moveLeft())) return RIGHT;
        if(puffle.getPosition().equals(moveRight())) return LEFT;
        if(puffle.getPosition().equals(moveDown())) return UP;
        return DOWN;
    }
}
