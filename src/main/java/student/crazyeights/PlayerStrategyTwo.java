package student.crazyeights;

import java.util.ArrayList;
import java.util.List;

public class PlayerStrategyTwo implements PlayerStrategy {
    private List<Card> cardsInHand = new ArrayList<Card>();
    public void init(int playerId, List<Integer> opponentIds) {

    }

    public void receiveInitialCards(List<Card> cards) {

    }

    public boolean shouldDrawCard(Card topPileCard, Card.Suit changedSuit) {
        return false;
    }

    public void receiveCard(Card drawnCard) {

    }

    public Card playCard() {
        return null;
    }

    public Card.Suit declareSuit() {
        return null;
    }

    public void processOpponentActions(List<PlayerTurn> opponentActions) {

    }

    public void reset() {

    }
}
