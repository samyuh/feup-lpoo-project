package Controller.Interact;


import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractBox extends Interact {
    public InteractBox(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        if(model.moveBox(model.findBoxDirection()) == 0) {
            element.setInteraction(new InteractStop(model, element));
        }
        else{ ;
            model.addWater();
            model.move(position);
            model.addPoints(1);
        }
    }
}
