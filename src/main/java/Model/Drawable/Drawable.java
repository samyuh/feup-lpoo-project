package Model.Drawable;

import Model.Position;

public abstract class Drawable {
    protected String image;
    protected String color;

    public String getImage() {
        return image;
    }

    public String getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    protected Position position;

    public Drawable(String image, String color, Position position) {
        this.image = image;
        this.color = color;
        this.position = position;
    }
}
