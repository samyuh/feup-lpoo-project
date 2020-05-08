package Controller.Interact;


import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractBox extends Interact {
    public InteractBox(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        if(m.moveBox(m.findBoxDirection()) == 0) {
            element.setInteraction(new InteractStop(m, element));
        }
        else{ ;
            m.addWater();
            m.move(position);
            m.addPoints(1);
        }

    }
}
