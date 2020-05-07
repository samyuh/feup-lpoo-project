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
    private Teleport teleport1;
    private Teleport teleport2;
    boolean teleportUsed;

    public LevelModel() {
        this.points = new Points(0);
        this.walls = new ArrayList<>();
        this.ice = new ArrayList<>();
        this.water = new ArrayList<>();
        this.coins  = new ArrayList<>();
        this.toughIce = new ArrayList<>();
        this.teleportUsed = false;
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

    public void setTeleport1(Teleport teleport1) { this.teleport1 = teleport1; }

    public void setTeleport2(Teleport teleport2) { this.teleport2 = teleport2; }

    public void setTeleportUsed(boolean teleportUsed) { this.teleportUsed = teleportUsed; }

    public void setInteractions() {
        for(Wall wall: this.walls){
            wall.setInteraction(new CommandInteractStop(this, wall));
        }
        for(Ice ice: this.ice){
            ice.setInteraction(new CommandInteractIce(this, ice));
        }
        for(Coin coin: this.coins){
            coin.setInteraction(new CommandInteractCoin(this, coin));
        }
        for(ToughIce toughIce: this.toughIce){
            toughIce.setInteraction(new CommandInteractToughIce(this,toughIce));
        }
        if(lock != null) {
            lock.setInteraction(new CommandInteractStop(this, lock));
        }
        if(key != null){
            key.setInteraction(new CommandInteractKey(this,key));
        }
        destination.setInteraction(new CommandInteractDestination(this,destination));
        if(teleport1 != null){
            teleport1.setInteraction((new CommandInteractTeleport(this,teleport1)));
        }
        if(teleport2 != null){
            teleport2.setInteraction((new CommandInteractTeleport(this,teleport2)));
        }
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

    public Teleport getTeleport1() { return teleport1; }

    public Teleport getTeleport2() { return teleport2; }

    public boolean isTeleportUsed() { return teleportUsed; }

    public List<ElementModel> getAll(){
        List<ElementModel> elements = new ArrayList<>();

        elements.addAll(walls);
        elements.addAll(ice);
        elements.addAll(water);
        elements.addAll(coins);
        elements.addAll(toughIce);
        if(key != null) elements.add(lock);
        if(key != null) elements.add(key);
        if(teleport1 != null) elements.add(teleport1);
        if(teleport2 != null) elements.add(teleport2);
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

    public boolean removeToughIce(Position position){
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
        for(ToughIce ice: this.toughIce){
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
        if(key != null) {
            if(key.getPosition().equals(position))
                return key;
        }
        if(lock != null) {
            if(lock.getPosition().equals(position))
                return lock;
        }
        if(teleport1 != null){
            if(teleport1.getPosition().equals(position))
                return teleport1;
            if(teleport2.getPosition().equals(position))
                return teleport2;
        }
        if(destination.getPosition().equals(position))
            return destination;
        return null;
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
        teleport1 = null;
        teleport2 = null;
        teleportUsed = false;
        points = new Points( 0);
    }

    public void move(Position position){
        getHero().setPosition(position);
    }

    public void removeKeyLock(){
        this.addIce(lock.getPosition());
        setKey(null);
        setLock(null);
    }

    public void addWater(){
        if(!removeToughIce(getHero().getPosition())) {
            Water water = new Water(getHero().getPosition());
            water.setInteraction(new CommandInteractStop(this, water));
            this.water.add(water);
        }
        else{
            this.addIce(hero.getPosition());
        }
    }

    public void addIce(Position position){
        Ice ice = new Ice(position);
        ice.setInteraction(new CommandInteractIce(this, ice));
        this.ice.add(ice);
    }

    public void removeCoin(Coin coin){
        this.coins.remove(coin);
    }

    public void removeToughIce(ToughIce toughIce){
        this.toughIce.remove(toughIce);
    }

    public void removeIce(Ice ice){
        this.ice.remove(ice);
    }

    public Position getTeleportPosition(Teleport teleport) {
        if(teleport.getPosition().equals(teleport1.getPosition())){
            return teleport2.getPosition();
        }
        else
            return teleport1.getPosition();
    }
}
