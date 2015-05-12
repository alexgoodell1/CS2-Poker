import java.util.*;

public class Hand implements Comparable {
   private ArrayList<Card> hand;
   public int handvalue;
   public Map<Integer, Integer> map;

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
     map = new HashMap<Integer, Integer>();
     for(int i = 0; i < hand.size(); i++){
       if(map.containsKey(hand.get(i).value))
          map.put(hand.get(i).value, map.get(hand.get(i)) + 1);
          else
           map.put(hand.get(i).value, 1);
    }


     System.out.println(map);
     //Case for Royal Flush
     if(checkStraight() && checkFlush()){
       if(hand.get(0).value == 10)
        {
          handvalue = 10;

         return "Royal Flush";
         }
       else
      {
        handvalue = 9;
        return "Straight Flush";

      }
     }

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

   public boolean checkFlush(){
     String testSuit = hand.get(0).suit;
     for(Card c : hand){
       if(!testSuit.equals(testSuit))
        return false;
     }
     return true;
   }

   public boolean checkStraight(){
     for(int i = 1; i <= hand.size(); i++){
       if(hand.get(i).value != hand.get(i-1).value+1)
       return false;
     }
     return true;
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
