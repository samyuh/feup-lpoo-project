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
    private int width;
    private int height;
    private Level level;

    // Objects
    private Hero hero;
    private Destination destination;
    private List<Wall> walls;
    private List<Ice> filled;
    private List<Coin> coins;
    private Key key;
    private Lock lock;

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Hero getHero() {
        return hero;
    }

    public Destination getDestination() {
        return destination;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Ice> getFilled() {
        return filled;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public Key getKey() {
        return key;
    }

    public Lock getLock() {
        return lock;
    }

    public Level getLevel() {
        return level;
    }
}
