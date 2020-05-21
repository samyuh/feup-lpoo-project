package org.g70.controller.level;

import org.g70.controller.MainController;
import org.g70.controller.level.movement.PuffleMovement;
import org.g70.controller.level.puffleinteract.*;
import org.g70.controller.level.puffleinteract.PuffleInteractStop;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.controller.state.StateGameOver;
import org.g70.model.drawable.element.*;
import org.g70.model.level.LevelHeaderModel;
import org.g70.model.level.LevelModel;
import org.g70.model.Position;
import org.g70.view.handler.KeyHandler;
import org.g70.view.level.LevelView;

import java.io.IOException;

public class LevelController {
    private LevelModel levelModel;
    private LevelView levelView;
    private LevelHeaderModel levelHeader;

    private MainController mainController;

    private LevelBuilder levelBuilder;

    private LevelFacade levelFacade;

    private PuffleMovement puffleMovement;

    private int levelNum;

    public LevelController(MainController mainController, LevelModel levelModel, LevelHeaderModel headerModel, LevelView levelView) {
        this.levelNum = 1;

        this.mainController = mainController;
        this.levelModel = levelModel;
        this.levelHeader = headerModel;
        this.levelView = levelView;

        this.levelBuilder = new LevelBuilder(levelModel);

        this.puffleMovement = new PuffleMovement(levelModel.getPuffle());
        this.levelFacade = new LevelFacade(levelModel);
        this.setLevel(false);
    }

    // Dup code //
    public void setLevel(boolean restart) {
        if(restart) levelHeader.resetGlobalScore();
        else levelHeader.lockGlobalScore();
        this.levelHeader.setLevelNumber(levelNum);
        this.levelModel.clearLevel(true);
        this.levelBuilder.initLevel(levelNum);
        this.puffleMovement = new PuffleMovement(levelModel.getPuffle());
        this.levelFacade.setStrategy(new StrategyRegular(levelFacade));
    }

    public void setLevelSecret() {
        this.levelModel.clearLevel(false);
        this.levelBuilder.initSecretLevel(levelNum);
        this.puffleMovement = new PuffleMovement(levelModel.getPuffle());
        this.levelFacade.setStrategy(new StrategyRegular(levelFacade));
    }
    // Dup code //

    public void addScore(int blocks, int score) {
        levelHeader.updateHeaderScore(blocks, score);
    }

    public void run() throws IOException {
        do {
            if (gameFinished()) break;

            levelView.draw();
        } while(processCommand(levelView.handler()));

        mainController.setState(new StateGameOver(mainController, levelHeader.getGlobalScore().getScore()));
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
                gameWon();
                return true;
            case RESTART:
                this.setLevel(true);
                return true;
            case CLOSE:
                return false;
        }
        return true;
    }

    public void executeMovement(Position position) {
        checkMovement(position).execute(this, levelFacade);
    }

    private PuffleInteract checkMovement(Position position){
        ElementModel element = levelModel.find(position);
        return element.getPuffleInteraction();
    }

    private boolean checkCollisions(Position position) {
        return checkMovement(position).getClass() == PuffleInteractStop.class;
    }

    public boolean gameFinished() {
        return checkCollisions(puffleMovement.moveUp()) && checkCollisions(puffleMovement.moveDown()) &&
                checkCollisions(puffleMovement.moveLeft()) && checkCollisions(puffleMovement.moveRight());
    }

    public void gameWon() {
        if (levelNum != 19) {
            levelNum++;
            setLevel(false);
        }
    }

    public void secretLevel() {
        setLevelSecret();
    }
}
