package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelElementController;
import org.g70.model.Position;

public class MeltIce extends Melt {
    public MeltIce(LevelElementController facade) {
        super(facade);
    }
    
    @Override
    public void execute(Position pufflePos) {
        elementController.removeIce(pufflePos);
        elementController.addWater(pufflePos);
    }
}