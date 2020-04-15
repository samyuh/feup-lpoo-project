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
    private int points;

    public Arena(int width, int height, int level) {
        this.width = width;
        this.height = height;
        this.points = 0;

        this.level = new Level(level);
        this.walls = new ArrayList<>();
        this.filled = new ArrayList<>();
        this.coins  = new ArrayList<>();
        createMapLevel();
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Level getLevel() {
        return level;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public void removeCoin(Position position){
        for(Coin coin : this.coins){
            if(coin.getPosition().equals(position)){
                this.coins.remove(coin);
                break;
            }
        }
    }

    public void removeKey(){
        this.key = null;
    }
    public void removeLock(){
        this.lock = null;
    }

    private void createMapLevel() {
        List<String> mapInfo = level.getMapInfo();
        List<Wall> walls = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();


        for(int yi = 0; yi < mapInfo.size(); yi++) {
            for(int xi = 0; xi < mapInfo.get(yi).length() ; xi++) {
                char c = mapInfo.get(yi).charAt(xi);
                if(c == 'W')
                    walls.add(new Wall( new Position(xi,yi)));
                if(c == 'D')
                    this.destination = new Destination(new Position(xi,yi));
                if(c == 'C')
                    coins.add(new Coin(new Position(xi,yi)));
                if(c == 'K')
                    setKey(new Key(new Position(xi,yi)));
                if(c == 'L')
                    setLock(new Lock(new Position(xi,yi)));
                if(c == 'S')
                    this.hero = new Hero(new Position(xi,yi));

            }
        }
        setWalls(walls);
        setCoins(coins);
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
}
