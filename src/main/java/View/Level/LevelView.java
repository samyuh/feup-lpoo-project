package View.Level;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;
import View.Element.ElementView;
import View.ScreenView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.List;

public class LevelView {
    public enum DIRECTION {UP, RIGHT, DOWN, LEFT, CLOSE, NEXT,RESTART};

    Screen screen;

    public LevelView(ScreenView gui) {
        this.screen = gui.getScreen();
    }

    public DIRECTION processKey() throws IOException {
        while (true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.ArrowUp) return DIRECTION.UP;
            if (key.getKeyType() == KeyType.ArrowRight) return DIRECTION.RIGHT;
            if (key.getKeyType() == KeyType.ArrowDown) return DIRECTION.DOWN;
            if (key.getKeyType() == KeyType.ArrowLeft) return DIRECTION.LEFT;
            if (key.getKeyType() == KeyType.EOF) return DIRECTION.CLOSE;
            if (key.getKeyType() == KeyType.Character){
                if(key.getCharacter().equals('n')) return DIRECTION.NEXT;
                if(key.getCharacter().equals('r')) return DIRECTION.RESTART;
                if(key.getCharacter().equals('q')) return DIRECTION.CLOSE;
            }
        }
    }

    public void draw(LevelModel levelModel) throws IOException {
        this.screen.clear();
        drawLevel(levelModel, screen.newTextGraphics());
        this.screen.refresh();
    }

    public void drawLevel(LevelModel model, TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 24), ' ');

        ElementView view = new ElementView();

        List<ElementModel> elements;
        elements = model.getAll();

        for(ElementModel element : elements)
            view.draw(element, graphics);
    }
}
