package model.elements;
import controller.interact.Interact;
import model.drawable.Drawable;
import model.Position;

public abstract class ElementModel extends Drawable {
    private Interact command;


    public ElementModel(String image, String color, Position position) {
        super(image,color,position);
    }

    public Position getPosition() { return position; }

    public String getColor() { return color; }

    public String getImage() { return image; }

    public void setColor(String color) {this.color = color;}

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
