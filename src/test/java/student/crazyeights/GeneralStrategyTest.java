package student.crazyeights;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GeneralStrategyTest {
    private PlayerStrategyOne playerOne;
    private List<Card> deck;

    @Before
    public void setUp() throws Exception {
        playerOne = new PlayerStrategyOne();
        deck = Card.getDeck();
    }

    //tests that a player can draw a card from the deck if they want
    @Test
    public void testShouldDrawCard() throws Exception {
//        Assert.assertEquals();
    }

}
