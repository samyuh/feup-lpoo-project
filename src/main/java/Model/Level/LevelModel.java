package Model.Level;

import Model.Elements.*;
import Model.Position;

import java.util.ArrayList;
import java.util.List;

public class LevelModel {
    private Hero hero;
    private Destination destination;
    private List<Wall> walls;
    private List<Water> filled;
    private List<Coin> coins;
    private List<WhiteIce> frozenIce;
    private Key key;
    private Lock lock;
    private Points points;

    public LevelModel() {
        this.points = new Points(0);
        this.walls = new ArrayList<>();
        this.filled = new ArrayList<>();
        this.coins  = new ArrayList<>();
        this.frozenIce = new ArrayList<>();
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setFilled(List<Water> filled) {
        this.filled = filled;
    }

    public void setPoints(Points points) {
        this.points = points;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public void setFrozenIce(List<WhiteIce> frozenIce) { this.frozenIce = frozenIce; }

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

    public void addPoints(int number){ this.points = new Points( this.points.getNumber() + number); }

    public boolean removeCoin(Position position){
        for(Coin coin : this.coins) {
            if (coin.getPosition().equals(position)) {
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

    public Wall findWall(Position position){
        for(Wall wall: this.walls){
            if(wall.getPosition().equals(position))
                return wall;
        }
        return null;
    }
    public Coin findCoin(Position position){
        for(Coin coin: this.coins){
            if(coin.getPosition().equals(position))
                return coin;
        }
        return null;
    }

    public Water findWater(Position position){
        for(Water water: this.filled){
            if(water.getPosition().equals(position))
                return water;
        }
        return null;
    }

    public WhiteIce findWhiteIce(Position position){
        for(WhiteIce ice: this.frozenIce){
            if(ice.getPosition().equals(position))
                return ice;
        }
        return null;
    }

    public void clearLevel(){
        hero = null;
        destination = null;
        walls = new ArrayList<>();
        filled = new ArrayList<>();
        coins = new ArrayList<>();
        frozenIce = new ArrayList<>();
        key = null;
        lock = null;
        points = new Points( 0);
    }
}
