package Model.Elements;

import Model.Game.Position;

public class Wall extends ElementModel {
    public Wall(Position position) {
        super("\u2588", "#8ABDE8", position);
    }
}

