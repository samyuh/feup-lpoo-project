package controller.level.interact.level;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import model.drawable.element.Destination;
import model.drawable.element.ElementModel;
import sun.security.krb5.internal.crypto.Des;

public class InteractDestination extends Interact<Destination> {
    public InteractDestination(Destination element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltIce();
        facade.move(position);
        facade.addScore(1,1);
        controller.gameWon();
    }
}
