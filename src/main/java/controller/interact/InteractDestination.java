package controller.interact;

import controller.level.LevelUpdateModel;
import model.drawable.element.ElementModel;

public class InteractDestination extends Interact {
    public InteractDestination(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.meltIce();
        model.move(position);
        model.addScore(1,1);
    }
}
