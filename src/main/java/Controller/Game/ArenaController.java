package Controller.Game;

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

    public boolean canHeroMove(Position position) {
        for (Wall wall : model.getWalls()){
            if (wall.getPosition().equals(position))
                return false;
        }
        for (Ice ice : model.getFilled()){
            if (ice.getPosition().equals(position))
                return false;
        }
        return true;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            model.getFilled().add(new Ice(model.getHero().getPosition()));
            model.getHero().setPosition(position);
        }
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

    public boolean gameWon() {
        return model.getHero().getPosition().equals(model.getDestination().getPosition());
    }

    public boolean gameLost() {
        return !(canHeroMove(model.getHero().moveUp()) || canHeroMove(model.getHero().moveDown()) ||
                canHeroMove(model.getHero().moveLeft()) || canHeroMove(model.getHero().moveRight()));
    }
}
