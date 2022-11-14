import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();

    }
     public void addCard(Card card){
        deck.add(card);
     }

     public String toString(){
        String output = "";

        for(Card card: deck){
            output += card;
            output +="\n";
        }
        return output;
     }


     //creates the deck
     public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
            //iterates through suits
            for(Suit suit : Suit.values()){
                //iterates through ranks
                for(Rank rank : Rank.values()){
                    deck.add(new Card(suit, rank));
                }
            }
        }
     }



     public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<Card>();
        while(deck.size()>0){
            int cardToPull = (int)(Math.random()*(deck.size()-1));
            shuffled.add(deck.get(cardToPull));
            deck.remove(cardToPull);
        }
        deck = shuffled;
     }




     public Card takeCard(){
        Card cartToTake = new Card(deck.get(0));

        deck.remove(0);

        return cartToTake;
     }

     public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
     }

     public int cardsleft(){
        return deck.size();
     }

     public ArrayList<Card> getCards() {return deck;}

     public void emptyDeck(){
        deck.clear();
     }

     public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
     }


     public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
     }


}


