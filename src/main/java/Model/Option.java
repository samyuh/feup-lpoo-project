package Model;

public class Option {
    String name;
    String color;
    Position position;
    public Option(String name, String color, Position p) {
        this.name = name;
        this.color = color;
        this.position = p;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }


}
