package Controller.Interact;

import Model.Elements.Coin;
import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class CommandInteractCoin extends CommandInteract {
    public CommandInteractCoin(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        m.removeCoin((Coin) element);
        m.addWater();
        m.move(position);
        m.addPoints(10);
    }
}