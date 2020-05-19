package controller.level.interact.ice;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import model.drawable.element.ElementModel;
import model.drawable.element.Ice;

public class InteractIce extends Interact<Ice> {

    public InteractIce(Ice element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.removeIce(element);
        facade.meltIce();
        facade.move(position);
        facade.addScore(1,1);
    }
}
