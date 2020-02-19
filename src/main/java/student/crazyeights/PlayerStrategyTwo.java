package student.crazyeights;

import java.util.ArrayList;
import java.util.List;

public class PlayerStrategyTwo extends GeneralStrategy {
    /**
     * Dumb player, plays the first card in hand that is valid
     * @return the first card in hand
     */
    public Card playCard() {
        Card playThisCard = null;
        for (Card card : playerCards) {
            if (card.getRank().equals(currentTopCard.getRank()) || card.getSuit().equals(currentTopCard.getSuit())) {
                playThisCard = card;
                playerCards.remove(card);
                break;
            }
        }
        return playThisCard;
    }

    /**
     * Dumb player, declares suit of first card in hand
     * @return the suit of the first card
     */
    public Card.Suit declareSuit() {
        return playerCards.get(0).getSuit();
    }

    /**
     * Checks if the topPileCard matches the suit or rank of any of the cards in the player's hand
     * NOTE: The reason this does not check for null value of changedSuit is because a non-null value of suit is
     * always passed in, since I have an instance variable in GameEngine
     * @param topPileCard The card currently at the top of the pile
     * @param changedSuit The suit that the pile was changed to as the result of an "8" being
     *                    played. Will be null if no "8" was played.
     * @return
     */
    public boolean shouldDrawCard(Card topPileCard, Card.Suit changedSuit) {
        currentTopCard = topPileCard;
        //if your hand has a card with the same suit as the top card, then return false
        for (Card playerCard : playerCards) {
            if (topPileCard.getRank().equals(playerCard.getRank())) {
                return false;
            } else if (topPileCard.getRank().equals(playerCard.getSuit())) {
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
}
