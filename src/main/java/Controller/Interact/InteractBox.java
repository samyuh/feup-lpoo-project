package Controller.Interact;


import Controller.Level.LevelUpdateModel;
import Model.Elements.ElementModel;

public class InteractBox extends Interact {
    public InteractBox(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        if(model.moveBox(model.findBoxDirection()) == 0) {
            element.setInteraction(new InteractStop(element));
        }
        else{
            model.meltIce();
            model.move(position);
            model.addScore(1);
        }

    }
}
