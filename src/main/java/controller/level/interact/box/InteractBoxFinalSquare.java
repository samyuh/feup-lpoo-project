package controller.level.interact.box;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.strategy.StrategyEmpty;
import model.drawable.element.BoxFinalSquare;

public class InteractBoxFinalSquare extends Interact<BoxFinalSquare> {

    public InteractBoxFinalSquare(BoxFinalSquare element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);

        facade.setStrategy(new StrategyEmpty(facade));
    }
}
