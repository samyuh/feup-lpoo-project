package Model.Game;

import Model.Elements.*;

import javax.lang.model.element.Element;
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
    private List<White> white;
    private Key key;
    private Lock lock;
    private Points points;


    public Arena(int width, int height, int level) {
        this.width = width;
        this.height = height;

        this.points = new Points(0);
        this.level = new Level(level);
        this.walls = new ArrayList<>();
        this.filled = new ArrayList<>();
        this.coins  = new ArrayList<>();
        this.white = new ArrayList<>();
        createMapLevel();
    }

    private void createMapLevel() {
        List<String> mapInfo = level.getMapInfo();
        List<Wall> walls = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();
        List<White> white = new ArrayList<>();



        for(int yi = 0; yi < mapInfo.size(); yi++) {
            for(int xi = 0; xi < mapInfo.get(yi).length() ; xi++) {
                char c = mapInfo.get(yi).charAt(xi);
                if(c == 'W')
                    walls.add(new Wall( new Position(xi,yi)));
                if(c == 'C')
                    coins.add(new Coin(new Position(xi,yi)));
                if(c == 'B')
                    white.add(new White(new Position(xi,yi)));
                if(c == 'K')
                    setKey(new Key(new Position(xi,yi)));
                if(c == 'L')
                    setLock(new Lock(new Position(xi,yi)));
                if(c == 'S')
                    this.hero = new Hero(new Position(xi,yi));
                if(c == 'D')
                    this.destination = new Destination(new Position(xi,yi));

            }
        }
        setWalls(walls);
        setCoins(coins);
        setWhite(white);
    }

    //Get Methods
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

    public Points getPoints() { return points; }

    public List<White> getWhite() { return white; }

    public List<ElementModel> getAll(){
        List<ElementModel> elements = new ArrayList<>();


        elements.addAll(walls);
        elements.addAll(filled);
        elements.addAll(coins);
        elements.addAll(white);
        if(key != null) elements.add(lock);
        if(key != null) elements.add(key);
        elements.add(points);
        elements.add(hero);
        elements.add(destination);

        return elements;
    }

    //Set Methods

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

    public void setWhite(List<White> white) { this.white = white; }

    public void addPoints(int number){ this.points = new Points( this.points.getNumber() + number); }

    //Remove Methods
    public boolean removeCoin(Position position){
        for(Coin coin : this.coins){
            if(coin.getPosition().equals(position)){
                this.coins.remove(coin);
                return true;
            }
        }
        return false;
    }
    public boolean removeWhite(Position position){
        for(White white : this.white){
            if(white.getPosition().equals(position)){
                this.white.remove(white);
                return true;
            }
        }
        return false;
    }
}
