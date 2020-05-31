package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelElementController;
import org.g70.model.Position;

public class MeltDoubleIce extends Melt {
    public MeltDoubleIce(LevelElementController elementController) {
        super(elementController);
    }

    @Override
    public void execute(Position pufflePos) {
        elementController.removeToughIce(pufflePos);
        elementController.addIce(pufflePos);
    }
}
