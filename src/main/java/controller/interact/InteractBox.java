package controller.interact;


import controller.level.LevelUpdateModel;
import model.drawable.element.ElementModel;

public class InteractBox extends Interact {
    public InteractBox(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        if(!model.moveBox()){
            element.setInteraction(new InteractStop(element));
        }
        else{
            model.meltIce();
            model.move(position);
            model.addScore(1,1);
        }

    }
}
