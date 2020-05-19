package model.drawable.element;
import controller.level.interact.Interact;
import model.drawable.Drawable;
import model.Position;

public abstract class ElementModel extends Drawable {
    private Interact command;

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
}
