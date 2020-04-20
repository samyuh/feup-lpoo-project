package Controller.Game;

import Model.Elements.Coin;
import Model.Elements.Ice;
import Model.Elements.Wall;
import Model.Game.Arena;
import Model.Game.Position;
import com.googlecode.lanterna.input.KeyStroke;

public class ArenaController {
    Arena model;

    public ArenaController(Arena model){
        this.model = model;
    }

    private boolean checkCollisions(Position position) {
        for (Wall wall : model.getWalls()){
            if (wall.getPosition().equals(position))
                return true;
        }
        for (Ice ice : model.getFilled()){
            if (ice.getPosition().equals(position))
                return true;
        }
        return model.getLock() != null && model.getLock().getPosition().equals(position);
    }
    public boolean canHeroMove(Position position) {
        if (checkCollisions(position)) return false;
        if (model.removeCoin(position)){
            model.addPoints(10);
            return true;
        }
        if(model.getKey() != null && model.getKey().getPosition().equals(position)){
            model.setKey(null);
            model.setLock(null);
        }

        model.addPoints(1);
        return true;
    }


    public void moveHero(Position position) {
        if (canHeroMove(position)){
            if(!model.removeWhite(model.getHero().getPosition()))
                model.getFilled().add(new Ice(model.getHero().getPosition()));
            model.getHero().setPosition(position);
        }
    }

    public boolean gameWon() {
        return model.getHero().getPosition().equals(model.getDestination().getPosition());
    }

    public boolean gameLost() {
        return (checkCollisions(model.getHero().moveUp()) && checkCollisions(model.getHero().moveDown()) &&
                checkCollisions(model.getHero().moveLeft()) && checkCollisions(model.getHero().moveRight()));
    }

    public boolean processKey(KeyStroke key) {
        boolean checker = true;
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(model.getHero().moveUp());
                break;
            case ArrowDown:
                moveHero(model.getHero().moveDown());
                break;
            case ArrowLeft:
                moveHero(model.getHero().moveLeft());
                break;
            case ArrowRight:
                moveHero(model.getHero().moveRight());
                break;
            case Character:
                if(key.getCharacter() == 'q')
                    checker = false;
                break;
            case EOF:
                checker = false;
                break;
            default:
                break;
        }
        System.out.println(key);
        return checker;
    }
}
