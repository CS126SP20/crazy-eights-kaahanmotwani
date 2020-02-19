package student.crazyeights;

import java.util.List;

public abstract class GeneralStrategy implements PlayerStrategy {
    private int playerId;
    private List<Integer> opponentIds;
    protected List<Card> playerCards;
    protected Card currentTopCard;
    public void init(int playerId, List<Integer> opponentIds) {
        this.playerId = playerId;
        this.opponentIds = opponentIds;
    }

    public void receiveInitialCards(List<Card> cards) {
        playerCards = cards;
    }

    public void receiveCard(Card drawnCard) {
        playerCards.add(drawnCard);
    }

    public void processOpponentActions(List<PlayerTurn> opponentActions) {

    }

    public void reset() {
        playerCards.clear();
    }
}
