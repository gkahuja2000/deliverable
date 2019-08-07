/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author gkauja
 */
public class Card {
        private int position;
        private int suit;
        private int value;
        private static String[] positions = {"Joker","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
        private static String[] suits = {"Diamonds","Clubs","Hearts","Spades"};
        
        //two arg constructor
        Card(int suit, int values){
        this.position = values;
        this.suit = suit;
        }
        //toString method is called
        public String toString(){
        return positions[position]+" of "+suits[suit];
        }
        //getter setters are created because the members are private

    public int getPosition() {
        return position;
    }

    public int getSuit() {
        return suit;
    }
    //as per the rule of the game any card ten,jack,queen,king all have value ten
    //and the ace has 1 or 11 value as per the need
    //otherwise the values are same as earlier
    public int getValue() {
        if(position>10){
            value=10;
        }
        else if(position==1){
          value = 11;
        }
        else{
          value = position;
        }
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }
        
}
