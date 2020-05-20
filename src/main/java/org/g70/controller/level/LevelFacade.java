package org.g70.controller.level;

import org.g70.controller.level.boxInteract.BoxInteract;
import org.g70.controller.level.interact.Interact;
import org.g70.controller.level.interact.box.InteractBox;
import org.g70.controller.level.interact.ice.InteractIce;
import org.g70.controller.level.interact.level.InteractStop;
import org.g70.controller.level.movement.BoxMovement;
import org.g70.controller.level.strategy.Strategy;
import org.g70.model.drawable.element.*;
import org.g70.model.level.LevelModel;
import org.g70.model.Position;

import java.util.List;

public class LevelFacade {
    LevelModel levelModel;
    Strategy meltStrategy;

    public LevelFacade(LevelModel levelModel) {
        this.levelModel = levelModel;
    }

    // -- Refactor Box please bellow -- //
    // --- Move --- //
    public void move(Position position) {   
        levelModel.getPuffle().setPosition(position);
        // Need to set the position back in case it is blocked (block is raised to lose the game when box cant move)
        if(levelModel.getBox() != null) levelModel.getBox().setInteraction(new InteractBox(levelModel.getBox()));
    }

    // --- Box Methods -- //
    public BoxMovement.ORIENTATION findBoxDirection() {
        return levelModel.getBoxMovement().pufflePushedDirection(levelModel.getPuffle());
    }

    public void makeBoxMove( Position position){
        levelModel.getBox().setPosition(position);
    }

    public void executeMovement(Position position) {
        checkBoxMovement(position).execute(this);
    }

    private Interact checkMovement(Position position) {
        ElementModel element = levelModel.find(position);
        return element.getInteraction();
    }

    private BoxInteract checkBoxMovement(Position position) {
        ElementModel element = levelModel.find(position);
        return element.getBoxInteraction();
    }

    private boolean checkCollisions(Position position) {
        return checkMovement(position).getClass() == InteractStop.class;
    }

    public boolean moveBox() {
        boolean canMove = false;
        BoxMovement.ORIENTATION boxDirection = this.findBoxDirection();
        while(true) {
            Position position = levelModel.getBoxMovement().moveDirection(boxDirection);
            if(checkCollisions(position)) return canMove;
            executeMovement(position);
            canMove = true;

        }
    }

    // --- Teleport Methods -- //
    public List<Teleport> getTeleport() {
        return levelModel.getTeleport();
    }

    public Position getTeleportPosition(Teleport teleport) {
        if(teleport.getPosition().equals(getTeleport().get(0).getPosition()))
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
        water.setInteraction(new InteractStop(water));
        levelModel.getWater().add(water);
    }

    public void addIce(Position position){
        Ice ice = new Ice(position);
        ice.setInteraction(new InteractIce(ice));
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
}