package model.drawable.element;

import controller.level.interact.level.InteractStop;
import model.Position;

public class Water extends ElementModel {
    public Water(Position position) {
        super("W", "#0056AC",position);

        this.setInteraction(new InteractStop(this));
    }
}
