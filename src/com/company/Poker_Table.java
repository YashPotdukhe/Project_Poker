package com.company;
import java.util.*;
public class Poker_Table{
    public static void main(String[] args) {
        Scanner string_input = new Scanner(System.in);//user string inputs
        Scanner int_input = new Scanner(System.in);//user int inputs
        Random gen = new Random();
        int play = 1;//if play changes to any other int, the game will end
        //String next_hand = "Y";
System.out.println("Welcome to the Poker: Texas Hold 'Em Edition.\n\nYou will be going against 2 other players to try to win!");
System.out.println("Here are some things to keep in mind:\n1) You will start out with $1000.\n2) There is a buy-in every hand of $5");
System.out.println("3) when asked, enter the letter \"B\" to bet, \"R\" to raise, and \"F\" to fold");
        ArrayList<Card> deck = new ArrayList<Card>();//Deck of Cards
        ArrayList<Card> community_cards = new ArrayList<Card>();//Community of cards (the flop, turn, river)
        Player calvin = new Player("Calvin");//Computer player #1
        Player sujith = new Player("Sujith");//Computer player #2


        System.out.print("Username: ");
        String user = string_input.nextLine();
        Player player = new Player(user);//Player
System.out.println("\nLet's get started!");

while(play == 1 || player.getChipAmt() > 0){
    int money_pot = 0;//money pool of chips
    System.out.println("This is your current chip balance: $" + player.getChipAmt());
    player.reset();
    calvin.reset();
    sujith.reset();
    shuffle(reset(deck));
    player.addCard(deck);
    calvin.addCard(deck);
    sujith.addCard(deck);
    player.addCard(deck);
    calvin.addCard(deck);
    sujith.addCard(deck);//Each player gets 2 cards
    System.out.println("Your current pocket hand: " + player.getHand());//display pocket hand
    System.out.print(" bet(B) or fold(F):  ");
    String pre_answer = string_input.nextLine();
    if (pre_answer.equals("B")){
        System.out.print("Enter bet amount: ");
        int pre_flop = int_input.nextInt();//amt player bets before flop
        while(pre_flop < 0 || pre_flop > player.getChipAmt()){//Takes into account if user puts in bad amount
            System.out.print("Insufficient number! Enter new bet amount: ");
            pre_flop = int_input.nextInt();
        }
        player.bet(pre_flop);
        calvin.bet(pre_flop);
        sujith.bet(pre_flop);//both AI players will bet pre-flop
        money_pot += 3*pre_flop;
        System.out.print("Your chip amount: " + player.getChipAmt() +"\n");
        System.out.print("Amount of money in pot: " + money_pot);
    }
    else{
        player.fold();
    }
    flop(deck,community_cards);//FLOP!!
    player.addCommunityCards(community_cards);
    calvin.addCommunityCards(community_cards);
    sujith.addCommunityCards(community_cards);
    System.out.print("\nbet(B) or fold(F):  ");
    String flop_answer = string_input.nextLine();
    if (player.getHand().size() > 0 && flop_answer.equals("B")){
        System.out.print("Enter bet amount: ");
        int flop = int_input.nextInt();//amt player bets before flop
        while(flop < 0 || flop > player.getChipAmt()){//Takes into account if user puts in bad amount
            System.out.print("Insufficient number! Enter new bet amount: ");
            flop = int_input.nextInt();
        }
        player.bet(flop);
        System.out.print("Your chip amount: " + player.getChipAmt());
    }
    else{
        player.fold();
    }

    }
    System.out.println("Thanks for playing! Come again soon!!");
    }





    public static ArrayList reset(ArrayList<Card> deck){//Makes card deck
        while(deck.size()!= 0){//takes out all the cards in the deck
            deck.remove(0);
        }

        for(int rank = 1; rank <= 13; rank++){//Adds card objects to ArrayList
            for(int suit = 0; suit < 4; suit++){
                Card card = new Card(rank,suit);
                deck.add(card);
            }
        }
        return deck;
    }

    public static ArrayList<Card> shuffle(ArrayList <Card> deck){
        Random rand_index = new Random();
        for(int i = 0; i < deck.size();i++) {
            int temp_rand_index = rand_index.nextInt(52);
            Card temp_card = deck.get(temp_rand_index);
            deck.set(temp_rand_index, deck.get(i));
            deck.set(i, temp_card);//Swap of each card
        }
        return deck;
    }

    public static void flop(ArrayList <Card> deck, ArrayList <Card> community_cards) {
        System.out.println("\nThe flop: ");
        deck.remove(deck.size() - 1);//Burns the top card
        community_cards.add(deck.get(deck.size() - 1));
        community_cards.add(deck.get(deck.size() - 2));
        community_cards.add(deck.get(deck.size() - 3));//flop
        deck.remove(deck.size() - 1);
        deck.remove(deck.size() - 1);
        deck.remove(deck.size() - 1);//remove the three cards that were the flop from the deck of cards

        System.out.println("[" + community_cards.get(0) + ", " + community_cards.get(1)+ ", " + community_cards.get(2) + "]");

    }

    public static void turn(ArrayList <Card> deck, ArrayList <Card> community_cards) {
        System.out.println("The turn: ");
        deck.remove(deck.size() - 1);//burns the top card
        community_cards.add(deck.get(deck.size() - 1));//turn
        deck.remove(deck.size() - 1);//Removes the card that was turn
        System.out.println("[" + community_cards.get(3) + "]");
    }

    public static void river(ArrayList <String> deck, ArrayList <String> community_cards) {
        System.out.println("The river: ");
        deck.remove(deck.size() - 1);//burns the top card
        community_cards.add(deck.get(deck.size() - 1));//river
        deck.remove(deck.size() - 1);//Removes the card that was river
        System.out.println("[" + community_cards.get(4) + "]");
    }

}


