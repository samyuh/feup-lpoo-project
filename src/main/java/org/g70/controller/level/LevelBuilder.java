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
        for(int yi = 0; yi < this.mapElements.size(); yi++) {
            for(int xi = 0; xi < this.mapElements.get(yi).length() ; xi++) {
                char c = this.mapElements.get(yi).charAt(xi);
                Position elementPos = new Position(xi + 2,yi+2);
                if(c == 'W') levelModel.addWalls(new Wall(elementPos));
                if(c == '.') levelModel.addIce(new Ice(elementPos));
                if(c == 'C') levelModel.addCoins(new Coin(elementPos));
                if(c == 'B') levelModel.addDoubleIce(new DoubleIce(elementPos));
                if(c == 'I') levelModel.addInvisibleWalls(new InvisibleWall(elementPos));
                if(c == 'T') levelModel.addTeleports(new Teleport(elementPos));
                if(c == 'K') levelModel.setKey(new Key(elementPos));
                if(c == 'L') levelModel.setLock(new Lock(elementPos));
                if(c == 'S') levelModel.setPuffle(new Puffle(elementPos));
                if(c == 'D') levelModel.setFinish(new Finish(elementPos));
                if(c == 'F') levelModel.setEmptyBlock(new EmptyBlock(elementPos));
                if(c == 'Q') levelModel.setSecret(new Secret(elementPos));
                if(c == 'Y') {
                    levelModel.setBox(new Box( new Position(xi + 2,yi+2)));
                    levelModel.addIce(new Ice(new Position(xi + 2,yi+2)));
                }
            }
        }
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
