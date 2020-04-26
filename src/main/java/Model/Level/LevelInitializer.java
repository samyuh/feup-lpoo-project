package Model.Level;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LevelInitializer {
    private List<String> mapElements;
    private int levelNumber;

    public LevelInitializer(int levelNumber) {
        try {
            this.levelNumber = levelNumber;
            this.mapElements = readLines(levelNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
