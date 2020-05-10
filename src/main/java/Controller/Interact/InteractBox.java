package Controller.Interact;


import Controller.Level.LevelController;
import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractBox extends Interact {
    public InteractBox(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelController model) {

        if(model.moveBox(model.findBoxDirection()) == 0) {
            element.setInteraction(new InteractStop(element));
        }
        else{ ;
            model.addWater();
            model.move(position);
            //model.addPoints(1);
        }

    }
}
