package org.g70.model.level;

import org.g70.controller.level.movement.BoxMovement;
import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.element.*;
import org.g70.model.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelModel {
    private Puffle puffle;
    private Destination destination;
    private List<Wall> walls;
    private List<Ice> ice;
    private List<Water> water;
    private List<Coin> coins;
    private List<ToughIce> toughIce;
    private List<InvisibleWall> invisibleWalls;
    private List<Teleport> teleport;
    private Key key;
    private Lock lock;
    private Box box;
    private BoxMovement boxMovement;
    private BoxFinalSquare boxFinalSquare;
    private SecretDestination secretDestination;

    public LevelModel() {
        this.walls = new ArrayList<>();
        this.ice = new ArrayList<>();
        this.water = new ArrayList<>();
        this.coins  = new ArrayList<>();
        this.toughIce = new ArrayList<>();
        this.invisibleWalls = new ArrayList<>();
        this.teleport = new ArrayList<>();
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

    public void setBoxFinalSquare(BoxFinalSquare boxFinalSquare) { this.boxFinalSquare = boxFinalSquare; }

    public void setBoxMovement(BoxMovement boxMovement) { this.boxMovement = boxMovement; }

    public void setInvisibleWalls(List<InvisibleWall> invisibleWalls) { this.invisibleWalls = invisibleWalls; }

    public void setSecretDestination(SecretDestination secretDestination) { this.secretDestination = secretDestination; }

    public void setBox(Box box) {
        boxMovement = new BoxMovement(box);
        this.box = box; }

    public void setTeleport(List<Teleport> teleport) { this.teleport = teleport; }

    public void addWall(Position position) {
        Wall wall = new Wall(position);
        this.walls.add(wall);
    }

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

    public Box getBox() { return box; }

    public BoxFinalSquare getBoxFinalSquare() { return boxFinalSquare; }

    public BoxMovement getBoxMovement() { return boxMovement; }

    public List<InvisibleWall> getInvisibleWalls() { return invisibleWalls; }

    public SecretDestination getSecretDestination() { return secretDestination; }

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
        if(boxFinalSquare != null) elements.add(boxFinalSquare);
        if(secretDestination != null) elements.add(secretDestination);
        elements.addAll(teleport);
        elements.addAll(walls);
        elements.addAll(invisibleWalls);
        elements.add(destination);
        elements.addAll(coins);
        elements.addAll(toughIce);
        elements.addAll(water);
        elements.addAll(ice);

        return elements;
    }


    public ElementModel find(Position position) {
        List<Drawable> everyone = getElements();

        for(Drawable element : everyone){
            if(element.getPosition().equals(position))
                return (ElementModel) element;
        }
        return null;

    }

    public void clearLevel(boolean clearWater) {
        if(clearWater) {
            water = new ArrayList<>();
        }
        puffle = null;
        destination = null;
        walls = new ArrayList<>();
        coins = new ArrayList<>();
        toughIce = new ArrayList<>();
        teleport = new ArrayList<>();
        key = null;
        lock = null;
        boxFinalSquare = null;
    }
}
