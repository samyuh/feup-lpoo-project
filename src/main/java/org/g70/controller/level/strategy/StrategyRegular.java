package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelItemsFacade;
import org.g70.model.Position;

public class StrategyRegular implements Strategy {
    LevelItemsFacade facade;

    public StrategyRegular(LevelItemsFacade facade) {
        this.facade = facade;
    }
    
    @Override
    public void execute(Position pufflePos) {
        facade.removeIce(pufflePos);
        facade.addWater(pufflePos);
    }
}