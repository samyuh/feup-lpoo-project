package View.Game;

import Model.Elements.Ice;
import Model.Elements.Wall;
import Model.Game.Arena;
import View.Element.*;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class ArenaView {
    public void draw(Arena model, TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(model.width, model.height), ' ');

        // View Methods -> Code Smell
        DestinationView view1 = new DestinationView();
        HeroView view2 = new HeroView();
        WallView view3 = new WallView();
        IceView view4 = new IceView();

        view1.draw(model.destination, graphics);
        view2.draw(model.hero, graphics);

        for (Wall wall : model.walls)
            view3.draw(wall, graphics);
        for (Ice ice : model.filled)
            view4.draw(ice, graphics);
    }
}
