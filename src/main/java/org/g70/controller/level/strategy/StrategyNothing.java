package org.g70.controller.level.strategy;

import org.g70.controller.level.LevelFacade;
import org.g70.model.Position;

public class StrategyNothing implements MeltStrategy {
    LevelFacade facade;

    public StrategyNothing(LevelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(Position pufflePos) {
        // When Puffle goes trough special blocks, like invisible walls
    }
}
