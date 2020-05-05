package Model.Level;

import Controller.Interact.*;
import Model.Elements.*;
import Model.Position;

import java.util.ArrayList;
import java.util.List;

public class LevelModel {
    private Hero hero;
    private Destination destination;
    private List<Wall> walls;
    private List<Ice> ice;
    private List<Water> water;
    private List<Coin> coins;
    private List<ToughIce> toughIce;
    private Key key;
    private Lock lock;
    private Points points;

    public LevelModel() {
        this.points = new Points(0);
        this.walls = new ArrayList<>();
        this.ice = new ArrayList<>();
        this.water = new ArrayList<>();
        this.coins  = new ArrayList<>();
        this.toughIce = new ArrayList<>();
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

    public void setIce(List<Ice> ice) {
        this.ice = ice;
    }


    public void setWater(List<Water> water) {
        this.water = water;
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

    public void setToughIce(List<ToughIce> toughIce) { this.toughIce = toughIce; }

    public void setInteractions() {
        for(Wall wall: this.walls){
            wall.setInteraction(new CommandInteractStop(this, wall, wall.getPosition()));
        }
        for(Ice ice: this.ice){
            ice.setInteraction(new CommandInteractIce(this, ice, ice.getPosition()));
        }
        for(Coin coin: this.coins){
            coin.setInteraction(new CommandInteractCoin(this, coin, coin.getPosition()));
        }
        for(ToughIce ice: this.toughIce){
            ice.setInteraction(new CommandInteractIce(this,ice, ice.getPosition()));
        }
        if(lock != null) {
            lock.setInteraction(new CommandInteractStop(this, lock, lock.getPosition()));
        }
        if(key != null){
            key.setInteraction(new CommandInteractKey(this,key,key.getPosition()));
        }
        destination.setInteraction(new CommandInteractDestination(this,destination,destination.getPosition()));

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

    public List<Ice> getIce() {
        return ice;
    }

    public List<Water> getWater() {
        return water;
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

    public List<ToughIce> getToughIce() { return toughIce; }

    public List<ElementModel> getAll(){
        List<ElementModel> elements = new ArrayList<>();

        elements.addAll(walls);
        elements.addAll(ice);
        elements.addAll(water);
        elements.addAll(coins);
        elements.addAll(toughIce);
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
        for(ToughIce frozenIce : this.toughIce){
            if(frozenIce.getPosition().equals(position)){
                this.toughIce.remove(frozenIce);
                return true;
            }
        }
        return false;
    }

    public boolean findWall(Position position){
        for(Wall wall: this.walls){
            if(wall.getPosition().equals(position))
                return true;
        }
        return false;
    }

    public boolean findWater(Position position){
        for(Water water: this.water){
            if(water.getPosition().equals(position))
                return true;
        }
        return false;
    }

    public ElementModel find(Position position) {
        for(Wall wall: this.walls){
            if(wall.getPosition().equals(position))
                return wall;
        }
        for(Ice ice: this.ice){
            if(ice.getPosition().equals(position))
                return ice;
        }
        for(Coin coin: this.coins){
            if(coin.getPosition().equals(position))
                return coin;
        }
        for(Water water: this.water){
            if(water.getPosition().equals(position))
                return water;
        }
        for(ToughIce ice: this.toughIce){
            if(ice.getPosition().equals(position))
                return ice;
        }
        if(lock != null) {
            if(lock.getPosition().equals(position))
                return lock;
        }
        return destination;
    }

    public void clearLevel(){
        hero = null;
        destination = null;
        walls = new ArrayList<>();
        water = new ArrayList<>();
        coins = new ArrayList<>();
        toughIce = new ArrayList<>();
        key = null;
        lock = null;
        points = new Points( 0);
    }

    public void move(Position position){
        getHero().setPosition(position);
    }

    public void removeKeyLock(){
        setKey(null);
        setLock(null);

    }
    public void addWater(){
        if(!removeWhite(getHero().getPosition())) {
            Water water = new Water(getHero().getPosition());
            water.setInteraction(new CommandInteractStop(this,water,water.getPosition()));
            getWater().add(water);

        }
    }

    public void removeCoin(Coin coin){
        getCoins().remove(coin);
    }

    public void removeWhiteIce(ToughIce toughIce){
        getToughIce().remove(toughIce);
    }
}
