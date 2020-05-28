package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelFacade;
import org.g70.model.Position;

public class MeltNothing implements Melt {
    LevelFacade facade;

    public MeltNothing(LevelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(Position pufflePos) {
    }
}
