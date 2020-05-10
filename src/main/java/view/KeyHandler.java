package view;


import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class KeyHandler {
    public enum DIRECTION {UP, RIGHT, DOWN, LEFT, CLOSE, NEXT, RESTART};

    public KeyHandler() {}

    public static DIRECTION processKey(Screen screen) throws IOException {
        while (true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.ArrowUp) return DIRECTION.UP;
            if (key.getKeyType() == KeyType.ArrowRight) return DIRECTION.RIGHT;
            if (key.getKeyType() == KeyType.ArrowDown) return DIRECTION.DOWN;
            if (key.getKeyType() == KeyType.ArrowLeft) return DIRECTION.LEFT;
            if (key.getKeyType() == KeyType.EOF) return DIRECTION.CLOSE;
            if (key.getKeyType() == KeyType.Character) {
                if(key.getCharacter().equals('n')) return DIRECTION.NEXT;
                if(key.getCharacter().equals('r')) return DIRECTION.RESTART;
                if(key.getCharacter().equals('q')) return DIRECTION.CLOSE;
            }
        }
    }
}
