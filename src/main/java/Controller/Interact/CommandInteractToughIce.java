package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractToughIce extends CommandInteract {

    public CommandInteractToughIce(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        m.addWater();
        m.move(position);
        m.addPoints(1);
    }
}
