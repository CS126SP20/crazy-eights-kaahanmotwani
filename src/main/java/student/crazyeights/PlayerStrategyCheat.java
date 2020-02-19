package student.crazyeights;

public class PlayerStrategyCheat extends GeneralStrategy {
    public Card playCard() {
        return new Card(Card.Suit.HEARTS, Card.Rank.EIGHT);
    }

    public Card.Suit declareSuit() {
        return playerCards.get(0).getSuit();
    }
    
    public boolean shouldDrawCard(Card topPileCard, Card.Suit changedSuit) {
        return false;
    }
}
