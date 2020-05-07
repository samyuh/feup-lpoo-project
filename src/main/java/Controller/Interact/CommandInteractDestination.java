package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractDestination extends CommandInteract {
    public CommandInteractDestination(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        m.addWater();
        m.move(position);
        m.addPoints(1);
    }
}
