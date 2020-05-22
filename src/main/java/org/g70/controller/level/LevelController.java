package org.g70.controller.level;

import org.g70.controller.level.interact.InteractStop;
import org.g70.model.level.LevelHeaderModel;
import org.g70.model.level.LevelModel;
import org.g70.model.Position;
import org.g70.view.handler.KeyHandler;
import org.g70.view.game.LevelView;

import java.io.IOException;

public class LevelController {
    private LevelModel levelModel;
    private LevelView levelView;
    private LevelHeaderModel levelHeader;
    private LevelBuilder levelBuilder;
    private LevelFacade levelFacade;
    private int levelNum;

    public LevelController(LevelModel levelModel, LevelHeaderModel headerModel, LevelView levelView) {
        this.levelModel = levelModel;
        this.levelView = levelView;
        this.levelHeader = headerModel;
        levelBuilder = new LevelBuilder(levelModel);
        levelFacade = new LevelFacade(levelModel);
        levelNum = 1;

        initLevel(false);
    }

    public void initRegularLevel(boolean restart) {
        if(restart) levelHeader.resetGlobalScore();
        else levelHeader.lockGlobalScore();

        initLevel(false);
    }

    public void initSecretLevel() {
        this.initLevel(true);
    }

    private void initLevel(boolean secretLevel) {
        levelModel.clearLevel(secretLevel);
        levelBuilder.initLevel(levelNum, secretLevel);
        levelHeader.setLevelNumber(levelNum);
        levelFacade.newLevelMovement();
    }

    public void run() throws IOException {
        do {
            if (gameFinished()) break;
            levelView.draw();
        } while(processCommand(levelView.handler()));
    }

    private boolean processCommand(KeyHandler.KEY command) {
        switch (command) {
            case UP:
                executePuffleMovement(levelFacade.getPuffleMovement().moveUp());
                return true;
            case DOWN:
                executePuffleMovement(levelFacade.getPuffleMovement().moveDown());
                return true;
            case LEFT:
                executePuffleMovement(levelFacade.getPuffleMovement().moveLeft());
                return true;
            case RIGHT:
                executePuffleMovement(levelFacade.getPuffleMovement().moveRight());
                return true;
            case NEXT:
                gameWon();
                return true;
            case RESTART:
                this.initRegularLevel(true);
                return true;
            case CLOSE:
                return false;
        }
        return true;
    }

    public void addScore(int blocks, int score) {
        levelHeader.updateHeaderScore(blocks, score);
    }

    public void executePuffleMovement(Position position) {
        levelFacade.getInteract(position).executePuffle(this, levelFacade);
    }

    private boolean checkCollisions(Position position) {
        return levelFacade.getInteract(position).getClass() == InteractStop.class;
    }

    private boolean gameFinished() {
        return checkCollisions(levelFacade.getPuffleMovement().moveUp()) &&
               checkCollisions(levelFacade.getPuffleMovement().moveDown()) &&
               checkCollisions(levelFacade.getPuffleMovement().moveLeft()) &&
               checkCollisions(levelFacade.getPuffleMovement().moveRight());
    }

    public void gameWon() {
        if (levelNum != 19) {
            levelNum++;
            initRegularLevel(false);
        }
    }
}
