package controller.level;

import controller.element.PuffleMovement;
import controller.interact.*;
import model.drawable.levelheader.LevelCurrent;
import model.drawable.element.*;
import model.level.LevelModel;
import model.Position;
import view.KeyHandler;
import view.level.LevelView;

import java.io.IOException;

public class LevelController {
    private LevelModel levelModel;
    private LevelView levelView;

    private LevelUpdateModel update;

    private LevelInitializer levelInitializer;

    private PuffleMovement puffleMovement;

    private LevelCurrent levelCurrent;

    public LevelController(LevelModel levelModel, LevelView levelView) {
        this.levelCurrent = new LevelCurrent(1);
        this.levelModel = levelModel;
        this.levelView = levelView;
        this.levelInitializer = new LevelInitializer(levelModel);
        levelInitializer.initLevel(levelCurrent.getLevelNumber());

        puffleMovement = new PuffleMovement(levelModel.getPuffle());

        this.update = new LevelUpdateModel(levelModel);
    }

    public void setLevel(LevelCurrent levelNumber) {
        levelCurrent = levelNumber;
        levelModel.clearLevel();
        levelInitializer.initLevel(levelCurrent.getLevelNumber());

        puffleMovement = new PuffleMovement(levelModel.getPuffle());
    }

    public boolean run() throws IOException {
        while (true) {
            levelView.draw(levelModel);

            if(!processCommand(levelView.handler())) return false;

            if(gameWon()) {
                if (levelCurrent.getLevelNumber() != 19){
                    levelCurrent.increment();
                    setLevel(levelCurrent);
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
                this.setLevel(this.levelCurrent);
                return true;
            case CLOSE:
                return false;
        }
        return true;
    }

    public void moveHero(Position position) {
        checkMovement(position).execute(update);
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
        return levelCurrent.getLevelNumber();
    }
}
