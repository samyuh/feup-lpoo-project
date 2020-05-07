package Model.Menu;

public class MainMenuModel {
    private int optionNum;
    private String colour;

    public MainMenuModel() {
        optionNum = 0;
    }

    public void previousAction() {
        if(optionNum != 0) optionNum--;
        else optionNum = 2;
    }

    public void nextAction() {
        optionNum = (optionNum + 1) % 3;
    }

    public int getAction() {
        return optionNum;
    }
}
