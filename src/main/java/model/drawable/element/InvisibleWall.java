package model.drawable.element;

import controller.level.interact.level.InteractInvisibleWall;
import model.Position;

public class InvisibleWall extends ElementModel {
    public InvisibleWall(Position position) {
        super("\u2588", "#0065c6", position);
        this.setInteraction(new InteractInvisibleWall(this));
    }
}
