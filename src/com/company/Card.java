package com.company;
import java.util.*;
public class Card {
        private int card_rank;
        private int card_suit;
        private String string_rank;
        private String string_suit;
        public Card (int rank, int suit)
        {
            card_rank = rank;
            card_suit = suit;
        }

        public int getRank(){
            return card_rank;
        }

        public int getSuit(){
            return card_suit;
        }

        public String toString(){
            if(card_rank == 1){
                string_rank = "Ace";
            }
            else if (card_rank == 11){
                string_rank = "Jack";
            }
            else if (card_rank == 12){
                string_rank = "Queen";
            }
            else if (card_rank == 13){
                string_rank = "King";
            }
            else{
                string_rank = String.valueOf(card_rank);
            }

            if(card_suit == 0){
                string_suit = "Hearts";
            }
            else if(card_suit == 1){
                string_suit = "Diamonds";
            }
            else if(card_suit == 2){
                string_suit = "Spades";
            }
            else if(card_suit == 3){
                string_suit = "Clubs";
            }

            return string_rank + " of " + string_suit;
        }


    }

