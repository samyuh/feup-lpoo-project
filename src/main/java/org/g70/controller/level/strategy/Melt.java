package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelElementController;
import org.g70.model.Position;

public abstract class Melt {
    protected LevelElementController elementController;

    Melt(LevelElementController elementController) {
        this.elementController = elementController;
    }

    public abstract void execute(Position pufflePos);
}
