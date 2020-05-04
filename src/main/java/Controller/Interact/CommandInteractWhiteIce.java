package Controller.Interact;

import Model.Elements.WhiteIce;

public class CommandInteractWhiteIce extends CommandInteract {
    public CommandInteractWhiteIce(WhiteIce element, Editor editor) {
        super(element, editor);
    }

    @Override
    public void execute() {
        editor.addWater();
        editor.move();
        editor.addPoints(1);
    }
}
