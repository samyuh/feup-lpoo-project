package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractNull extends CommandInteract {
    public CommandInteractNull(LevelModel levelModel, Position editor) {
        super(levelModel,null, editor);
    }

    @Override
    public void execute() {
        m.addWater();
        m.move(position);
        m.addPoints(1);
    }
}
