package com.company;
import java.util.*;
public class Player {
    private String username;
    private int chip_amount;
    private ArrayList<Card> hand;
    public Player(String name)
    {
        username = name;
        hand = new ArrayList<Card>();
        chip_amount = 1000;
    }

    public String getUser(){
        return username;
    }

    public int getChipAmt(){
        return chip_amount;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void addCard(ArrayList<Card> deck){//Used when dealing cards at start
        hand.add(deck.get(deck.size() - 1));
        deck.remove(deck.size() - 1);
    }

    public void addCommunityCards(ArrayList<Card> community_cards){//Needs changing!!
            if(community_cards.size() == 3){
                int n = 0;//will iterate till 3//will add first 3 cards to players hand
                while(n != 3){
                    hand.add(community_cards.get(n));
                    n++;
                }
            }
            else if(community_cards.size() == 4){
                hand.add(community_cards.get(3));
            }
            else if(community_cards.size() == 5){
            hand.add(community_cards.get(4));
        }

    }

    public void bet(int money){
        if (chip_amount - money > 0)
             chip_amount -= money;
        else
            System.out.print("That does not quite add up!");
    }

    public void winAmt(int won){
         chip_amount += won;
    }

    public void reset(){
        while (hand.size() != 0){
            hand.remove(0);
        }
    }

    public void fold(){//same as reset but has a diff purpose
        while (hand.size() != 0){
            hand.remove(0);
        }
    }
}
