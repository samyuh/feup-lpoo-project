package Controller.Interact;

import Model.Elements.ElementModel;

public abstract class CommandInteract {
    protected ElementModel element;
    protected Editor editor;

    protected CommandInteract(ElementModel element,Editor editor){
        this.element = element;
        this.editor = editor;
    }

    public abstract void execute();
}