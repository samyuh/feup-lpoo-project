package model.drawable;

import model.Position;

public abstract class Drawable {
    protected String image;
    protected String color;
    protected String colorBackground;

    public Drawable(String image, String color, Position position) {
        this.image = image;
        this.color = color;
        this.position = position;
    }

    public void setColor(String color) {this.color = color;}

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

}
