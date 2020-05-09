package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;
import Model.Position;

public abstract class Interact {
    LevelModel model;
    protected ElementModel element;
    protected Position position;

    protected Interact(LevelModel model, ElementModel element){
        this.model = model;
        this.element = element;
        this.position = element.getPosition();
    }

    public abstract void execute();
}