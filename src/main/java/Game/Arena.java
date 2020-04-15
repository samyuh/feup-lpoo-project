package Game;

import Elements.Destination;
import Elements.Hero;
import Elements.Ice;
import Elements.Wall;
import Elements.Key;
import Elements.Coin;
import Elements.Lock;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.swing.TerminalScrollController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private Destination destination;
    private Level level;
    private List<Wall> walls;
    private List<Ice> filled;
    private List<Coin> coins;

    public void setKey(Key key) {
        this.key = key;
    }

    private Key key;
    private Lock lock;
    private int points;

    public Level getLevel() {
        return level;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }
    public void removeCoin(Position position){
        for(Coin coin : this.coins){
            if(coin.getPosition().equals(position)){
                this.coins.remove(coin);
                break;
            }
        }
    }
    public void removeKey(){
        this.key = null;
    }
    public void removeLock(){
        this.lock = null;
    }

    public Arena(int width, int height, int level) {
        this.width = width;
        this.height = height;
        this.points = 0;

        // Create a new class for this
        this.level = new Level(level);
        this.walls = new ArrayList<>();
        this.filled = new ArrayList<>();
        this.coins  = new ArrayList<>();
        createMapLevel();
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    private void createMapLevel() {
        List<String> mapInfo = level.getMapInfo();
        List<Wall> walls = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();


        for(int yi = 0; yi < mapInfo.size(); yi++) {
            for(int xi = 0; xi < mapInfo.get(yi).length() ; xi++) {
                char c = mapInfo.get(yi).charAt(xi);
                if(c == 'W')
                    walls.add(new Wall( new Position(xi,yi)));
                if(c == 'D')
                    this.destination = new Destination(new Position(xi,yi));
                if(c == 'C')
                    coins.add(new Coin(new Position(xi,yi)));
                if(c == 'K')
                    setKey(new Key(new Position(xi,yi)));
                if(c == 'L')
                    setLock(new Lock(new Position(xi,yi)));
                if(c == 'S')
                    this.hero = new Hero(new Position(xi,yi));

            }
        }
        setWalls(walls);
        setCoins(coins);
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        destination.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Ice ice : filled)
            ice.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        if(this.key != null) key.draw(graphics);
        if(this.lock != null) lock.draw(graphics);
        hero.draw(graphics);
        //Draw Points (I guess que posso tornar num método, mas esta feature é temporária xD)
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(20, 0), Integer.toString(this.points) );
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
        if(lock != null && lock.getPosition().equals(position))
            return false;
        for (Coin coin : coins){
            if(coin.getPosition().equals(position)){
                this.points += 10;
                this.removeCoin(position);
                return true;
            }
        }
        if(key != null && key.getPosition().equals(position)){
            removeKey();
            removeLock();
        }

        this.points += 1;
        return true;
    }

    public boolean willHeroLose(Position position) {
        for (Wall wall : walls){
            if (wall.getPosition().equals(position))
                return false;
        }
        for (Ice ice : filled){
            if (ice.getPosition().equals(position))
                return false;
        }
        if(lock != null && lock.getPosition().equals(position))
            return false;
        return true;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)){
            filled.add(new Ice(hero.getPosition()));
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
    public boolean gameLost() {
        return !(willHeroLose(hero.moveUp()) || willHeroLose(hero.moveDown()) ||
                willHeroLose(hero.moveLeft()) || willHeroLose(hero.moveRight()));
    }
}
