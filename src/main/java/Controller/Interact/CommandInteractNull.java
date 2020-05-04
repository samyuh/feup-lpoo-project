package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractNull extends CommandInteract {
    public CommandInteractNull(ElementModel elementModel, Editor editor) {
        super(null,editor);
    }

    @Override
    public void execute() {
        editor.addWater();
        editor.move();
        editor.addPoints(1);
    }
}
