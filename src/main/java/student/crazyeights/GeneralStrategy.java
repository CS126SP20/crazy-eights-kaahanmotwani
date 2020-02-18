package student.crazyeights;

import java.util.List;

public abstract class GeneralStrategy implements PlayerStrategy {
    private int playerId;
    private List<Integer> opponentIds;
    private List<Card> playerCards;
    public void init(int playerId, List<Integer> opponentIds) {
        this.playerId = playerId;
        this.opponentIds = opponentIds;
    }

    public void receiveInitialCards(List<Card> cards) {
        playerCards = cards;
    }

    public boolean shouldDrawCard(Card topPileCard, Card.Suit changedSuit) {
        //if your hand has a card with the same suit as the top card, then return false
        for (int i = 0; i < playerCards.size(); i++) {
            if (topPileCard.getRank().equals(playerCards.get(i).getRank())) {
                return false;
            } else if (topPileCard.getRank().equals(playerCards.get(i).getSuit())) {
                return false;
            }
        }
        if (changedSuit != null) {
            for (int i = 0; i < playerCards.size(); i++) {
                if (playerCards.get(i).getRank().equals(topPileCard.getRank())
                        && playerCards.get(i).getSuit().equals(topPileCard.getSuit())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void receiveCard(Card drawnCard) {
        playerCards.add(drawnCard);
    }

    public void processOpponentActions(List<PlayerTurn> opponentActions) {

    }

    public void reset() {

    }
}
