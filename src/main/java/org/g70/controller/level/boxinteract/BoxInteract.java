package org.g70.controller.level.boxinteract;

import org.g70.controller.level.LevelItemsFacade;
import org.g70.model.Position;
import org.g70.model.drawable.element.ElementModel;

public abstract class BoxInteract<T extends ElementModel> {
    protected T element;
    protected Position position;

    protected BoxInteract(T element){
        this.element = element;
        this.position = element.getPosition();
    }

    public abstract boolean execute(LevelItemsFacade facade);
}