package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;
import Model.Position;

public abstract class Interact {
    LevelModel m;
    protected ElementModel element;
    protected Position position;

    protected Interact(LevelModel m, ElementModel element){
        this.m = m;
        this.element = element;
        this.position = element.getPosition();
    }

    public abstract void execute();
}