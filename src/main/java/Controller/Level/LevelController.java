package Controller.Level;

import Controller.Element.PuffleMovement;
import Controller.Interact.*;
import Model.Elements.*;
import Model.Level.LevelModel;
import Model.Position;
import View.KeyHandler;
import View.Level.LevelView;

import java.io.IOException;

public class LevelController {
    private LevelModel levelModel;
    private LevelView levelView;

    private LevelInitializer levelInitializer;

    private PuffleMovement puffleMovement;

    private int levelNum;

    public LevelController(LevelModel levelModel, LevelView levelView) {
        this.levelNum = 1;
        this.levelModel = levelModel;
        this.levelView = levelView;
        this.levelInitializer = new LevelInitializer(levelModel);
        levelInitializer.initLevel(levelNum);

        puffleMovement = new PuffleMovement(levelModel.getPuffle());
    }

    public void setLevel(int level) {
        levelNum = level;
        levelModel.clearLevel();
        levelInitializer.initLevel(levelNum);

        puffleMovement = new PuffleMovement(levelModel.getPuffle());
    }

    public boolean run() throws IOException {
        while (true) {
            levelView.draw(levelModel);

            if(!processCommand(levelView.handler())) return false;

            if(gameWon()) {
                if (levelNum != 19){
                    levelNum++;
                setLevel(levelNum);
                }
                else
                    return true;
            }

            if (gameLost()) return false;
        }
    }


    public boolean processCommand(KeyHandler.DIRECTION command) {
        switch (command) {
            case UP:
                moveHero(puffleMovement.moveUp());
                return true;
            case DOWN:
                moveHero(puffleMovement.moveDown());
                return true;
            case LEFT:
                moveHero(puffleMovement.moveLeft());
                return true;
            case RIGHT:
                moveHero(puffleMovement.moveRight());
                return true;
            case NEXT:
                this.levelModel.getPuffle().setPosition(levelModel.getDestination().getPosition());
                return true;
            case RESTART:
                this.setLevel(this.levelNum);
                return true;
            case CLOSE:
                return false;
        }
        return true;
    }

    public void moveHero(Position position) {
        checkMovement(position).execute(this);
    }

    private Interact checkMovement(Position position){
        ElementModel element = levelModel.find(position);
        return element.getInteraction();

    }

    private boolean checkCollisions(Position position) {
        return checkMovement(position).getClass() == InteractStop.class;
    }

    public boolean gameWon() {
        return puffleMovement.atPosition(levelModel.getDestination().getPosition());
    }

    public boolean gameLost() {
        return checkCollisions(puffleMovement.moveUp()) && checkCollisions(puffleMovement.moveDown()) &&
                checkCollisions(puffleMovement.moveLeft()) && checkCollisions(puffleMovement.moveRight()) &&
                !gameWon();
    }

    public PuffleMovement getPuffleMovement() {
        return puffleMovement;
    }

    public int getlevelNum() {
        return levelNum;
    }

    /// -- Spaguetti
    public int moveBox(DIRECTION boxDirection) {
        int count;
        count = 0;
        while(true){
            switch (boxDirection){
                case RIGHT:
                    if(checkCollisions(new Position(levelModel.getBox().getPosition().getX() + 1,levelModel.getBox().getPosition().getY()))) return count;
                    levelModel.getBox().setPosition(new Position(levelModel.getBox().getPosition().getX() + 1,levelModel.getBox().getPosition().getY()));
                    count++;
                    break;
                case LEFT:
                    if(checkCollisions(new Position(levelModel.getBox().getPosition().getX() - 1,levelModel.getBox().getPosition().getY()))) return count;
                    levelModel.getBox().setPosition(new Position(levelModel.getBox().getPosition().getX() - 1,levelModel.getBox().getPosition().getY()));
                    count++;
                    break;
                case UP:
                    if(checkCollisions(new Position(levelModel.getBox().getPosition().getX(),levelModel.getBox().getPosition().getY() - 1))) return count;
                    levelModel.getBox().setPosition(new Position(levelModel.getBox().getPosition().getX(),levelModel.getBox().getPosition().getY() - 1));
                    count++;
                    break;
                case DOWN:
                    if(checkCollisions(new Position(levelModel.getBox().getPosition().getX(),levelModel.getBox().getPosition().getY() + 1))) return count;
                    levelModel.getBox().setPosition(new Position(levelModel.getBox().getPosition().getX(),levelModel.getBox().getPosition().getY() + 1));
                    count++;
                    break;
                default:
                    return count;
            }
        }
    }

    public enum DIRECTION {UP, RIGHT, DOWN, LEFT, CLOSE, NEXT,RESTART};
    public DIRECTION findBoxDirection(){
        Position boxPosition  = levelModel.getBox().getPosition();
        Position heroPosition = levelModel.getPuffle().getPosition();
        if(boxPosition.getX() - heroPosition.getX() == 1) return DIRECTION.RIGHT;
        if(boxPosition.getX() - heroPosition.getX() == -1) return DIRECTION.LEFT;
        if(boxPosition.getY() - heroPosition.getY() == 1) return DIRECTION.DOWN;
        return DIRECTION.UP;
    }


    public void move(Position position) {
        levelModel.getPuffle().setPosition(position);
        // Need to set the position back in case it is blocked (block is raised to lose the game when box cant move)
        //if(box != null) box.setInteraction(new InteractBox(box));
    }

    public void removeKeyLock(){
        this.addIce(levelModel.getLock().getPosition());
        levelModel.setKey(null);
        levelModel.setLock(null);
    }

    public void addWater(){
        // If there is no toughIce below the hero
        if(!removeToughIce(levelModel.getPuffle().getPosition())) {
            Water water = new Water(levelModel.getPuffle().getPosition());
            water.setInteraction(new InteractStop(water));
            levelModel.getWater().add(water);
        }
        //If there is toughIce below the hero
        else{
            this.addIce(levelModel.getPuffle().getPosition());
        }
    }

    public void addIce(Position position){
        Ice ice = new Ice(position);
        ice.setInteraction(new InteractIce(ice));
        levelModel.getIce().add(ice);
    }

    public void removeCoin(Coin coin){
        levelModel.getCoins().remove(coin);
    }

    public void removeIce(Ice ice){
        levelModel.getIce().remove(ice);
    }

    public Position getTeleportPosition(Teleport teleport) {
        if(teleport.getPosition().equals(levelModel.getTeleport1().getPosition())){
            return levelModel.getTeleport2().getPosition();
        }
        else
            return levelModel.getTeleport1().getPosition();
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
