import java.util.*;

public class Hand implements Comparable {
   private ArrayList<Card> hand;
   public int handvalue;

   public Hand(){
      hand = new ArrayList<Card>();
   }

   public void add(Card c){
      hand.add(c);
   }

   public void sortHand(){
      Collections.sort(hand);
   }

   public String toString(){
      return hand.toString();
   }


   public String handValue() {
     //Case for Royal Flush

     handvalue = 10;
     //Case for Straight Flush

     handvalue = 9;
     //Case for 4 of a kind

     handvalue = 8;
     //Case for Full House

     handvalue = 7;
     //Case for Flush

     handvalue = 6;
     //Case for Straight

     handvalue = 5;
     //Case for Three of a kind

     handvalue = 4;
     //Case for Two Pair

     handvalue = 3;
     //Case for One Pair

     handvalue = 1;
     //Case for High Card
     return "TODO: String of Best Hand; may need helper methods";
   }

   public int compareTo(Object x){
      Hand other = (Hand)x;
      //TODO: Compare hands by ordering above; return -1, 1, or 0
      if(this.handvalue < other.handvalue)
        return -1;
      else if(this.handvalue > other.handvalue)
        return 1;
      else
        return 0;
   }
}
