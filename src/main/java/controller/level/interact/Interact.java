package controller.level.interact;

import controller.level.LevelController;
import controller.level.LevelFacade;
import model.drawable.element.ElementModel;
import model.Position;

public abstract class Interact<T extends ElementModel> {
    protected T element;
    protected Position position;

    protected Interact(T element){
        this.element = element;
        this.position = element.getPosition();
    }

    public abstract void execute(LevelController controller, LevelFacade facade);
}