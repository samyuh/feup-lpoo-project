package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractIce extends CommandInteract {

    public CommandInteractIce(LevelModel m, ElementModel element, Position position) {
        super(m, element, position);
    }

    @Override
    public void execute() {
        m.addWater();
        m.move(position);
        m.addPoints(1);
    }
}
