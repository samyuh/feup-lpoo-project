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
        if(m.isTeleportUsed()) return;
        m.addWater();
        m.move(position);
        m.addWater();
        position = m.getTeleportPosition((Teleport)element);
        m.move(position);
        m.setTeleportUsed(true);
        m.getTeleport1().setColor("#0000ff");
        m.getTeleport2().setColor("#0000ff");
        m.addScore(1);
    }
}
