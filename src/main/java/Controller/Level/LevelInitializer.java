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
    private int levelNumber;
    private LevelModel model;

    public LevelInitializer(LevelModel model, int levelNumber) {
        try {
            this.levelNumber = levelNumber;
            this.mapElements = readLines(levelNumber);
            this.model = model;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createMapLevel() {
        List<String> mapInfo = mapElements;

        List<Wall> walls = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();
        List<WhiteIce> frozenIce = new ArrayList<>();

        for(int yi = 0; yi < mapInfo.size(); yi++) {
            for(int xi = 0; xi < mapInfo.get(yi).length() ; xi++) {
                char c = mapInfo.get(yi).charAt(xi);
                if(c == 'W') walls.add(new Wall( new Position(xi,yi)));
                if(c == 'C') coins.add(new Coin(new Position(xi,yi)));
                if(c == 'B') frozenIce.add(new WhiteIce(new Position(xi,yi)));
                if(c == 'K') model.setKey(new Key(new Position(xi,yi)));
                if(c == 'L') model.setLock(new Lock(new Position(xi,yi)));
                if(c == 'S') model.setHero(new Hero(new Position(xi,yi)));
                if(c == 'D') model.setDestination(new Destination(new Position(xi,yi)));
            }
        }

        model.setWalls(walls);
        model.setCoins(coins);
        model.setFrozenIce(frozenIce);
    }

    private static List<String> readLines(int levelNumber) throws IOException {
        URL resource = LevelInitializer.class.getResource("/rooms/level" + levelNumber + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);

        return lines;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public List<String> getMapElements() {
        return this.mapElements;
    }
}
