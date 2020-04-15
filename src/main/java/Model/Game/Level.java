package Model.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<String> mapInfo;
    private int number;

    public Level(int levelNumber) {
        try {
            this.number = levelNumber;
            this.mapInfo = readLines(levelNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLevelNumber() {
        return number;
    }

    public List<String> getMapInfo() {
        return this.mapInfo;
    }

    private static List<String> readLines(int levelNumber) throws IOException {
        URL resource = Level.class.getResource("/rooms/level" + levelNumber + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);

        return lines;
    }
}
