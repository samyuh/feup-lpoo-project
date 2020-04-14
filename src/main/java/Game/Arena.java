package Game;

import Elements.Destination;
import Elements.Hero;
import Elements.Ice;
import Elements.Wall;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;

    private Level level;
    private List<Wall> walls;
    private List<Ice> filled;

    public int getLevel() {
        return level.getNumber();
    }

    private Destination destination;

    private Hero hero;

    public Arena(int width, int height, int level) {
        this.width = width;
        this.height = height;

        // Create a new class for this
        this.level = new Level(level);
        this.walls = createMapLevel();
        this.filled = new ArrayList<>();
    }

    private List<Wall> createMapLevel() {
        List<String> mapInfo = level.getMapInfo();
        List<Wall> walls = new ArrayList<>();

        for(int yi = 0; yi < mapInfo.size(); yi++) {
            for(int xi = 0; xi < mapInfo.get(yi).length() ; xi++) {
                char c = mapInfo.get(yi).charAt(xi);
                if(c == 'W')
                    walls.add(new Wall(xi,yi));
                if(c == 'D')
                    this.destination = new Destination(new Position(xi,yi));
                if(c == 'S')
                    this.hero = new Hero(new Position(xi,yi));
            }
        }

        return walls;
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        destination.draw(graphics);
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Ice ice : filled)
            ice.draw(graphics);
    }

    public boolean canHeroMove(Position position) {
        for (Wall wall : walls){
            if (wall.getPosition().equals(position))
                return false;
        }
        for (Ice ice : filled){
            if (ice.getPosition().equals(position))
                return false;
        }
        return true;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            filled.add(new Ice(hero.getPosition().getX(), hero.getPosition().getY()));
            hero.setPosition(position);
        }
    }

    public boolean processKey(KeyStroke key) {
        boolean checker = true;
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
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
        return hero.getPosition().equals(destination.getPosition());
    }
}
