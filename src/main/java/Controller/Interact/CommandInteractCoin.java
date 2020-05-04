package Controller.Interact;

import Controller.Element.HeroMovement;
import Model.Elements.Coin;
import Model.Elements.ElementModel;
import Model.Elements.Hero;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractCoin extends CommandInteract {


    public CommandInteractCoin(ElementModel element, Editor editor) {
        super(element,editor);
    }


    @Override
    public void execute() {
        editor.removeCoin((Coin) element);
        editor.addWater();
        editor.move();
        editor.addPoints(10);
    }
}