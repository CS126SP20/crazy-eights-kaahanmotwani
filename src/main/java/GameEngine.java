import student.crazyeights.Card;
import student.crazyeights.PlayerStrategy;
import student.crazyeights.PlayerTurn;

import java.util.List;

public class GameEngine implements PlayerStrategy {

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
