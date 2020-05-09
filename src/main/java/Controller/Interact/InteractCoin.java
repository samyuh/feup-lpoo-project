package Controller.Interact;

import Controller.Level.LevelController;
import Model.Elements.Coin;
import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractCoin extends Interact {
    public InteractCoin(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelController model) {
        model.removeCoin((Coin) element);
        model.addWater();
        model.move(position);
        //model.addPoints(10);
    }
}