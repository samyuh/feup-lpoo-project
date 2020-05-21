package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelItemsFacade;
import org.g70.model.Position;

public class StrategyEmpty implements Strategy {
    LevelItemsFacade facade;

    public StrategyEmpty(LevelItemsFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(Position pufflePos) {
        // When Puffle goes trough special blocks, like invisible walls
    }
}
