package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;
import Model.Position;

public abstract class CommandInteract {
    LevelModel m;
    protected ElementModel element;
    protected Position position;

    protected CommandInteract(LevelModel m, ElementModel element, Position position){
        this.m = m;
        this.element = element;
        this.position = position;
    }

    public abstract void execute();
}