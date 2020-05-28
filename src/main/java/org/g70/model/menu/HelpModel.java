package org.g70.model.menu;

import org.g70.model.Position;
import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.element.immovable.*;
import org.g70.model.drawable.element.movable.*;
import org.g70.model.drawable.menudrawable.MenuOption;

import java.util.List;

public class HelpModel extends MenuFactory {
    public HelpModel(List<MenuOption> option) {
        super(option);

        initTextBoxes();
    }

    @Override
    protected void initTextBoxes() {
        textBoxes.add(new Puffle(new Position(2, 4)));
        textBoxes.add(new Box(new Position(2, 6)));
        textBoxes.add(new EmptyBlock(new Position(2, 8)));
        textBoxes.add(new Coin(new Position(2, 10)));
        textBoxes.add(new Finish(new Position(2, 12)));
        textBoxes.add(new Water(new Position(2, 14)));
        textBoxes.add(new Ice(new Position(16, 4)));
        textBoxes.add(new Key(new Position(16, 6)));
        textBoxes.add(new Lock(new Position(16, 8)));
        textBoxes.add(new Teleport(new Position(16, 10)));
        textBoxes.add(new DoubleIce(new Position(16, 12)));
        textBoxes.add(new Wall(new Position(16, 14)));

        textBoxes.add(new Drawable( " Your Puffle!", "#ffffff", "#000077", new Position(3, 4)));
        textBoxes.add(new Drawable( " Moving Box", "#ffffff", "#000077", new Position(3, 6)));
        textBoxes.add(new Drawable( " Box Place", "#ffffff", "#000077", new Position(3, 8)));
        textBoxes.add(new Drawable( " Coin", "#ffffff", "#000077", new Position(3, 10)));
        textBoxes.add(new Drawable( " Destination", "#ffffff", "#000077", new Position(3, 12)));
        textBoxes.add(new Drawable( " Water", "#ffffff", "#000077", new Position(3, 14)));
        textBoxes.add(new Drawable( " Ice", "#ffffff", "#000077", new Position(17, 4)));
        textBoxes.add(new Drawable( " Key", "#ffffff", "#000077", new Position(17, 6)));
        textBoxes.add(new Drawable( " Lock", "#ffffff", "#000077", new Position(17, 8)));
        textBoxes.add(new Drawable( " Teleport", "#ffffff", "#000077", new Position(17, 10)));
        textBoxes.add(new Drawable( " Double Ice", "#ffffff", "#000077", new Position(17, 12)));
        textBoxes.add(new Drawable( " Wall", "#ffffff", "#000077", new Position(17, 14)));
    }
}
