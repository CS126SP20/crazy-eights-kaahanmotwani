package student.crazyeights;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GameEngineTest {

    private GameEngine gameEngine = new GameEngine();
    private List<Card> testListOfCards = new ArrayList<>(5);

    @Before
    public void createMockList() throws Exception {
        testListOfCards.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        testListOfCards.add(new Card(Card.Suit.HEARTS, Card.Rank.TWO));
        testListOfCards.add(new Card(Card.Suit.HEARTS, Card.Rank.THREE));
        testListOfCards.add(new Card(Card.Suit.HEARTS, Card.Rank.FOUR));
        testListOfCards.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));
    }

    @Test
    public void testSumPlayerHandPoints() throws Exception {
        int points = 0;
        for (Card card : testListOfCards) {
            points += card.getPointValue();
        }
        assertEquals(points, gameEngine.sumPlayerHandPoints(testListOfCards));
    }

}
