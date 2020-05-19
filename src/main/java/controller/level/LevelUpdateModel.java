package controller.level;

import controller.interact.Interact;
import controller.interact.InteractBox;
import controller.interact.InteractIce;
import controller.interact.InteractStop;
import model.drawable.element.*;
import model.level.LevelModel;
import model.Position;

public class LevelUpdateModel {
    LevelModel levelModel;

    public LevelUpdateModel(LevelModel levelModel) {
        this.levelModel = levelModel;
    }

    // MOVE

    public void move(Position position) {   
        levelModel.getPuffle().setPosition(position);
        // Need to set the position back in case it is blocked (block is raised to lose the game when box cant move)
        if(levelModel.getBox() != null) levelModel.getBox().setInteraction(new InteractBox(levelModel.getBox()));
    }

    public void addScore(int levelPoints, int globalPoints){ levelModel.getLevelHeaderModel().addScore(levelPoints, globalPoints);}

    public void startSecretLevel() {
        levelModel.clearLevel(false);
    }


    // BOX

    public enum DIRECTION {UP, RIGHT, DOWN, LEFT};
    public DIRECTION findBoxDirection(){
        return levelModel.getBoxMovement().pufflePushedDirection(levelModel.getPuffle());
    }

    private Interact checkMovement(Position position){
        ElementModel element = levelModel.find(position);
        return element.getInteraction();

    }

    private boolean checkCollisions(Position position){
        return checkMovement(position).getClass() == InteractStop.class;
    }

    public boolean moveBox() {
        boolean canMove = false;
        DIRECTION boxDirection = this.findBoxDirection();
        while(true) {
            if(checkCollisions(levelModel.getBoxMovement().moveDirection(boxDirection))) return canMove;
            levelModel.getBox().setPosition(levelModel.getBoxMovement().moveDirection(boxDirection));
            canMove = true;
        }
    }

    // TELEPORT

    public boolean isTeleportUsed() {
        return levelModel.getTeleportUsed();
    }

    public void setTeleportUsed(boolean b) {
        levelModel.setTeleportUsed(b);
    }

    public ElementModel getTeleport1() {
        return levelModel.getTeleport1();
    }

    public ElementModel getTeleport2() {
        return levelModel.getTeleport2();
    }

    public Position getTeleportPosition(Teleport teleport) {
        if(teleport.getPosition().equals(levelModel.getTeleport1().getPosition())){
            return levelModel.getTeleport2().getPosition();
        }
        else
            return levelModel.getTeleport1().getPosition();
    }

    // KEY LOCK
    public void removeKeyLock() {
        addIce(levelModel.getLock().getPosition());
        levelModel.setKey(null);
        levelModel.setLock(null);
    }
    // INVISIBLE WALL
    public void removeInvisibleWall(InvisibleWall invisibleWall){
        /*
        Wall wall = new Wall(invisibleWall.getPosition());
        levelModel.getWalls().add(wall);
        levelModel.getInvisibleWalls().remove(invisibleWall);

         */

        invisibleWall.setInteraction(new InteractStop(invisibleWall));
    }

    public boolean isSecretFound(){
        return levelModel.isSecretFound();
    }
    public void setSecretFound(boolean secretFound){
        levelModel.setSecretFound(secretFound);
    }

    public void secretLevel() {
        levelModel.clearLevel(false);
    }

    // COIN
    public void removeCoin(Coin coin) {
        levelModel.getCoins().remove(coin);
    }


    // MELT
    public void meltIce(){

        // If there is a BoxFinalSquare below, no water or ice Should be added
        if(isOnBoxFinalSquare(levelModel.getPuffle().getPosition())) return;

        // If there is no toughIce below the hero
        if(!removeToughIce(levelModel.getPuffle().getPosition())) {
            Water water = new Water(levelModel.getPuffle().getPosition());
            water.setInteraction(new InteractStop(water));
            levelModel.getWater().add(water);
        }
        //If there is toughIce below the hero
        else{
            addIce(levelModel.getPuffle().getPosition());
        }
    }

    public void addIce(Position position){
        Ice ice = new Ice(position);
        ice.setInteraction(new InteractIce(ice));
        levelModel.getIce().add(ice);
    }

    public void removeIce(Ice ice) {
        levelModel.getIce().remove(ice);
    }

    public boolean removeToughIce(Position position){
        for(ToughIce frozenIce : levelModel.getToughIce()){
            if(frozenIce.getPosition().equals(position)){
                levelModel.getToughIce().remove(frozenIce);
                return true;
            }
        }
        return false;
    }

    // BOX FINAL SQUARE
    public boolean isOnBoxFinalSquare(Position position){
        return (levelModel.getBoxFinalSquare() != null && levelModel.getBoxFinalSquare().getPosition().equals(position));
    }
}
