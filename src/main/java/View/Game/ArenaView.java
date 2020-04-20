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

        // View Methods -> Code Smell
        DestinationView view1 = new DestinationView();
        HeroView view2 = new HeroView();
        WallView view3 = new WallView();
        IceView view4 = new IceView();
        CoinView view5 = new CoinView();
        KeyView view6 = new KeyView();
        LockView view7 = new LockView();
        PointsView view8 = new PointsView();
        WhiteView view9 = new WhiteView();
        TeleportView view10 = new TeleportView();


        for (Wall wall : model.getWalls())
            view3.draw(wall, graphics);
        for (Ice ice : model.getFilled())
            view4.draw(ice, graphics);
        for (Coin coin : model.getCoins())
            view5.draw(coin, graphics);
        for (White white : model.getWhite())
            view9.draw(white,graphics);
        if(model.getKey() != null)
            view6.draw(model.getKey(), graphics);
        if(model.getLock() != null)
            view7.draw(model.getLock(), graphics);
        if(model.getTeleport1() != null)
            view10.draw(model.getTeleport1(), graphics);
        if(model.getTeleport2() != null)
            view10.draw(model.getTeleport2(), graphics);
        view8.draw(model.getPoints(),graphics);


        view1.draw(model.getDestination(), graphics);
        view2.draw(model.getHero(), graphics);

    }
}
