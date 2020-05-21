package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelItemsFacade;
import org.g70.model.Position;

public class StrategyToughIce implements Strategy {
    LevelItemsFacade facade;

    public StrategyToughIce(LevelItemsFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(Position pufflePos) {
        facade.removeToughIce(pufflePos);
        facade.addIce(pufflePos);
    }
}
