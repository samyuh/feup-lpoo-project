package View.Game;

import Model.Elements.*;
import Model.Game.Arena;
import View.Element.*;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ArenaView {
    public void draw(Arena model, TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(model.getWidth(), model.getHeight()), ' ');

        ElementView view = new ElementView();

        for (Wall wall : model.getWalls())
            view.draw(wall, graphics);
        for (Ice ice : model.getFilled())
            view.draw(ice, graphics);
        for (Coin coin : model.getCoins())
            view.draw(coin, graphics);
        for (White white : model.getWhite())
            view.draw(white,graphics);
        if(model.getKey() != null)
            view.draw(model.getKey(), graphics);
        if(model.getLock() != null)
            view.draw(model.getLock(), graphics);
        view.draw(model.getPoints(),graphics);

        view.draw(model.getDestination(), graphics);
        view.draw(model.getHero(), graphics);
    }
}
