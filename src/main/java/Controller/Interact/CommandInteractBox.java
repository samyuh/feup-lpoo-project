package Controller.Interact;


import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class CommandInteractBox extends CommandInteract{
    public CommandInteractBox(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        m.addWater();
        m.move(position);
        m.addPoints(1);
        m.moveBox(m.findBoxDirection());
    }
}
