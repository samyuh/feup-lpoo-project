package controller.interact;

import controller.level.LevelUpdateModel;
import model.drawable.element.Coin;
import model.drawable.element.ElementModel;

public class InteractCoin extends Interact {
    public InteractCoin(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.removeCoin((Coin) element);
        model.meltIce();
        model.move(position);
        model.addScore(1,10);
    }
}