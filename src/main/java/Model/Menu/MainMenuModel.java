package Model.Menu;

public class MainMenuModel {
    private int optionNum;

    public MainMenuModel() {
        optionNum = 0;
    }

    public void previousAction() {
        optionNum = (optionNum - 1) % 3;
    }

    public void nextAction() {
        optionNum = (optionNum + 1) % 3;
    }

    public int getAction() {
        return optionNum;
    }
}
