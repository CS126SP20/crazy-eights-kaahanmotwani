package student.crazyeights;

import java.util.*;

public class PlayerStrategyOne extends GeneralStrategy {
    /**
     * Looks for the highest point value in its hand in order to get rid of it
     * @return The card with the highest point value, which is this player's strategy
     */
    public Card playCard() {
        int highestPointValue = 0;
        Card playThisCard = playerCards.get(0);
        for (Card card: playerCards) {
            if (card.getPointValue() > highestPointValue && (currentTopCard.getSuit().equals(card.getSuit())
                    || currentTopCard.getRank().equals(card.getRank()))) {
                highestPointValue = card.getPointValue();
                playThisCard = card;
            }
        }
        return playThisCard;
    }

    /**
     * Since this is a "smarter player", this player looks for the most common suit in its hand by creating and
     * iterating through a map
     * @return The Suit that the player wants to change to
     */
    public Card.Suit declareSuit() {
        Map<Card.Suit, Integer> mapSuitToNumberOfCards = new HashMap<>();
        for (Card card: playerCards) {
            mapSuitToNumberOfCards.put(card.getSuit(),
                    mapSuitToNumberOfCards.getOrDefault(card.getSuit(),0) + 1);
        }
        int maxFrequency = Collections.max(mapSuitToNumberOfCards.values());
        for (Map.Entry<Card.Suit, Integer> entry : mapSuitToNumberOfCards.entrySet()) {
            if (entry.getValue().equals(maxFrequency)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Checks if the topPileCard matches the suit or rank of any of the cards in the player's hand
     * NOTE: The reason this does not check for null value of changedSuit is because a non-null value of suit is
     * always passed in, since I have an instance variable in GameEngine
     * @param topPileCard The card currently at the top of the pile
     * @param changedSuit The suit that the pile is on.
     * @return
     */
    public boolean shouldDrawCard(Card topPileCard, Card.Suit changedSuit) {
        currentTopCard = topPileCard;
        //if your hand has a card with the same suit as the top card, then return false
        for (Card playerCard : playerCards) {
            if (topPileCard.getRank().equals(playerCard.getRank())
                    || topPileCard.getSuit().equals(changedSuit)) {
                return false;
            }
        }
        return true;
    }
}
