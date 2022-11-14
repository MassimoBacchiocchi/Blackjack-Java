public class Game {

    private Deck deck, discarded;

    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes;


    public Game(){

        deck = new Deck(true);
        discarded = new Deck();

        dealer = new Dealer();
        player = new Player();

        deck.shuffle();
        startRound();

        wins = 0; losses = 0; pushes = 0;
    }

    private void startRound(){

        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printFirstHand();
        player.printHand();

        if(dealer.hasBlackjack()) {
            dealer.printHand();

            if (player.hasBlackjack()) {
                System.out.println("You both have 21 - Push.");
                pushes++;
                startRound();
            } else {
                System.out.println("Dealer has Blackjack. You loose.");
                dealer.printHand();
                losses++;
                startRound();
            }
        }

        if(player.hasBlackjack()){
            System.out.println("You have Blackjack you win!");
            wins++;
            startRound();
        }

        player.makeDecision(deck, discarded);
    }

    public Player getPlayer() {
        return player;
    }

    if(player.getHand().calculatedValue() > 21){
        System.out.println("You have gone over 21.");
        losses ++;
        startRound();
    }

    dealer.printHand();
    while(dealer.getHand().calculatedValue() < 17){
        dealer.hit(deck, discarded);
    }

    if(dealer.getHand().calculatedValue()>21){
        System.out.println("Dealer busts");
        wins ++;
    }
    else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
        System.out.println("You Lose.");
        losses ++;
    }
    else if(player.getHand().calculatedValue() > player.getHand().calculatedValue()){
        System.out.println("You win!");
        wins ++;
    }
    else{
        System.out.println("Push.");
        pushes ++;
    }

    startRound();








}
