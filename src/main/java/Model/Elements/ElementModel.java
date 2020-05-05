package Model.Elements;
import Controller.Interact.CommandInteract;
import Model.Position;

public abstract class ElementModel {
    private CommandInteract command;
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

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setInteraction(CommandInteract command) {
        this.command = command;
    }

    public CommandInteract getInteraction() {
        return command;
    }
}
