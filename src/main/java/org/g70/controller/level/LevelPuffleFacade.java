package org.g70.controller.level;

import org.g70.controller.level.movement.PuffleMovement;
import org.g70.model.level.LevelModel;

public class LevelPuffleFacade {
    LevelModel levelModel;
    private PuffleMovement puffleMovement;

    public LevelPuffleFacade(LevelModel levelModel) {
        this.levelModel = levelModel;
        this.puffleMovement = new PuffleMovement(levelModel.getPuffle());
    }

    public void setPuffleMovement() {
        this.puffleMovement = new PuffleMovement(levelModel.getPuffle());
    }

    public PuffleMovement getPuffleMovement() {
        return this.puffleMovement;
    }
}
