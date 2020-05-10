package Controller.Interact;

import Controller.Level.LevelUpdateModel;
import Model.Elements.ElementModel;
import Model.Position;

public abstract class Interact {
    protected ElementModel element;
    protected Position position;

    protected Interact(ElementModel element){
        this.element = element;
        this.position = element.getPosition();
    }

    public abstract void execute(LevelUpdateModel model);
}