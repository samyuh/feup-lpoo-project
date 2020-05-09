package Controller.Interact;

import Controller.Level.LevelController;
import Model.Elements.ElementModel;
import Model.Level.LevelModel;
import Model.Position;

public abstract class Interact {
    protected ElementModel element;
    protected Position position;

    protected Interact(ElementModel element){
        this.element = element;
        this.position = element.getPosition();
    }

    public abstract void execute(LevelController model);
}