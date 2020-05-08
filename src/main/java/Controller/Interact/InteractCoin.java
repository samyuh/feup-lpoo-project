package Controller.Interact;

import Model.Elements.Coin;
import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractCoin extends Interact {
    public InteractCoin(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        m.removeCoin((Coin) element);
        m.addWater();
        m.move(position);
        m.addScore(10);
    }
}