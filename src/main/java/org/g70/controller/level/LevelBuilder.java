package org.g70.controller.level;

import org.g70.model.drawable.element.immovable.*;
import org.g70.model.drawable.element.movable.*;
import org.g70.model.level.LevelModel;
import org.g70.model.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LevelBuilder {
    private List<String> mapElements;
    private LevelModel levelModel;

    public LevelBuilder(LevelModel levelModel) {
        this.levelModel = levelModel;
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
        List<Ice> ice = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();
        List<DoubleIce> doubleIce = new ArrayList<>();
        List<InvisibleWall> invisibleWalls = new ArrayList<>();
        List<Teleport> teleports = new ArrayList<>();

        for(int yi = 0; yi < this.mapElements.size(); yi++) {
            for(int xi = 0; xi < this.mapElements.get(yi).length() ; xi++) {
                char c = this.mapElements.get(yi).charAt(xi);
                if(c == 'W') walls.add(new Wall( new Position(xi + 2,yi+2)));
                if(c == '.') ice.add(new Ice(new Position(xi + 2,yi+2)));
                if(c == 'C') coins.add(new Coin(new Position(xi + 2,yi+2)));
                if(c == 'B') doubleIce.add(new DoubleIce(new Position(xi + 2,yi+2)));
                if(c == 'I') invisibleWalls.add(new InvisibleWall( new Position(xi+2,yi+2)));
                if(c == 'T') teleports.add(new Teleport( new Position(xi + 2,yi+2)));
                if(c == 'K') levelModel.setKey(new Key(new Position(xi + 2,yi+2)));
                if(c == 'L') levelModel.setLock(new Lock(new Position(xi + 2,yi+2)));
                if(c == 'S') levelModel.setPuffle(new Puffle(new Position(xi + 2,yi+2)));
                if(c == 'D') levelModel.setFinish(new Finish(new Position(xi + 2,yi+2)));
                if(c == 'F') levelModel.setEmptyBlock(new EmptyBlock( new Position(xi + 2,yi+2)));
                if(c == 'Q') levelModel.setSecret(new Secret( new Position(xi + 2,yi+2)));
                if(c == 'Y') {
                    levelModel.setBox(new Box( new Position(xi + 2,yi+2)));
                    ice.add(new Ice(new Position(xi + 2,yi+2)));
                }
            }
        }
        levelModel.setWalls(walls);
        levelModel.setIce(ice);
        levelModel.setCoins(coins);
        levelModel.setDoubleIce(doubleIce);
        levelModel.setInvisibleWalls(invisibleWalls);
        levelModel.setTeleports(teleports);
    }

    public void initLevel(int levelNumber, boolean secretLevel) {
        try {
            if(secretLevel)
                this.mapElements = readLines("/levelDesign/level" + levelNumber + "secret.txt");
            else
                this.mapElements = readLines("/levelDesign/level" + levelNumber + ".txt");

            loadElements();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
