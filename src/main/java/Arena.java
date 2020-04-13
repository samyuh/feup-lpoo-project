import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.exit;

public class Arena {

    private int width;
    private int height;
    private List<Wall> walls;


    private Hero hero;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(new Position(11,11));
        this.walls = createLevel1();
    }

    private List<Wall> createLevel1(){
        List<Wall> walls = new ArrayList<>();
        int x = 10;
        int y = 10;

        for(int c = y;c < y + 3;c++){
            walls.add(new Wall(x,c));
            walls.add(new Wall(x+15,c));
        }

        for(int r = x + 1;r < x + 15;r++){
            walls.add(new Wall(r,y));
            walls.add(new Wall(r,y+2));
        }

        return walls;
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {

            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);

    }



    public boolean canHeroMove(Position position){
        for (Wall wall : walls){
            if (wall.getPosition().equals(position))
                return false;
        }
        return true;

    }
    public void moveHero(Position position){
        if (canHeroMove(position)){
            walls.add( new Wall(hero.getPosition().getX(),hero.getPosition().getY()));
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
                moveHero(hero.moveLeft());;
                break;
            case ArrowRight:
                moveHero(hero.moveRight());;
                break;
            case Character:
                if(key.getCharacter() == 'q') {
                    checker = false;
                }
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
