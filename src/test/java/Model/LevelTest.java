package Model;

import Model.Elements.*;
import Model.Level.LevelModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class LevelTest {
    LevelModel testM;
    private List<Coin> coins;
    private List<WhiteIce> frozenIce;
    private Position pCoin1;
    private Position pFrozenIce1;

    @Before
    public void startLevel() {
        this.coins = new ArrayList<>();
        this.frozenIce = new ArrayList<>();

        this.pCoin1 = Mockito.mock(Position.class);
        Mockito.when(pCoin1.getX()).thenReturn(0);
        Mockito.when(pCoin1.getY()).thenReturn(0);

        Coin w1 = Mockito.mock(Coin.class);
        Mockito.when(w1.getPosition()).thenReturn(pCoin1);

        this.coins.add(w1);

        this.pFrozenIce1 = Mockito.mock(Position.class);
        Mockito.when(pFrozenIce1.getX()).thenReturn(1);
        Mockito.when(pFrozenIce1.getY()).thenReturn(1);

        WhiteIce i1 = Mockito.mock(WhiteIce.class);
        Mockito.when(i1.getPosition()).thenReturn(pFrozenIce1);

        frozenIce.add(i1);

        this.testM = new LevelModel();
        testM.setCoins(coins);
        testM.setFrozenIce(frozenIce);

        // Set other things
    }

    @Test
    public void levelTest() {
        testM.removeCoin(this.pCoin1);
        Assert.assertEquals(testM.getCoins().isEmpty(), true);

        testM.removeWhite(this.pFrozenIce1);
        Assert.assertEquals(testM.getFrozenIce().isEmpty(), true);

        // testM.clearlevel() -- To Do
    }
}
