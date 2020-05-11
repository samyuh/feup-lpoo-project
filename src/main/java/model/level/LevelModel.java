package model.level;

import model.drawable.levelheader.LevelCurrent;
import model.drawable.Drawable;
import model.drawable.element.*;
import model.Position;

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
    private Teleport teleport1;
    private Teleport teleport2;
    boolean teleportUsed;
    private Box box;
    private LevelHeaderModel levelHeaderModel;

    public LevelModel() {
        this.walls = new ArrayList<>();
        this.ice = new ArrayList<>();
        this.water = new ArrayList<>();
        this.coins  = new ArrayList<>();
        this.toughIce = new ArrayList<>();
        this.teleportUsed = false;
        this.levelHeaderModel = new LevelHeaderModel(new LevelCurrent(1));
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

    public void setKey(Key key) { this.key = key; }

    public void setLock(Lock lock) { this.lock = lock; }

    public void setCoins(List<Coin> coins) { this.coins = coins; }

    public void setToughIce(List<ToughIce> toughIce) { this.toughIce = toughIce; }

    public void setTeleport1(Teleport teleport1) { this.teleport1 = teleport1; }

    public void setTeleport2(Teleport teleport2) { this.teleport2 = teleport2; }

    public void setTeleportUsed(boolean teleportUsed) { this.teleportUsed = teleportUsed; }

    public void setBox(Box box) {
        System.out.println("Box here");
        this.box = box; }

    public void setLevelHeaderModel(LevelHeaderModel levelHeaderModel) { this.levelHeaderModel = levelHeaderModel; }
    // -- Get Functions

    public Puffle getPuffle() {
        return puffle;
    }

    public Destination getDestination() { return destination; }

    public List<Wall> getWalls() { return walls; }

    public List<Ice> getIce() { return ice; }

    public List<Water> getWater() { return water; }

    public List<Coin> getCoins() { return coins; }

    public Key getKey() { return key; }

    public Lock getLock() { return lock; }

    public List<ToughIce> getToughIce() { return toughIce; }

    public Teleport getTeleport1() { return teleport1; }

    public Teleport getTeleport2() { return teleport2; }

    public Box getBox() { return box; }

    public boolean getTeleportUsed() { return teleportUsed; }

    public LevelHeaderModel getLevelHeaderModel() { return this.levelHeaderModel; }

    public List<Drawable> getAll(){
        List<Drawable> drawables = new ArrayList<>();

        drawables.addAll(walls);
        drawables.addAll(ice);
        drawables.addAll(water);
        drawables.addAll(coins);
        drawables.addAll(toughIce);
        if(lock != null) drawables.add(lock);
        if(key != null) drawables.add(key);
        if(teleport1 != null) drawables.add(teleport1);
        if(teleport2 != null) drawables.add(teleport2);
        if(box != null) drawables.add(box);
        drawables.add(levelHeaderModel.getLevelCurrent());
        drawables.add(levelHeaderModel.getLevelScore());
        drawables.add(puffle);
        drawables.add(destination);

        return drawables;
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
        levelHeaderModel = new LevelHeaderModel(new LevelCurrent(this.levelHeaderModel.getLevelCurrent().getLevelNumber()));
    }
}
