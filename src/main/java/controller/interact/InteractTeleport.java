package controller.interact;

import controller.level.LevelUpdateModel;
import model.elements.ElementModel;
import model.elements.Teleport;

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
        model.getTeleport1().setColor("#0000ff");
        model.getTeleport2().setColor("#0000ff");
        model.addScore(1);
    }
}
