package Controller.Interact;

import Controller.Element.HeroMovement;
import Model.Elements.ElementModel;
import Model.Elements.Hero;
import Model.Elements.Wall;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractStop extends CommandInteract {

    public CommandInteractStop(ElementModel element, Editor editor) {
        super(element,editor);
    }

    @Override
    public void execute() {
        //Whe a wall is found, nothing should be done
    }
}
