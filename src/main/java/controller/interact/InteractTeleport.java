package controller.interact;

import controller.level.LevelUpdateModel;
import model.drawable.element.ElementModel;
import model.drawable.element.Teleport;

public class InteractTeleport extends Interact {
    public InteractTeleport(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        if(model.isTeleportUsed()) return;
        model.meltIce();
        model.move(position);
        model.meltIce();
        position = model.getTeleportPosition((Teleport)element);
        model.move(position);
        model.setTeleportUsed(true);
        model.addScore(1,1);
    }
}
