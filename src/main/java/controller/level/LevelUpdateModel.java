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


    /// -- Spaguetti

    // MOVE

    public void move(Position position) {   
        levelModel.getPuffle().setPosition(position);
        // Need to set the position back in case it is blocked (block is raised to lose the game when box cant move)
        if(levelModel.getBox() != null) levelModel.getBox().setInteraction(new InteractBox(levelModel.getBox()));
    }

    public void addScore(int number){ levelModel.getLevelHeaderModel().addScore(number);}

    // BOX

    public enum DIRECTION {UP, RIGHT, DOWN, LEFT};
    public DIRECTION findBoxDirection(){
        Position boxPosition  = levelModel.getBox().getPosition();
        Position heroPosition = levelModel.getPuffle().getPosition();
        if(boxPosition.getX() - heroPosition.getX() == 1) return DIRECTION.RIGHT;
        if(boxPosition.getX() - heroPosition.getX() == -1) return DIRECTION.LEFT;
        if(boxPosition.getY() - heroPosition.getY() == 1) return DIRECTION.DOWN;
        return DIRECTION.UP;
    }

    private Interact checkMovement(Position position){
        ElementModel element = levelModel.find(position);
        return element.getInteraction();

    }

    private boolean checkCollisions(Position position) {
        return checkMovement(position).getClass() == InteractStop.class;
    }

    public boolean moveBox(DIRECTION boxDirection) {
        boolean canMove = false;
        while(true) {
            switch (boxDirection){
                case RIGHT:
                    if(checkCollisions(new Position(levelModel.getBox().getPosition().getX() + 1,levelModel.getBox().getPosition().getY()))) return canMove;
                    levelModel.getBox().setPosition(new Position(levelModel.getBox().getPosition().getX() + 1,levelModel.getBox().getPosition().getY()));
                    canMove = true;
                    break;
                case LEFT:
                    if(checkCollisions(new Position(levelModel.getBox().getPosition().getX() - 1,levelModel.getBox().getPosition().getY()))) return canMove;
                    levelModel.getBox().setPosition(new Position(levelModel.getBox().getPosition().getX() - 1,levelModel.getBox().getPosition().getY()));
                    canMove = true;
                    break;
                case UP:
                    if(checkCollisions(new Position(levelModel.getBox().getPosition().getX(),levelModel.getBox().getPosition().getY() - 1))) return canMove;
                    levelModel.getBox().setPosition(new Position(levelModel.getBox().getPosition().getX(),levelModel.getBox().getPosition().getY() - 1));
                    canMove = true;
                    break;
                case DOWN:
                    if(checkCollisions(new Position(levelModel.getBox().getPosition().getX(),levelModel.getBox().getPosition().getY() + 1))) return canMove;
                    levelModel.getBox().setPosition(new Position(levelModel.getBox().getPosition().getX(),levelModel.getBox().getPosition().getY() + 1));
                    canMove = true;
                    break;
                default:
                    return canMove;
            }
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
        levelModel.setKey(null);
        levelModel.setLock(null);
    }

    // COIN
    public void removeCoin(Coin coin) {
        levelModel.getCoins().remove(coin);
    }

    // MELT
    public void meltIce(){
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
}
