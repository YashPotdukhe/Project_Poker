package com.company;
import java.util.*;
public class Winning {

    public boolean isRoyalFlush(ArrayList<Card> hand){
        int cards_analyzed = 0;//ensure that 5 cards are analyzed
        int suit_val = hand.get(0).getSuit();
        int rank_val = hand.get(0).getRank();
        boolean rank_same = true;
        boolean suit_same = true;
        while(cards_analyzed <= 5){

        }

        if(cards_analyzed == 5 && rank_same && suit_same){
            return true;
        }
      return false;
    }
    /*public boolean isStraightFlush(ArrayList<Card> hand) {
        int cards_analyzed = 0;
    }

    public boolean isFourOfAKind(ArrayList<Card> hand) {
        int cards_analyzed = 0;
    }

    public boolean isFullHouse(ArrayList<Card> hand) {
        int cards_analyzed = 0;
    }

    public boolean isFlush(ArrayList<Card> hand) {
        int cards_analyzed = 0;
    }

    public boolean isStraight(ArrayList<Card> hand) {
        int cards_analyzed = 0;
    }

    public boolean isThreeOfAKind(ArrayList<Card> hand) {
        int cards_analyzed = 0;
    }

    public boolean isTwoPair(ArrayList<Card> hand) {
        int cards_analyzed = 0;
    }

    public boolean isOnePair(ArrayList<Card> hand) {
        int cards_analyzed = 0;
    }

     */
}


