package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelFacade;
import org.g70.model.Position;

public class MeltIce implements Melt {
    LevelFacade facade;

    public MeltIce(LevelFacade facade) {
        this.facade = facade;
    }
    
    @Override
    public void execute(Position pufflePos) {
        facade.removeIce(pufflePos);
        facade.addWater(pufflePos);
    }
}