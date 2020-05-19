package controller.level.strategy;

import controller.level.LevelFacade;
import model.Position;

public class StrategyToughIce implements Strategy {
    LevelFacade facade;

    public StrategyToughIce(LevelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(Position pufflePos) {
        facade.removeToughIce(pufflePos);
        facade.addIce(pufflePos);
    }
}
