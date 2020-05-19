package controller.level.interact.level;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.strategy.StrategyRegular;
import model.drawable.element.Destination;
import model.drawable.element.ElementModel;
import model.drawable.element.SecretDestination;

public class InteractSecretDestination extends Interact<SecretDestination> {
    public InteractSecretDestination(SecretDestination element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.move(position);
        facade.addScore(1,1);
        controller.secretLevel();

        facade.setStrategy(new StrategyRegular(facade));
    }
}
