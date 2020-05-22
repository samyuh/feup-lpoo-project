package org.g70.model.level;

import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.element.*;
import org.g70.model.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelModel {
    private Puffle puffle;
    private Finish finish;
    private List<Wall> walls;
    private List<Ice> ice;
    private List<Water> water;
    private List<Coin> coins;
    private List<DoubleIce> doubleIce;
    private List<InvisibleWall> invisibleWalls;
    private List<Teleport> teleport;
    private Key key;
    private Lock lock;
    private Box box;
    private EmptyBlock emptyBlock;
    private Secret secret;

    public LevelModel() {
        this.walls = new ArrayList<>();
        this.ice = new ArrayList<>();
        this.water = new ArrayList<>();
        this.coins  = new ArrayList<>();
        this.doubleIce = new ArrayList<>();
        this.invisibleWalls = new ArrayList<>();
        this.teleport = new ArrayList<>();
    }

    public void setPuffle(Puffle puffle) {
        this.puffle = puffle;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public void setFinish(Finish finish) {
        this.finish = finish;
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

    public void setDoubleIce(List<DoubleIce> doubleIce) { this.doubleIce = doubleIce; }

    public void setEmptyBlock(EmptyBlock emptyBlock) { this.emptyBlock = emptyBlock; }

    public void setInvisibleWalls(List<InvisibleWall> invisibleWalls) { this.invisibleWalls = invisibleWalls; }

    public void setSecret(Secret secret) { this.secret = secret; }

    public void setTeleport(List<Teleport> teleport) { this.teleport = teleport; }

    public Puffle getPuffle() {
        return puffle;
    }

    public Finish getFinish() { return finish; }

    public List<Wall> getWalls() { return walls; }

    public List<Ice> getIce() { return ice; }

    public List<Water> getWater() { return water; }

    public List<Coin> getCoins() { return coins; }

    public Key getKey() { return key; }

    public Lock getLock() { return lock; }

    public List<DoubleIce> getDoubleIce() { return doubleIce; }

    public Box getBox() { return box; }

    public EmptyBlock getEmptyBlock() { return emptyBlock; }

    public List<InvisibleWall> getInvisibleWalls() { return invisibleWalls; }

    public Secret getSecret() { return secret; }

    public List<Teleport> getTeleport() { return teleport; }

    // Reverses the List of Elements, because we need to draw what is on the floor first, and then what is above it (Painter's algorithm)
    public List<Drawable> getAll(){
        List<Drawable> drawables = getElements();
        Collections.reverse(drawables);
        return drawables;
    }

    // List of elements(as Drawables) ordered by gamePlay processing data order
    public List<Drawable> getElements(){
        List<Drawable> elements = new ArrayList<>();

        elements.add(puffle);
        if(box != null) elements.add(box);
        if(lock != null) elements.add(lock);
        if(key != null) elements.add(key);
        if(emptyBlock != null) elements.add(emptyBlock);
        if(secret != null) elements.add(secret);
        elements.addAll(teleport);
        elements.addAll(walls);
        elements.addAll(invisibleWalls);
        elements.add(finish);
        elements.addAll(coins);
        elements.addAll(doubleIce);
        elements.addAll(water);
        elements.addAll(ice);

        return elements;
    }

    public ElementModel find(Position position) {
        List<Drawable> elements = getElements();

        for(Drawable element : elements){
            if(element.getPosition().equals(position))
                return (ElementModel) element;
        }
        return null;
    }

    public void clearLevel(boolean secretLevel) {
        if (!secretLevel) water = new ArrayList<>();
        walls = new ArrayList<>();
        coins = new ArrayList<>();
        doubleIce = new ArrayList<>();
        teleport = new ArrayList<>();
        puffle = null;
        finish = null;
        key = null;
        lock = null;
        emptyBlock = null;
    }
}
