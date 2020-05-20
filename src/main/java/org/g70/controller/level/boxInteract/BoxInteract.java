package org.g70.controller.level.boxInteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.model.Position;
import org.g70.model.drawable.element.ElementModel;

public abstract class BoxInteract<T extends ElementModel> {
    protected T element;
    protected Position position;

    protected BoxInteract(T element){
        this.element = element;
        this.position = element.getPosition();
    }

    public abstract void execute( LevelFacade facade);

}