import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    public Wall(int x, int y) {
        super(new Position(x,y));
    }

    public Position getPosition() {
        return super.getPosition();
    }

    public void setPosition(Position position) {
        super.setPosition(position);
    }

    public Wall(Position position) {
        super(position);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#8abde8"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "W");
    }
}

