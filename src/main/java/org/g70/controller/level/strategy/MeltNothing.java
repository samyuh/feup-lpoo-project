package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelElementController;
import org.g70.model.Position;

public class MeltNothing implements Melt {
    LevelElementController facade;

    public MeltNothing(LevelElementController facade) {
        this.facade = facade;
    }

    @Override
    public void execute(Position pufflePos) {
    }
}
