package student.crazyeights;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class PlayerStrategyOneTest {
    private List<Card> mockHand = new ArrayList<>();
    private Card mockTopPileCard;
    private PlayerStrategyOne player = new PlayerStrategyOne();

    @Before
    public void populateMockDeck() {
        mockTopPileCard = new Card(Card.Suit.HEARTS, Card.Rank.FIVE);
        mockHand.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));
        mockHand.add(new Card(Card.Suit.HEARTS, Card.Rank.THREE));
        mockHand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SEVEN));
    }

    @Test
    public void testShouldDrawCard() {
        assertEquals(false, player.shouldDrawCard(mockTopPileCard, Card.Suit.HEARTS));
    }

    @Test
    public void test
}
