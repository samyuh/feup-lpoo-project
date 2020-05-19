package model.drawable.element;

import controller.interact.InteractInvisibleWall;
import controller.interact.InteractStop;
import model.Position;

public class InvisibleWall extends ElementModel {
    public InvisibleWall(Position position) {
        super("\u2588", "#0065c6", position);
        this.setInteraction(new InteractInvisibleWall(this));
    }
}
