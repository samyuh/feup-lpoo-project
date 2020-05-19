package controller.level;

import controller.level.interact.Interact;
import controller.level.interact.box.InteractBox;
import controller.level.interact.ice.InteractIce;
import controller.level.interact.level.InteractStop;
import controller.level.movement.BoxMovement;
import controller.level.strategy.Strategy;
import controller.level.strategy.StrategyRegular;
import model.drawable.element.*;
import model.level.LevelModel;
import model.Position;

import java.util.List;

public class LevelFacade {
    LevelModel levelModel;
    Strategy meltStrategy;

    public LevelFacade(LevelModel levelModel) {
        this.levelModel = levelModel;
        this.meltStrategy = new StrategyRegular(this);
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

    private Interact checkMovement(Position position) {
        ElementModel element = levelModel.find(position);
        return element.getInteraction();
    }

    private boolean checkCollisions(Position position) {
        return checkMovement(position).getClass() == InteractStop.class;
    }

    public boolean moveBox() {
        boolean canMove = false;
        BoxMovement.ORIENTATION boxDirection = this.findBoxDirection();
        while(true) {
            if(checkCollisions(levelModel.getBoxMovement().moveDirection(boxDirection))) return canMove;
            levelModel.getBox().setPosition(levelModel.getBoxMovement().moveDirection(boxDirection));
            canMove = true;
        }
    }

    // --- Teleport Methods -- //
    public List<Teleport> getTeleport() {
        return levelModel.getTeleports();
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

    public void addScore(int levelPoints, int globalPoints) {
        levelModel.getLevelHeaderModel().addScore(levelPoints, globalPoints);
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