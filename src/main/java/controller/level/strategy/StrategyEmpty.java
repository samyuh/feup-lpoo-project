package controller.level.strategy;

import controller.level.LevelFacade;
import model.Position;

public class StrategyEmpty implements Strategy {
    LevelFacade facade;

    public StrategyEmpty(LevelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(Position pufflePos) {
        // When Puffle goes trough special blocks, like invisible walls
    }
}
