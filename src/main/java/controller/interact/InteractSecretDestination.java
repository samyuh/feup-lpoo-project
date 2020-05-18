package controller.interact;

import controller.level.LevelUpdateModel;
import model.drawable.element.Destination;
import model.drawable.element.ElementModel;

public class InteractSecretDestination extends Interact {
    public InteractSecretDestination(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.move(position);
        model.addScore(1,1);
        model.startSecretLevel();
    }
}
