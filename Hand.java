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
        map.put(hand.get(i).value,map.get(hand.get(i).value)+1);

    else
      map.put(hand.get(i).value,1);
    }


     System.out.println(map);
     //Case for Royal Flush
     if(checkStraight() && checkFlush()){
       if(hand.get(0).value == 10)
        {
          handvalue = 9;

         return "Royal Flush";
         }
       else
      {
        handvalue = 8;
        return "Straight Flush";

      }
     }

     //Case for 4 of a kind
     else if(map.containsValue(4)){
       handvalue = 7;
       return "4 of a kind";
     }
     else if(map.containsValue(3) && map.containsValue(2)){


     //Case for Full House

     handvalue = 6;
     return "Full House";
   }
     //Case for Flush
     else if(checkFlush()){
     handvalue = 5;
     return "Flush";
   }
     //Case for Straight
     else if(checkStraight()){

     handvalue = 4;
     return "Straight";
   }
     //Case for Three of a kind
     else if(map.containsValue(3)){
     handvalue = 3;
     return "3 of a Kind";
   }
     //Case for Two Pair
     else if(map.containsValue(2)){
       int k = 0;
       Collection collection = map.values();
       Object[] intarray = collection.toArray();
     for(int i = 0; i < map.size();i++){
       if(intarray[i] == 2)
         k++;
     }
     if(k == 2){
     handvalue = 2;

     return "Two Pair";
   }
   else{
     handvalue = 1;
     return "pair";
   }
   }
     //Case for High Card
     else{

    handvalue = 0;
     return "high card";
   }
   }

   public boolean checkFlush(){
     String testSuit = hand.get(0).suit;
     for(Card c : hand){
       if(!testSuit.equals(c.suit))
        return false;
     }
     return true;
   }

   public boolean checkStraight(){
     for(int i = 1; i < hand.size(); i++){
       if(hand.get(i).value != hand.get(i-1).value+1)
       return false;
     }
     return true;
   }



   public int compareTo(Object x){
      Hand other = (Hand)x;
      int k = 0;
      int j = 0;
      //TODO: Compare hands by ordering above; return -1, 1, or 0
      if(this.handvalue < other.handvalue)
        return -1;
      else if(this.handvalue > other.handvalue)
        return 1;
      else if(this.handvalue == other.handvalue){

        for(int i = 0; i < hand.size()-1; i++){
          if(map.get(hand.get(i).value) == 2){
            k = hand.get(i).value;
          }
        }
        for(int i = 0; i < other.hand.size()-1; i++){
          if(other.map.get(other.hand.get(i).value) == 2){
            j = other.hand.get(i).value;
          }
        }
        System.out.println(k);
        System.out.println(j);
        if(k > j)
          return 1;
        else if(j > k)
          return -1;
        else if(j == k){
          if(hand.get(hand.size()-1).value > other.hand.get(other.hand.size()-1).value)
            return 1;
            if(hand.get(hand.size()-1).value < other.hand.get(other.hand.size()-1).value)
              return -1;
              if(hand.get(hand.size()-1).value == other.hand.get(other.hand.size()-1).value)
                return 0;
        }
        else
          return 0;
        }

        return 0;
   }
}
