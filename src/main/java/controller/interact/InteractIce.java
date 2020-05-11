package controller.interact;

import controller.level.LevelUpdateModel;
import model.drawable.element.ElementModel;
import model.drawable.element.Ice;

public class InteractIce extends Interact {

    public InteractIce(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.removeIce((Ice) element);
        model.meltIce();
        model.move(position);
        model.addScore(1);
    }
}
