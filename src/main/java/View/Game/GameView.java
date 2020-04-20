package View.Game;

import Model.Game.Arena;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class GameView {
    public void draw(Arena arena, Screen screen) throws IOException {
        screen.clear();
        ArenaView view = new ArenaView();
        view.draw(arena, screen.newTextGraphics());
        screen.refresh();
    }
}
