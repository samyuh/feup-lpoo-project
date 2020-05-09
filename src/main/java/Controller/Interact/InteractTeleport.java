package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Elements.Teleport;
import Model.Level.LevelModel;

public class InteractTeleport extends Interact {
    public InteractTeleport(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        if(model.isTeleportUsed()) return;
        model.addWater();
        model.move(position);
        model.addWater();
        position = model.getTeleportPosition((Teleport) element);
        model.move(position);
        model.setTeleportUsed(true);
        model.getTeleport1().setColor("#0000ff");
        model.getTeleport2().setColor("#0000ff");
        model.addPoints(1);
    }
}
