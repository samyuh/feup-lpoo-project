package Controller.Element;

import Model.Elements.Hero;
import Model.Elements.Wall;
import Model.Elements.Water;
import Model.Position;

public class HeroMovement {
    Hero hero;

    public HeroMovement(Hero h) {
        this.hero = h;
    }

    public Position moveUp() {
        return new Position(hero.getPosition().getX(), hero.getPosition().getY() - 1);
    }

    public Position moveDown() {
        return new Position(hero.getPosition().getX(), hero.getPosition().getY() + 1);
    }

    public Position moveRight() {
        return new Position(hero.getPosition().getX() + 1, hero.getPosition().getY());
    }

    public Position moveLeft() {
        return new Position(hero.getPosition().getX() - 1, hero.getPosition().getY());
    }

    public boolean atPosition(Position target) {
        return hero.getPosition().equals(target);

    }

}
