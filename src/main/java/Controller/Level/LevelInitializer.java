package Controller.Level;

import Model.Elements.*;
import Model.Level.LevelModel;
import Model.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LevelInitializer {
    private List<String> mapElements;
    private LevelModel model;
    private int levelNumber;

    public LevelInitializer(LevelModel model) {
        this.model = model;
    }

    private List<String> readLines() throws IOException {
        URL resource = LevelInitializer.class.getResource("/rooms/level" + this.levelNumber + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);

        return lines;
    }

    private void loadElements() {
        List<Wall> walls = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();
        List<ToughIce> toughIce = new ArrayList<>();
        List<Ice> ice = new ArrayList<>();

        for(int yi = 0; yi < this.mapElements.size(); yi++) {
            for(int xi = 0; xi < this.mapElements.get(yi).length() ; xi++) {
                char c = this.mapElements.get(yi).charAt(xi);
                if(c == 'W') walls.add(new Wall( new Position(xi,yi)));
                if(c == '.') ice.add(new Ice(new Position(xi,yi)));
                if(c == 'C') coins.add(new Coin(new Position(xi,yi)));
                if(c == 'B') toughIce.add(new ToughIce(new Position(xi,yi)));
                if(c == 'K') model.setKey(new Key(new Position(xi,yi)));
                if(c == 'L') model.setLock(new Lock(new Position(xi,yi)));
                if(c == 'S') model.setHero(new Hero(new Position(xi,yi)));
                if(c == 'D') model.setDestination(new Destination(new Position(xi,yi)));
            }
        }
        model.setWalls(walls);
        model.setIce(ice);
        model.setCoins(coins);
        model.setToughIce(toughIce);
        model.setInteractions();
    }

    public void initLevel(int levelNumber) {
        try {
            this.levelNumber = levelNumber;
            this.mapElements = readLines();
            loadElements();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
