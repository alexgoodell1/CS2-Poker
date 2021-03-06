import java.util.*;

public class Deck {
   private ArrayList<Card> deck;
   private Random rng = new Random();

   public Deck(){
      deck = new ArrayList<Card>();
      
      for(int i = 2; i <= 14; i++){
        deck.add(new Card(i, "h"));
      }
      for(int i = 2; i <= 14; i++){
        deck.add(new Card(i, "s"));
      }
      for(int i = 2; i <= 14; i++){
        deck.add(new Card(i, "d"));
      }
      for(int i = 2; i <= 14; i++){
        deck.add(new Card(i, "c"));
      }
   }

   public Card remove(){
      int rand = rng.nextInt(deck.size()-1);
      return deck.remove(rand);
   }

   public String toString(){
      return deck.toString();
   }
}
