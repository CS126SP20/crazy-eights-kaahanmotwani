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

    @Test
    public void testDealInitialCards() throws Exception {
//        List<Card> testListOfCards = new ArrayList<>(5);
//        testListOfCards.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
//        testListOfCards.add(new Card(Card.Suit.HEARTS, Card.Rank.TWO));
//        testListOfCards.add(new Card(Card.Suit.HEARTS, Card.Rank.THREE));
//        testListOfCards.add(new Card(Card.Suit.HEARTS, Card.Rank.FOUR));
//        testListOfCards.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));
//        Map<PlayerStrategy, List<Card>> initialCardTestMap = new HashMap<>();
//        PlayerStrategy player = new PlayerStrategyOne();
//        initialCardTestMap.put(player, testListOfCards);
//        assertEquals(initialCardTestMap, gameEngine.dealInitialCards());
    }

    @Test
    public void testSetTopCard() throws Exception {

    }

    @Test
    public void testGameOver() throws Exception {

    }

    @Test
    public void testSumPlayerHandPoints() throws Exception {

    }

    @Test
    public void testTournamentWinner() throws Exception {

    }
}
