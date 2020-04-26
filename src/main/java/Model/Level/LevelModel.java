package Model.Level;

import Model.Elements.*;
import Model.Position;

import java.util.ArrayList;
import java.util.List;

public class LevelModel {
    private LevelInitializer levelInitializer;

    // Objects
    private Hero hero;
    private Destination destination;
    private List<Wall> walls;
    private List<Water> filled;
    private List<Coin> coins;
    private List<WhiteIce> frozenIce;
    private Key key;
    private Lock lock;
    private Points points;


    public LevelModel(int level) {
        this.points = new Points(0);
        this.levelInitializer = new LevelInitializer(level);
        this.walls = new ArrayList<>();
        this.filled = new ArrayList<>();
        this.coins  = new ArrayList<>();
        this.frozenIce = new ArrayList<>();
        createMapLevel();
    }

    private void createMapLevel() {
        List<String> mapInfo = levelInitializer.getMapElements();
        List<Wall> walls = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();
        List<WhiteIce> frozenIce = new ArrayList<>();

        for(int yi = 0; yi < mapInfo.size(); yi++) {
            for(int xi = 0; xi < mapInfo.get(yi).length() ; xi++) {
                char c = mapInfo.get(yi).charAt(xi);
                if(c == 'W')
                    walls.add(new Wall( new Position(xi,yi)));
                if(c == 'C')
                    coins.add(new Coin(new Position(xi,yi)));
                if(c == 'B')
                    frozenIce.add(new WhiteIce(new Position(xi,yi)));
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
        setFrozenIce(frozenIce);
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

    public List<Water> getFilled() {
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

    public List<WhiteIce> getFrozenIce() { return frozenIce; }

    public List<ElementModel> getAll(){
        List<ElementModel> elements = new ArrayList<>();

        elements.addAll(walls);
        elements.addAll(filled);
        elements.addAll(coins);
        elements.addAll(frozenIce);
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

    public LevelInitializer getLevelInitializer() {
        return levelInitializer;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public void setFrozenIce(List<WhiteIce> frozenIce) { this.frozenIce = frozenIce; }

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
        for(WhiteIce frozenIce : this.frozenIce){
            if(frozenIce.getPosition().equals(position)){
                this.frozenIce.remove(frozenIce);
                return true;
            }
        }
        return false;
    }
}
