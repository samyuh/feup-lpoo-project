package model.drawable.element;

import controller.interact.InteractStop;
import model.Position;

public class Wall extends ElementModel {
    public Wall(Position position) {
        super("\u2588", "#0065c6", position);

        this.setInteraction(new InteractStop(this));
    }
}
