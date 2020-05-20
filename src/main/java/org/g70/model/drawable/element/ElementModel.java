package org.g70.model.drawable.element;
import org.g70.controller.level.boxinteract.BoxInteract;
import org.g70.controller.level.puffleinteract.PuffleInteract;
import org.g70.model.drawable.Drawable;
import org.g70.model.Position;

public abstract class ElementModel extends Drawable {
    private PuffleInteract puffleInteraction;
    private BoxInteract boxInteraction;

    public ElementModel(String image, String colorForeground, Position position) {
        super(image, colorForeground, "#8dc5f0", position);
    }

    public Position getPosition() { return position; }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPuffleInteraction(PuffleInteract command) {
        this.puffleInteraction = command;
    }

    public PuffleInteract getPuffleInteraction() {
        return puffleInteraction;
    }

    public void setBoxInteraction(BoxInteract commandBox) {this.boxInteraction = commandBox;}

    public BoxInteract getBoxInteraction() {return boxInteraction;}
}
