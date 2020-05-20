package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractMove;
import org.g70.controller.level.puffleinteract.PuffleInteractCoin;
import org.g70.model.Position;

public class Coin extends ElementModel {
    public Coin(Position position) {
        super("$", "#FFFF33", position);

        this.setPuffleInteraction(new PuffleInteractCoin(this));

        this.setBoxInteraction(new BoxInteractMove(this));
    }
}