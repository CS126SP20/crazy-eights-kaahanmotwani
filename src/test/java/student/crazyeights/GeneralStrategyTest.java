package student.crazyeights;

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

    //making sure there are 5 cards initially
    @Test
    public void testNumberOfInitialCards() throws Exception {

    }

    //testing that a player can declare a suit when playing an '8'
    @Test
    public void testDeclareSuit() throws Exception {

    }

    //tests that a player receives a card when they choose to draw card from deck
    @Test
    public void testReceivedCard() throws Exception {

    }

    //tests that a player can draw a card from the deck if they want
    @Test
    public void testCanDrawCard() throws Exception {

    }

}
