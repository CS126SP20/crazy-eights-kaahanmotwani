package student.crazyeights;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerStrategyTwoTest {
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
    public void testShouldDrawCard() throws Exception {
        assertEquals(false, player.shouldDrawCard(mockTopPileCard, Card.Suit.HEARTS));
    }
}
