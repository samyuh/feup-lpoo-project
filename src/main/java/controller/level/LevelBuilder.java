package controller.level;

import model.drawable.levelheader.LevelCurrent;
import model.level.header.LevelHeaderModel;
import model.drawable.element.*;
import model.level.LevelModel;
import model.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LevelBuilder {
    private List<String> mapElements;
    private LevelModel model;
    private int levelNumber;
    private int globalScore;

    public LevelBuilder(LevelModel model, int globalScore) {
        this.model = model;
        this.globalScore = globalScore;
    }

    private List<String> readLines(String fileName) throws IOException {
        URL resource = LevelBuilder.class.getResource(fileName);
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
        List<InvisibleWall> invisibleWalls = new ArrayList<>();
        List<Teleport> teleports = new ArrayList<>();

        for(int yi = 0; yi < this.mapElements.size(); yi++) {
            for(int xi = 0; xi < this.mapElements.get(yi).length() ; xi++) {
                char c = this.mapElements.get(yi).charAt(xi);
                if(c == 'W') walls.add(new Wall( new Position(xi + 2,yi+2)));
                if(c == '.') ice.add(new Ice(new Position(xi + 2,yi+2)));
                if(c == 'C') coins.add(new Coin(new Position(xi + 2,yi+2)));
                if(c == 'B') toughIce.add(new ToughIce(new Position(xi + 2,yi+2)));
                if(c == 'I') invisibleWalls.add(new InvisibleWall( new Position(xi+2,yi+2)));
                if(c == 'T') teleports.add(new Teleport( new Position(xi + 2,yi+2)));
                if(c == 'K') model.setKey(new Key(new Position(xi + 2,yi+2)));
                if(c == 'L') model.setLock(new Lock(new Position(xi + 2,yi+2)));
                if(c == 'S') model.setPuffle(new Puffle(new Position(xi + 2,yi+2)));
                if(c == 'D') model.setDestination(new Destination(new Position(xi + 2,yi+2)));
                if(c == 'Y') model.setBox(new Box( new Position(xi + 2,yi+2)));
                if(c == 'F') model.setBoxFinalSquare(new BoxFinalSquare( new Position(xi + 2,yi+2)));
                if(c == 'Q') model.setSecretDestination(new SecretDestination( new Position(xi + 2,yi+2)));
            }
        }
        model.setWalls(walls);
        model.setIce(ice);
        model.setCoins(coins);
        model.setToughIce(toughIce);
        model.setInvisibleWalls(invisibleWalls);
        model.setTeleports(teleports);
    }

    public void initLevel(int levelNumber, boolean restart) {
        try {
            if(!restart) this.globalScore = this.model.getLevelHeaderModel().getGlobalScore().getPoints();
            this.levelNumber = levelNumber;
            this.mapElements = readLines("/levelDesign/level" + this.levelNumber + ".txt");
            this.model.setLevelHeaderModel(new LevelHeaderModel(new LevelCurrent(this.levelNumber),globalScore));
            loadElements();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initSecretLevel(int levelNumber) {
        try {
            this.levelNumber = levelNumber;
            this.mapElements = readLines("/levelDesign/level" + this.levelNumber + "secret.txt");
            loadElements();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
