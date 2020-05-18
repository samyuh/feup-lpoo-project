package model.level;

import controller.element.BoxMovement;
import model.drawable.levelheader.LevelCurrent;
import model.drawable.Drawable;
import model.drawable.element.*;
import model.Position;

import java.util.ArrayList;
import java.util.Collection;
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
    private Key key;
    private Lock lock;
    private Teleport teleport1;
    private Teleport teleport2;
    private boolean teleportUsed;
    private Box box;
    private LevelHeaderModel levelHeaderModel;
    private BoxMovement boxMovement;
    private BoxFinalSquare boxFinalSquare;
    private SecretDestination secretDestination;
    private boolean secretFound;

    public LevelModel() {
        this.walls = new ArrayList<>();
        this.ice = new ArrayList<>();
        this.water = new ArrayList<>();
        this.coins  = new ArrayList<>();
        this.toughIce = new ArrayList<>();
        this.invisibleWalls = new ArrayList<>();
        this.teleportUsed = false;
        this.secretFound = false;
        this.levelHeaderModel = new LevelHeaderModel(new LevelCurrent(1),0);
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

    public void setBoxFinalSquare(BoxFinalSquare boxFinalSquare) { this.boxFinalSquare = boxFinalSquare; }

    public void setBoxMovement(BoxMovement boxMovement) { this.boxMovement = boxMovement; }

    public void setInvisibleWalls(List<InvisibleWall> invisibleWalls) { this.invisibleWalls = invisibleWalls; }

    public void setSecretFound(boolean secretFound) { this.secretFound = secretFound; }

    public void setSecretDestination(SecretDestination secretDestination) { this.secretDestination = secretDestination; }

    public void setBox(Box box) {
        boxMovement = new BoxMovement(box);
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

    public BoxFinalSquare getBoxFinalSquare() { return boxFinalSquare; }

    public BoxMovement getBoxMovement() { return boxMovement; }

    public List<InvisibleWall> getInvisibleWalls() { return invisibleWalls; }

    public SecretDestination getSecretDestination() { return secretDestination; }

    public boolean isSecretFound() { return secretFound; }

    // Reverses the List of Elements, because we need to draw what is on the floor first, and then what is above it (Painter's algorithm)
    public List<Drawable> getAll(){
        List<Drawable> drawables = getElements();
        Collections.reverse(drawables);
        drawables.add(levelHeaderModel.getLevelCurrent());
        drawables.add(levelHeaderModel.getLevelScore());
        drawables.add(levelHeaderModel.getGlobalScore());
        return drawables;
    }

    // List of elements(as Drawables) ordered by gamePlay processing data order
    public List<Drawable> getElements(){
        List<Drawable> elements = new ArrayList<>();

        elements.add(puffle);
        if(box != null) elements.add(box);
        if(lock != null) elements.add(lock);
        if(key != null) elements.add(key);
        if(teleport1 != null) elements.add(teleport1);
        if(teleport2 != null) elements.add(teleport2);
        if(boxFinalSquare != null) elements.add(boxFinalSquare);
        if(secretDestination != null) elements.add(secretDestination);
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

        for( Drawable element : everyone){
            if(element.getPosition().equals(position))
                return (ElementModel) element;
        }
        return null;

    }

    public void clearLevel(boolean clearWater){
        puffle = null;
        destination = null;
        walls = new ArrayList<>();
        if(clearWater) water = new ArrayList<>();
        coins = new ArrayList<>();
        toughIce = new ArrayList<>();
        key = null;
        lock = null;
        teleport1 = null;
        teleport2 = null;
        boxFinalSquare = null;
        teleportUsed = false;
        secretFound = false;
        levelHeaderModel = new LevelHeaderModel(new LevelCurrent(this.levelHeaderModel.getLevelCurrent().getLevelNumber()),this.levelHeaderModel.getGlobalScore().getPoints());
    }

    public void addWall(Position position) {
        Wall wall = new Wall(position);
        this.walls.add(wall);
    }
}
