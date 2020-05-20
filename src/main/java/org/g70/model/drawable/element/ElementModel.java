package org.g70.model.drawable.element;
import org.g70.controller.level.boxInteract.BoxInteract;
import org.g70.controller.level.interact.Interact;
import org.g70.model.drawable.Drawable;
import org.g70.model.Position;

public abstract class ElementModel extends Drawable {
    private Interact command;
    private BoxInteract commandBox;

    public ElementModel(String image, String colorForeground, Position position) {
        super(image, colorForeground, "#8dc5f0", position);
    }

    public Position getPosition() { return position; }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setInteraction(Interact command) {
        this.command = command;
    }

    public Interact getInteraction() {
        return command;
    }

    public void setBoxInteraction(BoxInteract commandBox) {this.commandBox = commandBox;}

    public BoxInteract getBoxInteraction() {return commandBox;}
}
