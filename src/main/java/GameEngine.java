import student.crazyeights.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameEngine {
    private List<Card> deck = new ArrayList<Card>();
    private PlayerStrategyOne playerA = new PlayerStrategyOne();
    private PlayerStrategyOne playerB = new PlayerStrategyOne();
    private PlayerStrategyTwo playerC = new PlayerStrategyTwo();
    private PlayerStrategyTwo playerD = new PlayerStrategyTwo();
    private List<GeneralStrategy> listOfPlayers = new ArrayList<>(Arrays.asList(playerA, playerB, playerC, playerD));
    private static final int NUMBER_INITIAL_CARDS = 5;

    /**
     * Starts the tournament initially and assigns playerIds
     */
    public void startTournament() {
        playerA.init(1, new ArrayList<Integer>(Arrays.asList(2, 3, 4)));
        playerB.init(2, new ArrayList<Integer>(Arrays.asList(1, 3, 4)));
        playerC.init(3, new ArrayList<Integer>(Arrays.asList(1, 2, 4)));
        playerD.init(4, new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        shuffleCards();
        dealInitialCards();
        playTournament();
    }
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
        for (GeneralStrategy player: listOfPlayers) {
            List<Card> initialCards = new ArrayList<>();
            for (int i = 0; i < NUMBER_INITIAL_CARDS; i++) {
                initialCards.add(deck.remove(i));
            }
            player.receiveInitialCards(initialCards);
        }
    }

    /**
     *
     */
    public void playTournament() {

    }
}
