package student.crazyeights;

import java.util.ArrayList;
import java.util.List;

public class PlayerStrategyTwo extends GeneralStrategy {
    public Card playCard() {
        return playerCards.get(0);
    }

    public Card.Suit declareSuit() {
        return playerCards.get(0).getSuit();
    }
}
