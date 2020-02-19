package student.crazyeights;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class PlayerStrategyOneTest {
    private List<Card> mockHand = new ArrayList<>();
    private GeneralStrategy player = new PlayerStrategyOne();
    private List<Card> playerHand = player.getPlayerCards();

    @Before
    public void populateMockDeck() {
        mockHand.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));
        mockHand.add(new Card(Card.Suit.HEARTS, Card.Rank.THREE));
        mockHand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SEVEN));
        mockHand.add(new Card(Card.Suit.HEARTS, Card.Rank.NINE));
        mockHand.add(new Card(Card.Suit.SPADES, Card.Rank.FIVE));
        player.receiveInitialCards(mockHand);
    }

    @Test
    public void testPlayCard() throws Exception {
        player.shouldDrawCard(new Card(Card.Suit.HEARTS, Card.Rank.SEVEN), Card.Suit.HEARTS);
        assertEquals(new Card(Card.Suit.HEARTS, Card.Rank.NINE), player.playCard());
    }

    @Test
    public void testDeclareSuit() throws Exception {
        assertEquals(Card.Suit.HEARTS, player.declareSuit());
    }

    @Test
    public void testShouldDrawCardFalse() throws Exception {
        assertEquals(false, player.shouldDrawCard(new Card(Card.Suit.HEARTS, Card.Rank.SEVEN),
                Card.Suit.HEARTS));
    }

    @Test
    public void testShouldDrawCardTrue() throws Exception {
        assertEquals(true, player.shouldDrawCard(new Card(Card.Suit.CLUBS, Card.Rank.TWO),
                Card.Suit.HEARTS));
    }

}
