package Model.Elements;

import Controller.Interact.CommandInteract;
import Controller.Interact.CommandInteractCoin;
import Model.Position;

public class Coin extends ElementModel {
    public Coin(Position position) {
        super("C", "#FFFF33", position);
    }
}