package model.menu;

import model.Position;
import model.drawable.Drawable;
import model.drawable.menu.ElementInfo;
import model.drawable.element.*;

import java.util.ArrayList;
import java.util.List;

public class HelpModel {
    List<Drawable> elements;

    public HelpModel() {
        elements = new ArrayList<>();
        initElements();    // Displays the elements
        initElementInfo(); // Displays the information about the elements
    }

    private void initElements() {
        elements.add(new Puffle(new Position(2, 4)));
        elements.add(new Box(new Position(2, 6)));
        elements.add(new BoxFinalSquare(new Position(2, 8)));
        elements.add(new Coin(new Position(2, 10)));
        elements.add(new Destination(new Position(2, 12)));
        elements.add(new Water(new Position(2, 14)));
        elements.add(new Ice(new Position(16, 4)));
        elements.add(new Key(new Position(16, 6)));
        elements.add(new Lock(new Position(16, 8)));
        elements.add(new Teleport(new Position(16, 10)));
        elements.add(new ToughIce(new Position(16, 12)));
        elements.add(new Wall(new Position(16, 14)));
    }

    private void initElementInfo(){
        elements.add(new ElementInfo( " Your Puffle!", "#ffffff", "#000077", new Position(3, 4)));
        elements.add(new ElementInfo( " Moving Box", "#ffffff", "#000077", new Position(3, 6)));
        elements.add(new ElementInfo( " Box Place", "#ffffff", "#000077", new Position(3, 8)));
        elements.add(new ElementInfo( " Coin", "#ffffff", "#000077", new Position(3, 10)));
        elements.add(new ElementInfo( " Destination", "#ffffff", "#000077", new Position(3, 12)));
        elements.add(new ElementInfo( " Water", "#ffffff", "#000077", new Position(3, 14)));
        elements.add(new ElementInfo( " Ice", "#ffffff", "#000077", new Position(17, 4)));
        elements.add(new ElementInfo( " Key", "#ffffff", "#000077", new Position(17, 6)));
        elements.add(new ElementInfo( " Lock", "#ffffff", "#000077", new Position(17, 8)));
        elements.add(new ElementInfo( " Teleport", "#ffffff", "#000077", new Position(17, 10)));
        elements.add(new ElementInfo( " Double Ice", "#ffffff", "#000077", new Position(17, 12)));
        elements.add(new ElementInfo( " Wall", "#ffffff", "#000077", new Position(17, 14)));

        elements.add(new ElementInfo( "Continue", "#ffffff", "#120A8F", new Position(2, 16)));
    }

    public List<Drawable> getElements() {
        return elements;
    }
}
