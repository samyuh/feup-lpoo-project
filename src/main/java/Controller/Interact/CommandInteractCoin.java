package Controller.Interact;

import Controller.Element.HeroMovement;
import Model.Elements.Coin;
import Model.Elements.ElementModel;
import Model.Elements.Hero;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractCoin extends CommandInteract {


    public CommandInteractCoin(LevelModel m, ElementModel element, Position editor) {
        super(m, element,editor);
    }

    @Override
    public void execute() {
        m.removeCoin((Coin) element);
        m.addWater();
        m.move(position);
        m.addPoints(10);
    }
}