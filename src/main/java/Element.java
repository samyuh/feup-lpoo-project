import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    private Position position;

    public Element(Position position) {
        this.position = position;
    }

    public abstract void draw(TextGraphics graphics);

}
