package model.drawable.element;
import controller.interact.Interact;
import model.drawable.Drawable;
import model.Position;

public abstract class ElementModel extends Drawable {
    private Interact command;

    public ElementModel(String image, String color, Position position) {
        super(image,color,position);
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
