package controller.level.interact.ice;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import model.drawable.element.ElementModel;
import model.drawable.element.ToughIce;

public class InteractToughIce extends Interact<ToughIce> {

    public InteractToughIce(ToughIce element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltIce();
        facade.move(position);
        facade.addScore(1,1);
    }
}
