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

    private LevelUpdateModel update;

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

        this.update = new LevelUpdateModel(levelModel);
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
        return levelNum;
    }
}
