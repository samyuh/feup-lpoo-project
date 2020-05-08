package Model.Elements;
import Controller.Interact.Interact;
import Model.Position;

public abstract class ElementModel {
    private Interact command;
    private Position position;
    private String image;
    private String color;

    public ElementModel(String image, String color, Position position) {
        this.image = image;
        this.color = color;
        this.position = position;
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
