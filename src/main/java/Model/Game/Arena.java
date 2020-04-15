package Model.Game;

import Model.Elements.Destination;
import Model.Elements.Hero;
import Model.Elements.Ice;
import Model.Elements.Wall;
import Model.Elements.Key;
import Model.Elements.Coin;
import Model.Elements.Lock;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    public int width;
    public int height;
    public Level level;

    // Objects
    public Hero hero;
    public Destination destination;
    public List<Wall> walls;
    public List<Ice> filled;
    public List<Coin> coins;
    public Key key;
    public Lock lock;

    public Arena(int width, int height, int level) {
        this.width = width;
        this.height = height;

        this.level = new Level(level);
        this.walls = createMapLevel();
        this.filled = new ArrayList<>();
    }

    private List<Wall> createMapLevel() {
        List<String> mapInfo = level.getMapInfo();
        List<Wall> walls = new ArrayList<>();

        for(int yi = 0; yi < mapInfo.size(); yi++) {
            for(int xi = 0; xi < mapInfo.get(yi).length() ; xi++) {
                char c = mapInfo.get(yi).charAt(xi);
                if(c == 'W')
                    walls.add(new Wall( new Position(xi,yi)));
                if(c == 'D')
                    this.destination = new Destination(new Position(xi,yi));
                if(c == 'S')
                    this.hero = new Hero(new Position(xi,yi));
            }
        }
        return walls;
    }

    public Level getLevel() {
        return level;
    }
}
