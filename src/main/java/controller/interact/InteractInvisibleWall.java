package controller.interact;

import controller.level.LevelUpdateModel;
import model.drawable.element.ElementModel;

public class InteractInvisibleWall extends Interact {
    public InteractInvisibleWall(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.removeInvisibleWall();
        model.move(position);
    }
}
