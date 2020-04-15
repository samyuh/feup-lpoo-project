package Controller.Game;

import Model.Elements.Ice;
import Model.Elements.Wall;
import Model.Game.Arena;
import Model.Game.Position;
import com.googlecode.lanterna.input.KeyStroke;

public class ArenaController {
    Arena arena;

    public ArenaController(Arena arena){
        this.arena = arena;
    }
    public boolean canHeroMove(Position position) {
        for (Wall wall : arena.walls){
            if (wall.getPosition().equals(position))
                return false;
        }
        for (Ice ice : arena.filled){
            if (ice.getPosition().equals(position))
                return false;
        }
        return true;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            arena.filled.add(new Ice(arena.hero.getPosition()));
            arena.hero.setPosition(position);
        }
    }

    public boolean processKey(KeyStroke key) {
        boolean checker = true;
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(arena.hero.moveUp());
                break;
            case ArrowDown:
                moveHero(arena.hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(arena.hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(arena.hero.moveRight());
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
        return arena.hero.getPosition().equals(arena.destination.getPosition());
    }

    public boolean gameLost() {
        return !(canHeroMove(arena.hero.moveUp()) || canHeroMove(arena.hero.moveDown()) ||
                canHeroMove(arena.hero.moveLeft()) || canHeroMove(arena.hero.moveRight()));
    }
}
