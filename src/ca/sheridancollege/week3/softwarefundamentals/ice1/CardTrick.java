/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Alexander Berdichevskiy (ID: 991638033)
 * @date 2021-06-09
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        
        Card luckyCard = new Card();
        luckyCard.setValue(13);
        luckyCard.setSuit(Card.SUITS[3]);
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1);
            c.setSuit(Card.SUITS[rand.nextInt(4)]);
            
            magicHand[i] = c;
            System.out.println(c.getSuit() + " " + c.getValue());
        }
        
        //insert code to ask the user for Card value and suit, create their card
        System.out.println
        (
                "\nPlease, select a card suit:\n" +
                "(1 for Hearts; 2 for Diamonds; 3 for Spades; 4 for Clubs)"
        );
        String userSuit = Card.SUITS[sc.nextInt() - 1];
        System.out.print("Please, select a card value between 1 and 13: ");
        int userValue = sc.nextInt();
        
        System.out.println
        (
                "\nYour card:" +
                "\nSuit - " + userSuit +
                "\nValue - " + userValue
        );
        
        // and search magicHand here
        boolean found = false;
        for(Card nextCard : magicHand)
        {
            if(nextCard.getSuit().equals(userSuit))
            {
                if(nextCard.getValue() == userValue)
                {
                    found = true;
                }
            }
        }
        //Then report the result here
        System.out.println
        (
                "The Magic Hand does " + 
                (found ? "" : "not ") + 
                "contain your card"
        );
    }
    
}
