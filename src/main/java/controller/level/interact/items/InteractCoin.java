package controller.level.interact.items;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import model.drawable.element.Coin;
import model.drawable.element.ElementModel;

public class InteractCoin extends Interact<Coin> {
    public InteractCoin(Coin element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.removeCoin(element);
        facade.meltIce();
        facade.move(position);
        facade.addScore(1,10);
    }
}