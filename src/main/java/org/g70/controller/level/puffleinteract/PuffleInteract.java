package org.g70.controller.level.puffleinteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelItemsFacade;
import org.g70.model.drawable.element.ElementModel;
import org.g70.model.Position;

public abstract class PuffleInteract<T extends ElementModel> {
    protected T element;
    protected Position position;

    protected PuffleInteract(T element){
        this.element = element;
        this.position = element.getPosition();
    }

    public abstract void execute(LevelController controller, LevelItemsFacade facade);
}