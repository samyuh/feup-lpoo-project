package Controller.Interact;

import Controller.Level.LevelUpdateModel;
import Model.Elements.Coin;
import Model.Elements.ElementModel;

public class InteractCoin extends Interact {
    public InteractCoin(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.removeCoin((Coin) element);
        model.meltIce();
        model.move(position);
        //model.addPoints(10);
    }
}