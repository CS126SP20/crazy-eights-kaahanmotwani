package student.crazyeights;

import java.util.*;

public class PlayerStrategyOne extends GeneralStrategy {
    /**
     *
     * @return The card with the highest point value, which is this player's strategy
     */
    public Card playCard() {
        int highestPointValue = 0;
        Card playThisCard = playerCards.get(0);
        for (Card card: playerCards) {
            if (card.getPointValue() > highestPointValue) {
                highestPointValue = card.getPointValue();
                playThisCard = card;
            }
        }
        return playThisCard;
    }

    /**
     *
     * @return
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
}
