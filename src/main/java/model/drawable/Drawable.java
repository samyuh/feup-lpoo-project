package model.drawable;

import model.Position;

public abstract class Drawable {
    protected String image;
    private String colorForeground;
    private String colorBackground;
    protected Position position;

    public Drawable(String image, String colorForeground, String colorBackground, Position position) {
        this.image = image;
        this.colorForeground = colorForeground;
        this.colorBackground = colorBackground;
        this.position = position;
    }

    public String getImage() {
        return image;
    }

    public String getColor() {
        return colorForeground;
    }

    public void setColor(String color) {this.colorForeground = color;}

    public String getColorBackground() {
        return colorBackground;
    }

    public void setColorBackground(String colorBackground) {
        this.colorBackground = colorBackground;
    }

    public Position getPosition() {
        return position;
    }

}
