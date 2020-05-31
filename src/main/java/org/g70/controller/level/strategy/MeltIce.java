package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelElementController;
import org.g70.model.Position;

public class MeltIce implements Melt {
    LevelElementController facade;

    public MeltIce(LevelElementController facade) {
        this.facade = facade;
    }
    
    @Override
    public void execute(Position pufflePos) {
        facade.removeIce(pufflePos);
        facade.addWater(pufflePos);
    }
}