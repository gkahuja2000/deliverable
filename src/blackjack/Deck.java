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
public class Deck {
//arrayList is created
    private ArrayList<Card> deck;
    //no-arg constructor
    Deck() {
        deck = new ArrayList<Card>();
        //loop used to generate cards 
        //4 for the suits and 13 for the cards
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                deck.add(new Card(i, j));
            }
        }
    }

    public void shuffle() {
        Random random = new Random(); //Random inbuilt method is called
        Card card;//object of class card
        for (int i = 0; i < 100 ; i++) {
            int index1 = random.nextInt(deck.size() - 1);
            int index2 = random.nextInt(deck.size() - 1);
            card = deck.get(index2);
            deck.set(index2, deck.get(index1));
            deck.set(index1,card);
        }
    }

    public Card draw() {//if there is draw the card is removed
        return deck.remove(0);
    }
}