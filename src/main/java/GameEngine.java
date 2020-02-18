import student.crazyeights.*;

import java.util.*;

public class GameEngine {
    //draw pile
    private List<Card> drawPile = new ArrayList<>();
    private List<Card> discardPile = new ArrayList<>();
    private Map<PlayerStrategy, List<Card>> mapOfPlayersToCards = new HashMap<>();
    private Map<PlayerStrategy, Integer> mapOfPlayersToPoints = new HashMap<>();
    private PlayerStrategyOne playerA = new PlayerStrategyOne();
    private PlayerStrategyOne playerB = new PlayerStrategyOne();
    private PlayerStrategyTwo playerC = new PlayerStrategyTwo();
    private PlayerStrategyTwo playerD = new PlayerStrategyTwo();
    private List<PlayerStrategy> listOfPlayers = new ArrayList<>(Arrays.asList(playerA, playerB, playerC, playerD));
    private static final int NUMBER_INITIAL_CARDS = 5;

    /**
     * Starts a new tournament by assigning playerIds and giving each player 0 points
     */
    public void startTournament() {
        playerA.init(1, new ArrayList<Integer>(Arrays.asList(2, 3, 4)));
        playerB.init(2, new ArrayList<Integer>(Arrays.asList(1, 3, 4)));
        playerC.init(3, new ArrayList<Integer>(Arrays.asList(1, 2, 4)));
        playerD.init(4, new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        for (PlayerStrategy player: listOfPlayers) {
            mapOfPlayersToPoints.put(player, 0);
        }
        startGame();
    }
    /**
     * Starts a new game initially and assigns playerIds
     */
    public void startGame() {
        shuffleCards();
        dealInitialCards();
        playTournament();
        startRounds();
    }
    /**
     * Shuffles an unshuffled deck of cards
     * @return A shuffled deck of cards
     */
    public List<Card> shuffleCards() {
        drawPile = Card.getDeck();
        Collections.shuffle(drawPile);
        return drawPile;
    }

    /**
     * Deals initial cards to players. Also stores it in a map in this class.
     */
    public void dealInitialCards() {
        for (PlayerStrategy player: listOfPlayers) {
            List<Card> initialCards = new ArrayList<>();
            for (int i = 0; i < NUMBER_INITIAL_CARDS; i++) {
                initialCards.add(drawPile.remove(i));
            }
            player.receiveInitialCards(initialCards);
            mapOfPlayersToCards.put(player, initialCards);
        }
        discardPile = drawPile;
    }

    /**
     * Adds a card from the draw pile into the discard pile to start the game
     * If it's an 8, then it shuffles the 8 into the draw pile and puts another card at top of discard pile
     */
    public void playTournament() {
        if (!(drawPile.get(0).getRank() == Card.Rank.EIGHT)) {
            discardPile.add(drawPile.remove(0));
        } else {
            Random random = new Random();
            drawPile.add(random.nextInt(), drawPile.get(0));
            discardPile.add(drawPile.remove(0));
        }
    }

    /**
     *
     */
    public void startRounds() {
        //if players discarded all of their cards, they get points from the other player cards' totals
        //Case of a tie (if the draw pile runs out and no one empties their hand), adds points of other players
        for (PlayerStrategy player: listOfPlayers) {
            if (mapOfPlayersToCards.get(player).size() == 0) {
                addPointsToPlayer(player);
            } else if (drawPile.isEmpty()) {
                addPointsToPlayer(player);
            }
        }

    }

    /**
     *
     * @param playerWhoWonPoints
     */
    public void addPointsToPlayer(PlayerStrategy playerWhoWonPoints) {
        //total points is the points the player has in the map
        int totalPoints = mapOfPlayersToPoints.get(playerWhoWonPoints);
        for (PlayerStrategy player: listOfPlayers) {
            if (!(player.equals(playerWhoWonPoints))) {
                totalPoints += sumPlayerHandPoints(mapOfPlayersToCards.get(player));
            }
        }
        mapOfPlayersToPoints.put(playerWhoWonPoints, totalPoints);
    }

    /**
     * 
     * @param cards
     * @return
     */
    public int sumPlayerHandPoints(List<Card> cards) {
        int points = 0;
        for (int i = 0; i < cards.size(); i++) {
            points += cards.get(i).getPointValue();
        }
        return points;
    }
}
