package org.g70.model.level;

import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.element.*;
import org.g70.model.Position;
import org.g70.model.drawable.element.immovable.*;
import org.g70.model.drawable.element.movable.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LevelModel {
    private Puffle puffle;
    private Finish finish;
    private Key key;
    private Lock lock;
    private Box box;
    private EmptyBlock emptyBlock;
    private Secret secret;
    private List<Wall> walls;
    private List<Ice> ice;
    private List<Water> water;
    private List<Coin> coins;
    private List<DoubleIce> doubleIce;
    private List<InvisibleWall> invisibleWalls;
    private List<Teleport> teleports;


    public LevelModel() {
        walls = new ArrayList<>();
        ice = new ArrayList<>();
        water = new ArrayList<>();
        coins  = new ArrayList<>();
        doubleIce = new ArrayList<>();
        invisibleWalls = new ArrayList<>();
        teleports = new ArrayList<>();
    }

    public void setPuffle(Puffle puffle) {
        this.puffle = puffle;
    }

    public void setFinish(Finish finish) {
        this.finish = finish;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public void setEmptyBlock(EmptyBlock emptyBlock) {
        this.emptyBlock = emptyBlock;
    }

    public void setSecret(Secret secret) {
        this.secret = secret;
    }

    public void addWalls(Wall walls) {
        this.walls.add(walls);
    }

    public void addWater(Water water) {
        this.water.add(water);
    }

    public void addIce(Ice ice) {
        this.ice.add(ice);
    }

    public void addCoins(Coin coin) {
        this.coins.add(coin);
    }

    public void addDoubleIce(DoubleIce doubleIce) {
        this.doubleIce.add(doubleIce);
    }

    public void addInvisibleWalls(InvisibleWall invisibleWall) {
        this.invisibleWalls.add(invisibleWall);
    }

    public void addTeleports(Teleport teleport) {
        this.teleports.add(teleport);
    }

    public Puffle getPuffle() {
        return puffle;
    }

    public Finish getFinish() {
        return finish;
    }

    public Lock getLock() {
        return lock;
    }

    public Key getKey() {
        return key;
    }

    public Box getBox() {
        return box;
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

    public EmptyBlock getEmptyBlock() {
        return emptyBlock;
    }

    public List<DoubleIce> getDoubleIce() {
        return doubleIce;
    }

    public List<InvisibleWall> getInvisibleWalls() {
        return invisibleWalls;
    }

    public List<Teleport> getTeleports() {
        return teleports;
    }

    public Secret getSecret() {
        return secret;
    }

    // List of elements ordered by gameplay processing data order
    private List<Drawable> getElements(){
        List<Drawable> elements = new ArrayList<>();

        if(puffle != null) elements.add(puffle);
        if(box != null) elements.add(box);
        if(lock != null) elements.add(lock);
        if(key != null) elements.add(key);
        if(emptyBlock != null) elements.add(emptyBlock);
        if(secret != null) elements.add(secret);
        elements.addAll(teleports);
        elements.addAll(walls);
        elements.addAll(invisibleWalls);
        if(finish != null) elements.add(finish);
        elements.addAll(coins);
        elements.addAll(doubleIce);
        elements.addAll(water);
        elements.addAll(ice);

        return elements;
    }

    // List of elements(as Drawables) ordered by drawing order(reverse of processing order)
    public List<Drawable> getAll(){
        List<Drawable> drawables = getElements();
        Collections.reverse(drawables);
        return drawables;
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
        walls = new ArrayList<>();
        invisibleWalls = new ArrayList<>();

        if (!secretLevel) {
            water = new ArrayList<>();
            ice = new ArrayList<>();
            coins = new ArrayList<>();
            doubleIce = new ArrayList<>();
            teleports = new ArrayList<>();
            puffle = null;
            finish = null;
            key = null;
            lock = null;
            box = null;
            emptyBlock = null;
            secret = null;
        }
    }
}
