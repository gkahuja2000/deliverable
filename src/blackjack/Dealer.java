/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
 import java.util.*;
/**
 *
 * @author gkauj
 */
public class Dealer {
      ArrayList<Card> hand;
      private int handValue =0;
      private Card[] aHand;
      private int counter;
          
     Dealer(Deck deck){ //one  arg constructor is created
     hand = new ArrayList<>();
     aHand = new Card[]{};
     int counter =0;
     
     //loop is created to draw two cards
     for( int i =0; i<2 ; i++){
       hand.add(deck.draw());
     }
     //this is used to set the value of ace as 1 or 11
     aHand = hand.toArray(aHand);
     for(int i=0; i<aHand.length; i++){
       handValue = handValue + aHand[i].getValue();
       if(aHand[i].getValue()==11){ 
         counter++;
       }
       while(counter>0 && handValue>21){
         handValue = handValue-10;
         counter--;
       }
     }
}
     //Hit method is called if the person selects hit and one more random card is generated 
     //if it has ace value as per requirement 11 or 1 is assigned
     public void Hit(Deck deck){
     hand.add(deck.draw());
     aHand = hand.toArray(aHand);
     handValue =0;
     for(int i=0;i<aHand.length;i++){
      handValue += aHand[i].getValue();
      if(aHand[i].getValue()==11){
      counter++;
      }
      while(counter>0 && handValue>21){
           handValue-=10;
           counter--;
      }
     }
}
     //wantsToHit method is called becuse user can only hit if the value is less than 17
     public boolean wantsToHit(){
        if(handValue<17){
        return true;
        }
        return false;
     }
     //showFirsstCard is the method because dealer donot show the firstCard 
     //so it can be revealed but can be needed
     public void showFirstCard(){
         Card[] firstCard = new Card[]{};
         firstCard = hand.toArray(firstCard);
         System.out.println("["+firstCard[0]+"]");
     }
     //BlackJack is said when the person have two cards and sum is 21 already 
     public boolean hasBJack(){
     if(hand.size()==2 && handValue == 21){
         System.out.println("Dealer has BlackJack");
         return true;
     }
     return false;
     }
     //showHand will display only one card of the dealer.
     public void showHand(){
         System.out.println(hand.get(0));
     }
     public void showHandBoth(){
         System.out.println(hand);
     }
     
//getter for the handvalue is created
    public int getHandvalue() {
        return handValue;
    }
    //Busted is when the some of the values pf the cards is already greater than 21
     public boolean busted(int handvalue){
       if(handvalue>21){
           System.out.println("The dealer busted!");
           return true;
     }
       return false;
    }
     public int Turn(Deck deck){
         //Turn method is called if user dealers to hit or not
      while(wantsToHit()){
          System.out.println("The Dealer hits");
          Hit(deck);
          if(busted(handValue)){
              break;
              }        
      } 
      if(handValue<=21){
          System.out.println("The dealer stands.");       
      }
      return handValue;
     }

}


