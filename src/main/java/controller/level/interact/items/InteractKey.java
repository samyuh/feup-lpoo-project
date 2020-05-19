package controller.level.interact.items;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import model.drawable.element.Key;

public class InteractKey extends Interact<Key> {

    public InteractKey(Key element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.removeKeyLock();
        facade.meltIce();
        facade.move(position);
        facade.addScore(1,1);
    }
}
