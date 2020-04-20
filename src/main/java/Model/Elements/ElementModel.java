package Model.Elements;
import Model.Game.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class ElementModel {
    private Position position;

    public ElementModel(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
