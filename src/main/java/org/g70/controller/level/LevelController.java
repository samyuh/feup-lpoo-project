package org.g70.controller.level;

import org.g70.controller.level.interact.InteractStop;
import org.g70.model.level.LevelHeaderModel;
import org.g70.model.level.LevelModel;
import org.g70.model.Position;
import org.g70.view.game.GeneralView;
import org.g70.view.handler.KeyHandler;

import java.io.IOException;

public class LevelController {
    private LevelModel levelModel;
    private GeneralView levelView;
    private LevelHeaderModel levelHeader;
    private LevelBuilder levelBuilder;
    private LevelElementController levelElementController;
    private int levelNum;

    public LevelController(LevelModel levelModel, LevelHeaderModel headerModel, GeneralView levelView) {
        this.levelModel = levelModel;
        this.levelView = levelView;
        this.levelHeader = headerModel;
        levelBuilder = new LevelBuilder(levelModel);
        levelElementController = new LevelElementController(levelModel);
        levelNum = 1;

        initLevel(false);
    }

    public int getLevelNum() {
        return levelNum;
    }

    public LevelElementController getLevelElementController() {
        return levelElementController;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
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
        levelElementController.newLevelMovement();
    }

    public void run() throws IOException {
        do {
            if (gameFinished()) break;
            levelView.draw();
        } while(processCommand(levelView.handler()));
    }

    public boolean processCommand(KeyHandler.KEY command) {
        switch (command) {
            case UP:
                executePuffleMovement(levelModel.getPuffle().moveUp());
                return true;
            case DOWN:
                executePuffleMovement(levelModel.getPuffle().moveDown());
                return true;
            case LEFT:
                executePuffleMovement(levelModel.getPuffle().moveLeft());
                return true;
            case RIGHT:
                executePuffleMovement(levelModel.getPuffle().moveRight());
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
        levelElementController.getInteract(position).executePuffle(this, levelElementController);
    }

    private boolean checkCollisions(Position position) {
        return levelElementController.getInteract(position).getClass() == InteractStop.class;
    }

    public boolean gameFinished() {
        return checkCollisions(levelModel.getPuffle().moveUp()) &&
               checkCollisions(levelModel.getPuffle().moveDown()) &&
               checkCollisions(levelModel.getPuffle().moveLeft()) &&
               checkCollisions(levelModel.getPuffle().moveRight());
    }

    public void gameWon() {
        if (levelNum != 19) {
            levelNum++;
            initRegularLevel(false);
        }
    }
}
