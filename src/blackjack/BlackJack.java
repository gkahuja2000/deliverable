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
public class BlackJack {
private static int cash;
private static int bet;
private static int counter;
        
private static ArrayList<Card>hand;
private static int handValue;
private static String name;
public static void main(String[] args){
 
    Scanner sc = new Scanner(System.in);//Scanner class object is created
    System.out.println("Hi! What is your name?");
    name = sc.nextLine();
    System.out.println("Hello, "+ name +", let's play BlackJack!");
    System.out.println("With how much cash do you want to start the game?");
    cash = sc.nextInt();
    System.out.println("You want to start with $"+cash);
    while(cash>0){
        Deck deck = new Deck();//object is created for the deck class
        deck.shuffle();//this will shuffle the cards
        counter=0;
        Dealer dealer = new Dealer(deck);
        List<Card> hand = new ArrayList<>();
        hand.add(deck.draw());//this will draw the card1
        hand.add(deck.draw());//this will draw the card 2 for the player
        System.out.println("How much would you like to bet?");
        bet = Bet(cash);//this method is called becuse person can bet only 
        //amount will he have or less than that but not more
        System.out.println("Money on the table: $"+bet);
        System.out.println("Your hand is on: ");
        System.out.println(hand);
        int handValue = calc(hand);
        System.out.println("Dealer hand is on: ");
        dealer.showHand();//this will show dealer cards
        //this will check the both player and dealer  card value is same or not 
        if(hasBJack(handValue) && dealer.hasBJack())
        {
            Draw();//if it is samethe mathch is draw
        }
        else if(hasBJack(handValue))
        {
            System.out.println("You have BlackJack!"); // if player value of cards is 21 the he has a blackjack and he won
            System.out.println("Your amount is doubled");//and amount will be doubled as per the rules
            cash = cash+bet;
            Won();//won method will be called
        }
        else if(dealer.hasBJack())
        {
            System.out.println("Dealer hand is on:");//if  dealer have the blackjack then you will lose 
            dealer.showHandBoth();
            Lost();
        }
        else
        {
            if(2*bet<cash)//if you have mpre cash than twice your bet they will 
             //ask for double down as the amount for bet willbe doubled
            {
                System.out.println("Would you like to double down?");
                String select = sc.nextLine();
                select = select.toLowerCase();
                while(!isyorn(select))
                {
                    System.out.println("Please enter yes or no.");
                    select = sc.nextLine();
                    select = select.toLowerCase();
                }
                if(select.equals("yes"))
                {//if yes is seleted amount for bet will be doubled
                    System.out.println("You want to double down!!");
                    bet=2*bet;
                   System.out.println("Money on the table:"+bet);
                }
            }
              //this method is called to ak that user wants to hit or stand
            System.out.println("Would you like to hit or stand?");
            String option = sc.nextLine();
            option = option.toLowerCase();
            while(!isHorS(option))
            {
                System.out.println("Please enter 'hit' or 'stand' !!");
                option = sc.nextLine();
                option = option.toLowerCase();
            }
            while(option.equals("hit"))
            {//if he wants to hit the hit method will be called one more card will be generated
                Hit(deck, hand);
                System.out.println("Your hand is now on:");
                System.out.println(hand);
                handValue = calc(hand);
                if(Bust(handValue))
                {
                    Lost();
                    break;
                }
               
                System.out.println("Would you like to hit or stand?");
                option = sc.nextLine();
                option = option.toLowerCase();
            }
            if(option.equals("stand"))
            {//if he wants to stand it will be checked that you won or lose
                int dealerhand = dealer.Turn(deck); 
                System.out.println("Dealer hand is on:");
                dealer.showHandBoth();
                if(dealerhand>21)
                {
                    Won();
                }
                else
                {
                    int player = 21-handValue;
                    int dealers = 21-dealerhand;
                    if(player==dealers)
                    {
                        Draw();// if the differnce will be same then it will be draw
                    }
                    if(player<dealers)
                    {// won will be when the diifernce of player will be less
                        Won();
                    }
                    if(dealers<player)
                    {//lost will be when the differnce of player will be more
                        Lost();
                    }
                }
            }
        }
    System.out.println("Would you like to play again?");
    String answer = sc.nextLine();
    answer = answer.toLowerCase();
    while(!isyorn(answer))
            {
                System.out.println("Please answer yes or no.");
                answer = sc.nextLine();
                answer = answer.toLowerCase();
            }
    if(answer.equals("no"))
    {//if the answer will be no it will break
        break;
    }
}//it will continue only is you would have enoiugh cash
    System.out.println("Your cash is: "+cash);
   if(cash==0)
    {
        System.out.println("You donot have enough cash!");
    }
    else
    {
        System.out.println("Hey!"+name+",Enjoy!!");
    }
}
public static boolean hasBJack(int handValue)
{
    if(handValue==21)
    {
        return true;
    }
    return false;
}
public static int calc(List<Card> hand)
{
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    int handValue=0;
    for(int i=0; i<aHand.length; i++)
    {
        handValue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            counter++;
        }
        while(counter>0 && handValue>21)
        {
            handValue=handValue - 10;
            counter--;
        }
    }
    return handValue;
}
public static int Bet(int cash)
{ //bet method checks if you have enough amount to bet or not
    Scanner sc = new Scanner(System.in);
    int bet= sc.nextInt();
    while(bet>cash)
    {
        System.out.println("Your bet is more than your cash!");
       System.out.println("How much would you like to bet?");
        bet=sc.nextInt();
    }
    return bet;
}
public static void Won()
{//won method will tell want cash is left and that you won
    System.out.println("CONGRATULATIONS, you won!");
    cash=cash+bet;
    System.out.println("Cash: "+cash);
}
public static void Lost()
{//lost method will tell what cash is left and that you lose
    System.out.println("Sorry, you LOSE :-(");
    cash=cash-bet;
    System.out.println("Cash: "+cash);
}
public static void Draw()
{//draw ,ethod will be when you draw the match and ylu get your bet money back
    System.out.println("It's a draw!");
    System.out.println("Hey,You get your money back.");
    System.out.println("Cash: "+cash);
}
public static void Hit(Deck deck, List<Card> hand)
{
    hand.add(deck.draw());
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    handValue = 0;
    for(int i=0; i<aHand.length; i++)
    {
        handValue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            counter++;
        }
        while(counter>0 && handValue>21)
        {
            handValue-=10;
            counter--;
        }
    }
}

public static boolean isHorS(String option)
{
    if(option.equals("hit") || option.equals("stand"))
    {
        return true;
    }
    return false;
}
public static boolean Bust(int handValue)
{
    if(handValue>21)
    {
        System.out.println("You have busted!");
        return true;
    }
    return false;
}
public static boolean isyorn(String answer)
{
    if(answer.equals("yes") || answer.equals("no"))
    {
        return true;
    }
    return false;
}
    }