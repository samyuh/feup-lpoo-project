package org.g70.view.handler;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class KeyHandler {
    public enum KEY {UP, RIGHT, DOWN, LEFT, CLOSE, NEXT, RESTART};

    public KeyHandler() {}

    public static KEY processKey(Screen screen) throws IOException {
        while (true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.ArrowUp) return KEY.UP;
            if (key.getKeyType() == KeyType.ArrowRight) return KEY.RIGHT;
            if (key.getKeyType() == KeyType.ArrowDown) return KEY.DOWN;
            if (key.getKeyType() == KeyType.ArrowLeft) return KEY.LEFT;
            if (key.getKeyType() == KeyType.EOF) return KEY.CLOSE;
            if (key.getKeyType() == KeyType.Character) {
                if(key.getCharacter().equals('n')) return KEY.NEXT;
                if(key.getCharacter().equals('r')) return KEY.RESTART;
                if(key.getCharacter().equals('q')) return KEY.CLOSE;
            }
        }
    }
}
