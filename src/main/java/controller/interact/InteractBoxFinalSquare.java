package controller.interact;

import controller.level.LevelUpdateModel;
import model.drawable.element.ElementModel;

public class InteractBoxFinalSquare extends Interact {
    public InteractBoxFinalSquare(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.meltIce();
        model.move(position);
    }
}
