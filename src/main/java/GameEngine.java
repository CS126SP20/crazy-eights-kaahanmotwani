import student.crazyeights.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameEngine {
    private List<Card> deck = new ArrayList<Card>();
    private PlayerStrategyOne playerA = new PlayerStrategyOne();
    private PlayerStrategyOne playerB = new PlayerStrategyOne();
    private PlayerStrategyTwo playerC = new PlayerStrategyTwo();
    private PlayerStrategyTwo playerD = new PlayerStrategyTwo();
    /**
     * Shuffles an unshuffled deck of cards
     * @return A shuffled deck of cards
     */
    public List<Card> shuffleCards() {
        deck = Card.getDeck();
        Collections.shuffle(deck);
        return deck;
    }

    /**
     * Deals initial cards to players.
     */
    public void dealInitialCards() {
//        deck.get(0);
//        playerA.receiveInitialCards();
    }
}
