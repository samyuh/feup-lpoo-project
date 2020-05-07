package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Elements.Ice;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractIce extends CommandInteract {

    public CommandInteractIce(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        m.removeIce((Ice) element);
        m.addWater();
        m.move(position);
        m.addPoints(1);
    }
}
