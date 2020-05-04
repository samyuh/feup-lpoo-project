package Controller.Interact;

import Model.Elements.Coin;
import Model.Elements.Water;
import Model.Elements.WhiteIce;
import Model.Level.LevelModel;
import Model.Position;


public class Editor {
    LevelModel levelModel;
    Position position;

    public Editor(LevelModel levelModel, Position position) {
        this.levelModel = levelModel;
        this.position = position;
    }

    public void move(){
        levelModel.getHero().setPosition(position);
    }

    public void addPoints(int number){
        levelModel.addPoints(number);
    }

    public void removeKeyLock(){
        levelModel.setKey(null);
        levelModel.setLock(null);
    }
    public void addWater(){
        if(!levelModel.removeWhite(levelModel.getHero().getPosition()))
            levelModel.getFilled().add(new Water(levelModel.getHero().getPosition()));
    }

    public void removeCoin(Coin coin){
        levelModel.getCoins().remove(coin);
;   }

    public void removeWhiteIce(WhiteIce whiteIce){
        levelModel.getFrozenIce().remove(whiteIce);
    }

}
