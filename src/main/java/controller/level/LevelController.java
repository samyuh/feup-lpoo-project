package controller.level;

import controller.element.PuffleMovement;
import controller.interact.*;
import model.drawable.levelheader.LevelCurrent;
import model.drawable.element.*;
import model.level.LevelModel;
import model.Position;
import view.handler.KeyHandler;
import view.level.LevelView;

import java.io.IOException;

public class LevelController {
    private LevelModel levelModel;
    private LevelView levelView;
    private LevelUpdateModel update;
    private LevelInitializer levelInitializer;
    private PuffleMovement puffleMovement;
    private LevelCurrent levelCurrent;
    private int globalPoints;

    public LevelController(LevelModel levelModel, LevelView levelView) {
        this.levelCurrent = new LevelCurrent(1);
        this.levelModel = levelModel;
        this.levelView = levelView;
        this.levelInitializer = new LevelInitializer(levelModel,globalPoints);
        levelInitializer.initLevel(levelCurrent.getLevelNumber(),false);

        puffleMovement = new PuffleMovement(levelModel.getPuffle());

        this.update = new LevelUpdateModel(levelModel);

        this.globalPoints = 0;
    }

    public void setLevel(LevelCurrent levelNumber, boolean restart) {
        levelCurrent = levelNumber;
        levelModel.clearLevel(true);
        levelInitializer.initLevel(levelCurrent.getLevelNumber(), restart);
        puffleMovement = new PuffleMovement(levelModel.getPuffle());
    }

    public void startSecret(LevelCurrent levelNumber) {
        levelCurrent = levelNumber;
        levelModel.clearLevel(false);
        levelInitializer.initSecretLevel(levelCurrent.getLevelNumber());
        puffleMovement = new PuffleMovement(levelModel.getPuffle());
    }

    public void run() throws IOException {
        do {
            if (levelCurrent.getLevelNumber() == 19 && secretLevelFound())
                startSecret(levelCurrent);

            if(gameWon()) {
                if (levelCurrent.getLevelNumber() != 19){
                    levelCurrent.increment();
                    setLevel(levelCurrent,false);
                }
                else break;
            }

            if (gameLost()) break;

            levelView.draw(levelModel);
        } while(processCommand(levelView.handler()));
    }


    public boolean processCommand(KeyHandler.DIRECTION command) {
        switch (command) {
            case UP:
                executeMovement(puffleMovement.moveUp());
                return true;
            case DOWN:
                executeMovement(puffleMovement.moveDown());
                return true;
            case LEFT:
                executeMovement(puffleMovement.moveLeft());
                return true;
            case RIGHT:
                executeMovement(puffleMovement.moveRight());
                return true;
            case NEXT:
                this.levelModel.getPuffle().setPosition(levelModel.getDestination().getPosition());
                return true;
            case RESTART:
                this.setLevel(this.levelCurrent,true);
                return true;
            case CLOSE:
                return false;
        }
        return true;
    }

    public void executeMovement(Position position) {
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

    public boolean secretLevelFound(){ return puffleMovement.atPosition(levelModel.getSecretDestination().getPosition()); }

    public boolean gameLost() {
        return checkCollisions(puffleMovement.moveUp()) && checkCollisions(puffleMovement.moveDown()) &&
                checkCollisions(puffleMovement.moveLeft()) && checkCollisions(puffleMovement.moveRight()) &&
                !gameWon();
    }
}
