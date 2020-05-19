package controller.level.interact.box;


import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.interact.level.InteractStop;
import controller.level.strategy.StrategyRegular;
import model.drawable.element.Box;

public class InteractBox extends Interact<Box> {

    public InteractBox(Box element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        if(facade.moveBox()) {
            facade.meltPreviousIce();

            facade.move(position);
            facade.addScore(1,1);

            element.setInteraction(new InteractBox(element));

            facade.setStrategy(new StrategyRegular(facade));
        }
        else {
            element.setInteraction(new InteractStop(element));
        }
    }
}
