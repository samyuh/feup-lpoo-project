package controller.interact;

import controller.level.LevelUpdateModel;
import model.drawable.element.ElementModel;

public class InteractToughIce extends Interact {

    public InteractToughIce(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.meltIce();
        model.move(position);
        model.addScore(1,1);
    }
}
