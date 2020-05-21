package org.g70.controller.level;

import org.g70.controller.level.boxinteract.BoxInteract;
import org.g70.controller.level.movement.BoxMovement;
import org.g70.controller.level.movement.Movement;
import org.g70.controller.level.movement.PuffleMovement;
import org.g70.controller.level.puffleinteract.PuffleInteractBox;
import org.g70.controller.level.puffleinteract.PuffleInteractIce;
import org.g70.controller.level.puffleinteract.PuffleInteractStop;
import org.g70.controller.level.strategy.Strategy;
import org.g70.model.drawable.element.*;
import org.g70.model.level.LevelModel;
import org.g70.model.Position;

import java.util.List;

public class LevelFacade {
    LevelModel levelModel;

    private BoxMovement boxMovement;
    private PuffleMovement puffleMovement;

    Strategy meltStrategy;

    public LevelFacade(LevelModel levelModel) {
        this.levelModel = levelModel;
    }

    public void setPuffleMovement(PuffleMovement puffleMovement) {
        this.puffleMovement = puffleMovement;
    }

    // -- Refactor Box please bellow -- //
    // --- Move --- //
    public void movePuffle(Position position) {
        levelModel.getPuffle().setPosition(position);

        // Need to set the position back in case it is blocked (block is raised to lose the game when box cant move)
        if (levelModel.getBox() != null) {
            levelModel.getBox().setPuffleInteraction(new PuffleInteractBox(levelModel.getBox()));
            this.boxMovement = new BoxMovement(levelModel.getBox());
        }
        //
    }

    public void moveBox(Position position){
        levelModel.getBox().setPosition(position);
    }

    public boolean boxLoop() {
        boolean canMove = false;
        boxMovement.setOrientationFaced(findBoxDirection());
        while(true) {
            if(!executeMovement()) return canMove;
            canMove = true;
        }
    }

    public Movement.ORIENTATION findBoxDirection() {
        return puffleMovement.getOrientationFaced();
    }

    public boolean executeMovement() {
        Position box;

        switch(boxMovement.getOrientationFaced()) {
            case UP:
                box = boxMovement.moveUp();
                break;
            case DOWN:
                box = boxMovement.moveDown();
                break;
            case LEFT:
                box = boxMovement.moveLeft();
                break;
            case RIGHT:
                box = boxMovement.moveRight();
                break;
            default:
                box = levelModel.getBox().getPosition();
                break;
        }

        return getBoxInteract(box).execute(this);
    }

    private BoxInteract getBoxInteract(Position position) {
        ElementModel element = levelModel.find(position);
        return element.getBoxInteraction();
    }

    // --- Teleport Methods -- //
    public List<Teleport> getTeleport() {
        return levelModel.getTeleport();
    }

    public Position getTeleportPosition(Teleport teleport) {
        if(teleport.equals(getTeleport().get(0)))
            return getTeleport().get(1).getPosition();
        else
            return getTeleport().get(0).getPosition();
    }

    // --- Remove Key -- //
    public void removeKeyLock() {
        addIce(levelModel.getLock().getPosition());
        levelModel.setKey(null);
        levelModel.setLock(null);
    }

    // --- Coin and Score -- //
    public void removeCoin(Coin coin) {
        levelModel.getCoins().remove(coin);
    }


    // --- Melt Ice Methods -- //
    public void addWater(Position position) {
        Water water = new Water(position);
        water.setPuffleInteraction(new PuffleInteractStop(water));
        levelModel.getWater().add(water);
    }

    public void addIce(Position position){
        Ice ice = new Ice(position);
        ice.setPuffleInteraction(new PuffleInteractIce(ice));
        levelModel.getIce().add(ice);
    }

    public void removeIce(Position position) {
        levelModel.getIce().removeIf(ice -> ice.getPosition().equals(position));
    }

    public boolean removeToughIce(Position position){
        return levelModel.getToughIce().removeIf(toughIce -> toughIce.getPosition().equals(position));
    }

    // -- Change Melt Ice Strategy -- //
    public void meltPreviousIce() {
        Position pufflePos = levelModel.getPuffle().getPosition();

        meltStrategy.execute(pufflePos);
    }

    public void setStrategy(Strategy strategy) {
        this.meltStrategy = strategy;
    }

    public Movement getPuffleMovement() {
        return puffleMovement;
    }
}