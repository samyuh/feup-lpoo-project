package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelElementController;
import org.g70.model.Position;

public class MeltDoubleIce implements Melt {
    LevelElementController facade;

    public MeltDoubleIce(LevelElementController facade) {
        this.facade = facade;
    }

    @Override
    public void execute(Position pufflePos) {
        facade.removeToughIce(pufflePos);
        facade.addIce(pufflePos);
    }
}
