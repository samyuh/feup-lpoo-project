package org.g70.controller.level;

import org.g70.controller.level.interact.*;
import org.g70.controller.level.strategy.*;
import org.g70.controller.level.strategy.MeltIce;
import org.g70.model.drawable.element.*;
import org.g70.model.drawable.element.immovable.*;
import org.g70.model.drawable.element.movable.*;
import org.g70.model.level.LevelModel;
import org.g70.model.Position;

import java.util.List;

public class LevelElementController {
    private LevelModel levelModel;
    private Melt melt;
    private Box boxMovement;
    private Puffle puffleMovement;

    public LevelElementController(LevelModel levelModel) {
        this.levelModel = levelModel;
    }

    public void newLevelMovement() {
        updatePuffleMovement();
        updateBoxMovement();
        melt = new MeltIce(this);
    }

    private void updatePuffleMovement() {
        puffleMovement = levelModel.getPuffle();
    }

    public void movePuffle(Position position) {
        meltPreviousIce();

        levelModel.getPuffle().setPosition(position);

        if (levelModel.getBox() != null)
            resetBoxInteraction();
    }

    public Melt getMeltStrategy() {
        return melt;
    }

    public void setMelt(Melt strategy) {
        melt = strategy;
    }

    public void meltPreviousIce() {
        melt.execute(puffleMovement.getPosition());
    }

    private void updateBoxMovement() {
        boxMovement = levelModel.getBox();
    }

    public void moveBox(Position position){
        levelModel.getBox().setPosition(position);
    }

    private void resetBoxInteraction() {
        levelModel.getBox().setInteraction(new InteractBox(levelModel.getBox()));
    }

    public boolean boxLoop() {
        int x = puffleMovement.lastDisplacementX();
        int y = puffleMovement.lastDisplacementY();

        if(!executeBoxMovement(x, y))
            return false;

        while(executeBoxMovement(x, y));

        return true;
    }

    private boolean executeBoxMovement(int x, int y) {
        Position position = boxMovement.moveDisplacement(x, y);

        return getInteract(position).executeBox(this);
    }

    public Interact getInteract(Position position) {
        ElementModel element = levelModel.find(position);
        return element.getInteraction();
    }

    public List<Teleport> getTeleport() {
        return levelModel.getTeleports();
    }

    public Position getTeleportPosition(Teleport teleport) {
        if(teleport.equals(getTeleport().get(0)))
            return getTeleport().get(1).getPosition();
        else
            return getTeleport().get(0).getPosition();
    }

    public void removeKeyLock() {
        levelModel.setKey(null);
        addIce(levelModel.getLock().getPosition());
        levelModel.setLock(null);
    }

    public void removeCoin(Coin coin) {
        levelModel.getCoins().remove(coin);
    }

    public void addWater(Position position) {
        Water water = new Water(position);
        levelModel.addWater(water);
    }

    public void addIce(Position position){
        Ice ice = new Ice(position);
        levelModel.addIce(ice);
    }

    public void removeIce(Position position) {
        levelModel.getIce().removeIf(ice -> ice.getPosition().equals(position));
    }

    public void removeToughIce(Position position){
        levelModel.getDoubleIce().removeIf(toughIce -> toughIce.getPosition().equals(position));
    }
}