package controller.level.interact.box;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import model.drawable.element.BoxFinalSquare;
import model.drawable.element.ElementModel;

public class InteractBoxFinalSquare extends Interact<BoxFinalSquare> {
    public InteractBoxFinalSquare(BoxFinalSquare element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltIce();
        facade.move(position);
    }
}
