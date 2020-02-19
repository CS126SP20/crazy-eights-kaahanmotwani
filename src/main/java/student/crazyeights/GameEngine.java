package student.crazyeights;

import student.crazyeights.*;

import java.util.*;

public class GameEngine {
    private List<Card> drawPile = new ArrayList<>();
    private List<Card> discardPile = new ArrayList<>();
    private Map<PlayerStrategy, List<Card>> mapOfPlayersToCards = new HashMap<>();
    private Map<PlayerStrategy, Integer> mapOfPlayersToPoints = new HashMap<>();
    private PlayerStrategyOne playerA = new PlayerStrategyOne();
    private PlayerStrategyOne playerB = new PlayerStrategyOne();
    private PlayerStrategyTwo playerC = new PlayerStrategyTwo();
    private PlayerStrategyTwo playerD = new PlayerStrategyTwo();
    private List<PlayerStrategy> listOfPlayers = new ArrayList<>(Arrays.asList(playerA, playerB, playerC, playerD));
    private Card topCard;
    private Card.Suit currentSuit;
    private static final int NUMBER_INITIAL_CARDS = 5;
    private static final int TOURNAMENT_WINNING_THRESHOLD = 200;

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
        while (checkTournamentWinner() == null) {
            startGame();
        }
    }
    /**
     * Starts a new game initially and assigns playerIds
     */
    public void startGame() {
        shuffleCards();
        dealInitialCards();
        setTopCard();
        //while the game isn't over and no one is cheating, rounds are played
        while (!checkGameOver()) {
            playRound();
        }
//        checkGameOver();
    }
    /**
     * Shuffles a new, unshuffled deck of cards
     * @return A shuffled deck of cards
     */
    public List<Card> shuffleCards() {
        drawPile = Card.getDeck();
        Collections.shuffle(drawPile);
        return drawPile;
    }

    /**
     *
     * @return
     */
    public Map<PlayerStrategy, List<Card>> dealInitialCards() {
        for (PlayerStrategy player: listOfPlayers) {
            List<Card> initialCards = new ArrayList<>();
            for (int i = 0; i < NUMBER_INITIAL_CARDS; i++) {
                initialCards.add(drawPile.remove(0));
            }
            player.receiveInitialCards(initialCards);
            mapOfPlayersToCards.put(player, initialCards);
        }
        System.out.println("Initial cards were dealt!");
        return mapOfPlayersToCards;
    }

    /**
     * Adds a card from the draw pile into the discard pile to start the game
     * If it's an 8, then it shuffles the 8 into the draw pile and puts another card at top of discard pile
     * @return
     */
    public Card setTopCard() {
        if (!(drawPile.get(0).getRank() == Card.Rank.EIGHT)) {
            discardPile.add(drawPile.remove(0));
            //top pile card is the top of the discard pile
            topCard = discardPile.get(0);
            currentSuit = topCard.getSuit();
        } else {
            Random random = new Random();
            //reshuffling the 8
            int randomIndex = random.nextInt(drawPile.size());
            drawPile.add(randomIndex, drawPile.get(0));
            discardPile.add(drawPile.remove(0));
            //top pile card is the top of the discard pile
            topCard = discardPile.get(0);
            currentSuit = topCard.getSuit();
        }
        return topCard;
    }

    /**
     * Playing each round. Loops through the listOfPlayers and then checks if they should draw cards, and if not
     * then they play a card and its added to the top of the discard pile, and updates the top card
     */
    public void playRound() {
        if (drawPile.size() == 0) {
            checkGameOver();
        }
        for (PlayerStrategy player: listOfPlayers) {
            if (player.shouldDrawCard(topCard, currentSuit) && drawPile.size() != 0) {
                player.receiveCard(drawPile.remove(0));
            } else {
                Card playedCard = player.playCard();

                if (playedCard.getRank() == Card.Rank.EIGHT) {
                    currentSuit = player.declareSuit();
                }
                //checking for cheating
                if (checkIfCheating(playedCard, topCard, currentSuit)) {
                    System.out.println("Someone cheated, the tournament is over!");
                    System.exit(0);
                    break;
                }
                //removes the card that the player played from their hand
                mapOfPlayersToCards.get(player).remove(playedCard);
                //adds the card that was played to the top of the discard pile
                discardPile.add(0, playedCard);
                topCard = discardPile.get(0);
            }
        }
        System.out.println("A round was completed!!!!");
    }

    /**
     * If players discarded all of their cards, they get points from the other player cards' totals
     * In case of a tie (if the draw pile runs out and no one empties their hand), adds points of other players
     */
    public boolean checkGameOver() {
        for (PlayerStrategy player: listOfPlayers) {
            //if hand is empty, or if draw pile is empty; in both cases, game over and players win points
            if (mapOfPlayersToCards.get(player).size() == 0 || drawPile.isEmpty()) {
                System.out.println("SOMEONE WON A GAME!!!!");
                addPointsToPlayer(player);
                //resets the game
                resetGame();
                return true;
            }
        }
        return false;
    }

    /**
     * Adds points to players, which in any case is the sum of the other players' hands
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

    /**
     *
     * @return The player strategy that got 200+ points and won the tournament
     */
    public PlayerStrategy checkTournamentWinner() {
        for (PlayerStrategy player: listOfPlayers) {
            if (mapOfPlayersToPoints.get(player) > 200) {
                System.out.println(player.toString() + " wins the TOURNAMENT with " +
                        mapOfPlayersToPoints.get(player) + " points!");
                return player;
            }
        }
        return null;
    }

    /**
     * Resets the game by clearing the players' cards and calling the reset function for each PlayerStrategy object
     */
    public void resetGame() {
        for (PlayerStrategy player: listOfPlayers) {
            mapOfPlayersToCards.get(player).clear();
            player.reset();
        }
    }

    /**
     *
     * @param playedCard
     * @param topCard
     * @param suit
     * @return
     */
    public boolean checkIfCheating(Card playedCard, Card topCard, Card.Suit suit) {
        if (!(playedCard.getSuit().equals(suit)) && !(playedCard.getRank().equals(topCard.getRank()))) {
            return true;
        }
        boolean checkForEight = !playedCard.getSuit().equals(suit) && !playedCard.getRank().equals(Card.Rank.EIGHT);
        return checkForEight;
    }
}
