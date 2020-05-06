package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Elements.Teleport;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractTeleport extends CommandInteract{
    public CommandInteractTeleport(LevelModel m, ElementModel element, Position position) {
        super(m, element, position);
    }

    @Override
    public void execute() {
        if(m.isTeleportUsed()) return;
        m.addWater();
        position = m.getTeleportPosition((Teleport)element);
        m.move(position);
        m.setTeleportUsed(true);
        m.addPoints(1);
    }
}
