package Model.Level;

import Controller.Interact.*;
import Model.Elements.*;
import Model.Position;

import java.util.ArrayList;
import java.util.List;

import static Model.Level.LevelModel.DIRECTION.UP;

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

    public void setInteractions() {
        for(Wall wall: this.walls){
            wall.setInteraction(new InteractStop(this, wall));
        }
        for(Ice ice: this.ice){
            ice.setInteraction(new InteractIce(this, ice));
        }
        for(Coin coin: this.coins){
            coin.setInteraction(new InteractCoin(this, coin));
        }
        for(ToughIce toughIce: this.toughIce){
            toughIce.setInteraction(new InteractToughIce(this,toughIce));
        }
        if(lock != null) {
            lock.setInteraction(new InteractStop(this, lock));
        }
        if(key != null){
            key.setInteraction(new InteractKey(this,key));
        }
        destination.setInteraction(new InteractDestination(this,destination));
        if(teleport1 != null){
            teleport1.setInteraction(new InteractTeleport(this,teleport1));
        }
        if(teleport2 != null){
            teleport2.setInteraction(new InteractTeleport(this,teleport2));
        }
        if(box != null){
            box.setInteraction(new InteractBox(this,box));
        }
    }

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

    public boolean isTeleportUsed() { return teleportUsed; }

    public void getBox(Box box) { this.box = box; }

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

    public int moveBox(DIRECTION boxDirection) {
        int count;
        count = 0;
        while(true){
            switch (boxDirection){
                case RIGHT:
                    if(findWall(new Position(box.getPosition().getX() + 1,box.getPosition().getY())) ||
                       findWater(new Position(box.getPosition().getX() + 1,box.getPosition().getY()))) return count;
                    box.setPosition(new Position(box.getPosition().getX() + 1,box.getPosition().getY()));
                    count++;
                    break;
                case LEFT:
                    if(findWall(new Position(box.getPosition().getX() - 1,box.getPosition().getY())) ||
                       findWater(new Position(box.getPosition().getX() - 1,box.getPosition().getY()))) return count;
                    box.setPosition(new Position(box.getPosition().getX() - 1,box.getPosition().getY()));
                    count++;
                    break;
                case UP:
                    if(findWall(new Position(box.getPosition().getX(),box.getPosition().getY() - 1)) ||
                       findWater(new Position(box.getPosition().getX(),box.getPosition().getY() - 1))) return count;
                    box.setPosition(new Position(box.getPosition().getX(),box.getPosition().getY() - 1));
                    count++;
                    break;
                case DOWN:
                    if(findWall(new Position(box.getPosition().getX(),box.getPosition().getY() + 1)) ||
                       findWater(new Position(box.getPosition().getX(),box.getPosition().getY() + 1))) return count;
                    box.setPosition(new Position(box.getPosition().getX(),box.getPosition().getY() + 1));
                    count++;
                    break;
                default:
                    return count;
            }
        }


    }

    public enum DIRECTION {UP, RIGHT, DOWN, LEFT, CLOSE, NEXT,RESTART};
    public DIRECTION findBoxDirection(){
        Position boxPosition  = box.getPosition();
        Position heroPosition  = puffle.getPosition();
        if(boxPosition.getX() - heroPosition.getX() == 1) return DIRECTION.RIGHT;
        if(boxPosition.getX() - heroPosition.getX() == -1) return DIRECTION.LEFT;
        if(boxPosition.getY() - heroPosition.getY() == 1) return DIRECTION.DOWN;
        return UP;
    }

    public void move(Position position){
        getPuffle().setPosition(position);
        // Need to set the position back in case it is blocked (block is raised to lose the game when box cant move)
        if(box != null) box.setInteraction(new InteractBox(this,box));
    }

    public void removeKeyLock(){
        this.addIce(lock.getPosition());
        setKey(null);
        setLock(null);
    }

    public void addWater(){
        // If there is no toughIce below the hero
        if(!removeToughIce(getPuffle().getPosition())) {
            Water water = new Water(getPuffle().getPosition());
            water.setInteraction(new InteractStop(this, water));
            this.water.add(water);
        }
        //If there is toughIce below the hero
        else{
            this.addIce(puffle.getPosition());
        }
    }

    public void addIce(Position position){
        Ice ice = new Ice(position);
        ice.setInteraction(new InteractIce(this, ice));
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
