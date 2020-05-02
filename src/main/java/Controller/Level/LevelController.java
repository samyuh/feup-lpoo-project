package Controller.Level;

import Controller.Element.HeroMovement;
import Model.Elements.Wall;
import Model.Elements.Water;
import Model.Level.LevelModel;
import Model.Position;
import View.Level.LevelView;

import java.io.IOException;

public class LevelController {
    private LevelModel levelModel;
    private LevelView levelView;

    private LevelInitializer levelInitializer;

    private HeroMovement heroM;

    private int numLevel;

    public LevelController(LevelModel levelModel, LevelView levelView) {
        this.numLevel = 1;
        this.levelModel = levelModel;
        this.levelView = levelView;
        this.levelInitializer = new LevelInitializer(levelModel);
        levelInitializer.initLevel(numLevel);

        heroM = new HeroMovement(levelModel.getHero());
    }

    public void setLevel(int level) {
        levelModel.clearLevel();
        levelInitializer.initLevel(level);

        heroM = new HeroMovement(levelModel.getHero());
    }

    public boolean run() throws IOException {
        while (true) {
            levelView.draw(levelModel);

            if(!processCommand(levelView.processKey()))
                return false;

            if(gameWon()) {
                if(numLevel != 15)
                    setLevel(++numLevel);
                else
                    return true;
            }
            if(gameLost())
                return false;
        }
    }


    public boolean processCommand(LevelView.DIRECTION command) {
        switch (command) {
            case UP:
                moveHero(heroM.moveUp());
                return true;
            case DOWN:
                moveHero(heroM.moveDown());
                return true;
            case LEFT:
                moveHero(heroM.moveLeft());
                return true;
            case RIGHT:
                moveHero(heroM.moveRight());
                return true;
            case CLOSE:
                return false;
        }
        return false;
    }

    public void moveHero(Position position) {
        if (!checkCollisions(position)) {
            if(!levelModel.removeWhite(levelModel.getHero().getPosition()))
                levelModel.getFilled().add(new Water(levelModel.getHero().getPosition()));
            levelModel.getHero().setPosition(position);

            if (levelModel.removeCoin(position)) levelModel.addPoints(10);
            else levelModel.addPoints(1);

            if(levelModel.getKey() != null && levelModel.getKey().getPosition().equals(position)){
                levelModel.setKey(null);
                levelModel.setLock(null);
            }
        }
    }

    private boolean checkCollisions(Position position) {
        for (Wall wall : levelModel.getWalls()){
            if (wall.getPosition().equals(position))
                return true;
        }
        for (Water water : levelModel.getFilled()){
            if (water.getPosition().equals(position))
                return true;
        }
        return levelModel.getLock() != null && levelModel.getLock().getPosition().equals(position);
    }

    public boolean gameWon() {
        return heroM.atPosition(levelModel.getDestination().getPosition());
    }

    public boolean gameLost() {
        return (checkCollisions(heroM.moveUp()) && checkCollisions(heroM.moveDown()) &&
                checkCollisions(heroM.moveLeft()) && checkCollisions(heroM.moveRight()));
    }
}