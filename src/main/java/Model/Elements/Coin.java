package Model.Elements;

import Controller.Interact.InteractCoin;
import Model.Position;

public class Coin extends ElementModel {
    public Coin(Position position) {
        super("$", "#FFFF33", position);

        this.setInteraction(new InteractCoin(this));
    }
}