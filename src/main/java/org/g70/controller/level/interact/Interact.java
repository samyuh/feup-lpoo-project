package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.model.drawable.element.ElementModel;
import org.g70.model.Position;

public abstract class Interact<T extends ElementModel> {
    protected T element;
    protected Position position;

    protected Interact(T element){
        this.element = element;
        this.position = element.getPosition();
    }

    public abstract void execute(LevelController controller, LevelFacade facade);
}