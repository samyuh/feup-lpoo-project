package Controller.Interact;

import Model.Elements.ElementModel;

public abstract class CommandInteract {
    ElementModel element;

    protected CommandInteract(ElementModel element){this.element = element; }

    public abstract void execute();
}