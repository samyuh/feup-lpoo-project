package org.g70.model.drawable.element;
import org.g70.controller.level.interact.Interact;
import org.g70.model.drawable.Drawable;
import org.g70.model.Position;

public abstract class ElementModel extends Drawable {
    protected Interact interaction;

    public ElementModel(String image, String colorForeground, String colorBackground, Position position) {
        super(image, colorForeground, colorBackground, position);
    }

    public Position getPosition() { return position; }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setInteraction(Interact command) {
        this.interaction = command;
    }

    public Interact getInteraction() {
        return interaction;
    }
}
