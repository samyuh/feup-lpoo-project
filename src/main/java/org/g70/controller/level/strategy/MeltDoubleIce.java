package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelFacade;
import org.g70.model.Position;

public class MeltDoubleIce implements Melt {
    LevelFacade facade;

    public MeltDoubleIce(LevelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(Position pufflePos) {
        facade.removeToughIce(pufflePos);
        facade.addIce(pufflePos);
    }
}
