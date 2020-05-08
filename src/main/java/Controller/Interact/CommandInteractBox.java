package Controller.Interact;


import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class CommandInteractBox extends CommandInteract{
    public CommandInteractBox(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        if(m.moveBox(m.findBoxDirection()) == 0) {
            System.out.println("BLock");
            element.setInteraction(new CommandInteractStop(m, element));
        }
        else{ ;
            m.addWater();
            m.move(position);
            m.addPoints(1);
        }

    }
}
