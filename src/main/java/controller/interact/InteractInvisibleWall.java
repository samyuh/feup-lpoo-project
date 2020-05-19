package controller.interact;

import controller.level.LevelUpdateModel;
import model.drawable.element.ElementModel;
import model.drawable.element.InvisibleWall;

public class InteractInvisibleWall extends Interact {
    public InteractInvisibleWall(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        if(!model.isSecretFound()){
            model.meltIce();
            model.setSecretFound(true);
        }

        element.setInteraction(new InteractStop(element));
        model.move(position);
        model.addScore(1,1);
    }
}
