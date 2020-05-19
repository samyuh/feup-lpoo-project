package controller.level.strategy;

import controller.level.LevelFacade;
import model.Position;

import java.util.logging.Level;

public class StrategyRegular implements Strategy {
    LevelFacade facade;

    public StrategyRegular(LevelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute(Position pufflePos) {
        facade.removeIce(pufflePos);
        facade.addWater(pufflePos);
    }
}