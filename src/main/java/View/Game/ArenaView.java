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
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(model.getWidth(), model.getHeight()), ' ');

        // View Methods -> Code Smell
        DestinationView view1 = new DestinationView();
        HeroView view2 = new HeroView();
        WallView view3 = new WallView();
        IceView view4 = new IceView();

        view1.draw(model.getDestination(), graphics);
        view2.draw(model.getHero(), graphics);

        for (Wall wall : model.getWalls())
            view3.draw(wall, graphics);
        for (Ice ice : model.getFilled())
            view4.draw(ice, graphics);
    }
}
