package Controller.Interact;

import Controller.Element.HeroMovement;
import Model.Elements.ElementModel;
import Model.Elements.Hero;
import Model.Elements.Wall;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractStop extends CommandInteract {

    public CommandInteractStop(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        // if wall, water, or used teleport is found, nothing should be done
    }
}
