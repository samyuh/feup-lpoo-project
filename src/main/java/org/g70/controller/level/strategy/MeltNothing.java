package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelElementController;
import org.g70.model.Position;

public class MeltNothing extends Melt {
    public MeltNothing(LevelElementController elementController) {
        super(elementController);
    }

    @Override
    public void execute(Position pufflePos) {
    }
}
