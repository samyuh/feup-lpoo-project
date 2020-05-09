package Model.Level;

import Controller.Interact.*;
import Model.Elements.*;
import Model.Position;

import java.util.ArrayList;
import java.util.List;

public class LevelModel {
    private Puffle puffle;
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
    private Box box;

    public LevelModel() {
        this.points = new Points(0);
        this.walls = new ArrayList<>();
        this.ice = new ArrayList<>();
        this.water = new ArrayList<>();
        this.coins  = new ArrayList<>();
        this.toughIce = new ArrayList<>();
        this.teleportUsed = false;
    }

    // -- SET

    public void setPuffle(Puffle puffle) {
        this.puffle = puffle;
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

    public void setBox(Box box) { this.box = box; }

    // -- Get Functions

    public Puffle getPuffle() {
        return puffle;
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

    public void getBox(Box box) { this.box = box; }

    public boolean getTeleportUsed() { return teleportUsed; }

    // --- Misc

    public List<ElementModel> getAll(){
        List<ElementModel> elements = new ArrayList<>();

        elements.addAll(walls);
        elements.addAll(ice);
        elements.addAll(water);
        elements.addAll(coins);
        elements.addAll(toughIce);
        if(lock != null) elements.add(lock);
        if(key != null) elements.add(key);
        if(teleport1 != null) elements.add(teleport1);
        if(teleport2 != null) elements.add(teleport2);
        if(box != null) elements.add(box);
        elements.add(points);
        elements.add(puffle);
        elements.add(destination);

        return elements;
    }

    public ElementModel find(Position position) {
        for(Wall wall: this.walls){
            if(wall.getPosition().equals(position))
                return wall;
        }
        for(ToughIce toughIce: this.toughIce){
            if(toughIce.getPosition().equals(position))
                return toughIce;
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
        if(box != null)
            if (box.getPosition().equals(position)){
                return box;
            }

        if(destination.getPosition().equals(position))
             return destination;
        for(Ice ice: this.ice){
            if(ice.getPosition().equals(position))
                return ice;
        }

        return null;
    }

    public void clearLevel(){
        puffle = null;
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
}
