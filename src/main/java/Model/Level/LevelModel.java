package Model.Level;

import Controller.Level.LevelInitializer;
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
    private int num;

    public LevelModel(int level) {
        this.num = level;
        this.points = new Points(0);
        this.walls = new ArrayList<>();
        this.filled = new ArrayList<>();
        this.coins  = new ArrayList<>();
        this.frozenIce = new ArrayList<>();
    }

    // --- Set methods
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

    // --- Get methods
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

    public int getnumlevel() {
        return num;
    }

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
