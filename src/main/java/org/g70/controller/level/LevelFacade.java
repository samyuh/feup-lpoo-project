package org.g70.controller.level;

import org.g70.controller.level.interact.Interact;
import org.g70.controller.level.movement.BoxMovement;
import org.g70.controller.level.movement.Movement;
import org.g70.controller.level.movement.PuffleMovement;
import org.g70.controller.level.interact.InteractBox;
import org.g70.controller.level.interact.InteractIce;
import org.g70.controller.level.interact.InteractStop;
import org.g70.controller.level.strategy.MeltStrategy;
import org.g70.controller.level.strategy.StrategyIce;
import org.g70.model.drawable.element.*;
import org.g70.model.level.LevelModel;
import org.g70.model.Position;

import java.util.List;

public class LevelFacade {
    LevelModel levelModel;

    private BoxMovement boxMovement;
    private PuffleMovement puffleMovement;

    MeltStrategy meltStrategy;

    public LevelFacade(LevelModel levelModel) {
        this.levelModel = levelModel;
    }

    public void newLevelMovement() {
        updatePuffleMovement();
        updateBoxMovement();
        setMeltStrategy(new StrategyIce(this));
    }

    public Movement getPuffleMovement() {
        return puffleMovement;
    }

    private void updatePuffleMovement() {
        this.puffleMovement = new PuffleMovement(levelModel.getPuffle());
    }

    public void movePuffle(Position position) {
        levelModel.getPuffle().setPosition(position);

        if (levelModel.getBox() != null)
            resetBoxInteraction();
    }

    public void setMeltStrategy(MeltStrategy strategy) {
        this.meltStrategy = strategy;
    }

    public void meltPreviousIce() {
        meltStrategy.execute(puffleMovement.getPosition());
    }

    private void updateBoxMovement() {
        this.boxMovement = new BoxMovement(levelModel.getBox());
    }

    public void moveBox(Position position){
        levelModel.getBox().setPosition(position);
    }

    public void resetBoxInteraction() {
        levelModel.getBox().setInteraction(new InteractBox(levelModel.getBox()));
    }

    public boolean boxLoop() {
        int x = puffleMovement.lastDisplacementX();
        int y = puffleMovement.lastDisplacementY();

        if(!executeBoxMovement(x, y))
            return false;

        while(executeBoxMovement(x, y)) {}

        return true;
    }

    public boolean executeBoxMovement(int x, int y) {
        Position position = boxMovement.moveDisplacement(x, y);

        return getInteract(position).executeBox(this);
    }

    public Interact getInteract(Position position) {
        ElementModel element = levelModel.find(position);
        return element.getInteraction();
    }

    public List<Teleport> getTeleport() {
        return levelModel.getTeleport();
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
        return levelModel.getDoubleIce().removeIf(toughIce -> toughIce.getPosition().equals(position));
    }
}