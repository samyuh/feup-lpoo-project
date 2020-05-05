package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractDestination extends CommandInteract {
    public CommandInteractDestination(LevelModel m, ElementModel element, Position position) {
        super(m, element, position);
    }

    @Override
    public void execute() {
        m.addWater();
        m.move(position);
        m.addPoints(1);
    }
}
