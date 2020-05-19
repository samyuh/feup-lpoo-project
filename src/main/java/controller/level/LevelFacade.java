package controller.level;

import controller.level.interact.Interact;
import controller.level.interact.box.InteractBox;
import controller.level.interact.ice.InteractIce;
import controller.level.interact.level.InteractStop;
import controller.level.strategy.Strategy;
import controller.level.strategy.StrategyRegular;
import model.drawable.element.*;
import model.level.LevelModel;
import model.Position;

public class LevelFacade {
    LevelModel levelModel;
    Strategy move;
    private boolean secretFound;

    public LevelFacade(LevelModel levelModel) {
        this.levelModel = levelModel;
        this.secretFound = false;
        this.move = new StrategyRegular(this);
    }

    // MOVE
    public void move(Position position) {   
        levelModel.getPuffle().setPosition(position);
        // Need to set the position back in case it is blocked (block is raised to lose the game when box cant move)
        if(levelModel.getBox() != null) levelModel.getBox().setInteraction(new InteractBox(levelModel.getBox()));
    }

    // --- Box Methods -- //
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

    public boolean isOnBoxFinalSquare(Position position){
        return (levelModel.getBoxFinalSquare() != null && levelModel.getBoxFinalSquare().getPosition().equals(position));
    }

    // --- Teleport Methods -- //
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

    // --- Remove Key -- //
    public void removeKeyLock() {
        addIce(levelModel.getLock().getPosition());
        levelModel.setKey(null);
        levelModel.setLock(null);
    }

    // --- Secret Level -- //
    public boolean isSecretFound(){
        return secretFound;
    }

    public void setSecretFound(){
        secretFound = true;
    }

    // --- Coin and Score -- //
    public void removeCoin(Coin coin) {
        levelModel.getCoins().remove(coin);
    }

    public void addScore(int levelPoints, int globalPoints) {
        levelModel.getLevelHeaderModel().addScore(levelPoints, globalPoints);
    }


    // --- Melt Ice Methods -- //
    public void meltPreviousIce() {
        Position pufflePos = levelModel.getPuffle().getPosition();

        move.execute(pufflePos);
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
        return levelModel.getToughIce().removeIf(toughIce -> toughIce.getPosition().equals(position));
    }

    // -- Test
    public void setStrategy(Strategy st) {
        this.move = st;
    }
}