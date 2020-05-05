package Controller.Interact;

import Controller.Element.HeroMovement;
import Model.Elements.ElementModel;
import Model.Elements.Hero;
import Model.Elements.Wall;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractStop extends CommandInteract {

    public CommandInteractStop(LevelModel m, ElementModel element, Position editor) {
        super(m, element, editor);
    }

    @Override
    public void execute() {
        // if Wall or ice is found, nothing should be done
    }
}
