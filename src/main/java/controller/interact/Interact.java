package controller.interact;

import controller.level.LevelUpdateModel;
import model.elements.ElementModel;
import model.Position;

public abstract class Interact {
    protected ElementModel element;
    protected Position position;

    protected Interact(ElementModel element){
        this.element = element;
        this.position = element.getPosition();
    }

    public abstract void execute(LevelUpdateModel model);
}