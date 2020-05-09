package Model.Elements;

import Controller.Interact.InteractToughIce;
import Model.Position;

public class ToughIce extends ElementModel {
    public ToughIce(Position position) {
        super("\u2588", "#ffffff", position);

        this.setInteraction(new InteractToughIce(this));
    }
}
