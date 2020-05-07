package Controller.Interact;

import Controller.Element.HeroMovement;
import Model.Elements.ElementModel;
import Model.Elements.Hero;
import Model.Elements.Key;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractKey extends CommandInteract {

    public CommandInteractKey(LevelModel m,Key element) {
        super(m,element);
    }

    @Override
    public void execute() {
        m.removeKeyLock();
        m.addWater();
        m.move(position);
        m.addPoints(1);
    }
}
