package CardGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import Util.MyTools;

public class BlackJack {
  public static void main(String[] args) throws InterruptedException {
    boolean playing = true;
    while (playing) {
      gamePlay();
      playing = MyTools.readTwoOptions("Do you want to play again? (Yes/No)\n", "Yes", "No");
    }
  }

  /**
   * The actual game of Black-Jack.<br>
   * It's a method because it is much easier to loop forever in main.
   * <hr>
   * 
   * @throws InterruptedException
   */
  public static void gamePlay() throws InterruptedException {
    // initialize player count
    String[] players = new String[1];
    Hand[] tableHands;
    DeckOfCards tableDeck = new DeckOfCards();
    tableDeck.shuffle();
    while (players.length <= 1 || players.length > 11) {
      players = new String[MyTools.readInt("How many CPUs do you want to play against? (0-9)\n") + 2];
      if (players.length > 11) {
        System.out.println("Error: CPU count too high.");
      } else if (players.length <= 1) {
        System.out.println("Error: Player count too low.");
      }
    }

    // Auto generated and guest star names
    ArrayList<String> autoGenNames = new ArrayList<String>(Arrays.asList("Julie", "August", "Lukas", "Max", "Adam", "Maddie", "Kody", "Toby", "Mr. Crockett", "Nolan", "Jason", "Brian", "Marzi", "Amber", "Eli", "Carson", "Nickolas", "Eefqu", "Shae", "Percy", "Darryl&", "Nathan", "Patrick", "Hazel", "Zach", "Russel", "Leo", "Alexis"));
    ArrayList<String> guestStarSonic = new ArrayList<String>(Arrays.asList("Sonic", "Tails", "Knuckles", "Amy", "Dr. Eggman", "Shadow", "Rouge", "Omega", "Silver", "Blaze", "Vector", "Espio", "Charmy", "Mighty", "Ray", "Metal Sonic"));
    ArrayList<String> guestStarUma = new ArrayList<String>(Arrays.asList("Gold Ship", "Special Week", "Silence Suzuka", "Mejiro McQueen", "Tokai Teio", "Agnes Tachyon", "Agnes Digital", "Symboli Rudolf", "Oguri Cap","Nice Nature", "Rice Shower", "Taiki Shuttle", "Aston Machan", "Daiwa Scarlet", "Vodka", "Curren Chan", "Daitaku Helios", "Daiichi Ruby", "Mejiro Palmer", "Kitasan Black", "Satano Diamond", "Gentildonna", "Gold City", "Tosen Jordan", "Maruzensky", "Matikanefukukitaru", "Matikanetannhouser", "Meisho Doto", "T.M Opera O", "Jungle Pocket", "Manhattan Cafe", "Dantsu Flame", "Stay Gold", "Sakura Bakushin O", "Haru Urara", "Super Creek", "Mihono Burbon", "Stardust Speedway", "Fenomeno"));
    ArrayList<String> guestStarInventory = new ArrayList<String>(Arrays.asList("Heavy Weapons Guy", "CLAP-TRAP", "Sam", "Max", "Tycho", "Strong Bad", "Brock Samson", "GladOS"));
    ArrayList<String> guestStarResident = new ArrayList<String>(Arrays.asList("Leon Kenedy", "Ada Wong", "Albert Wesker", "Luis Sera", "Claire Redfield", "Sherry Birkin", "Jill Valentine", "Carlos Oliveira", "Nemesis", "Chris Redfield", "Ethan Winters", "Ashley Graham", "Rebecca Chambers", "Hunk", "Alcina Dimitrescu", "Karl Heisenberg", "Moira Burton", "Rosemary Winters", "Eveline", "Joe Baker", "Jack Krauser", "Isidro Uriarte Talavera", "Merchant", "The Duke"));
    int guestListCount = 4;

    // initialize player name
    players[0] = MyTools.readString("What is your name?\n");
    players[players.length - 1] = "The Dealer";
    System.out.printf("Hello, %s\n", players[0]);
    players[0] += " (you)";
    TimeUnit.SECONDS.sleep(1);
    // naming CPUs
    if (players.length > 2) {
      if (players.length > 3) {
        System.out.printf("-----\nAnd you'll be playing with these %d players...\n", players.length - 2);
      } else{
        System.out.println("-----\nAnd you'll be playing with...");
      }
      // goes from the second index onward but not the last one, the dealer
      for (int i = 1; i < players.length - 1; i++) {
        TimeUnit.SECONDS.sleep(1);

        // announce the final player
        if (i == players.length - 2 && players.length > 3) {
          System.out.println("And last but not least...");
          TimeUnit.SECONDS.sleep(1);
        }
        int randIndex = 0;

        // 20% chance for a guest star (supposedly 2 per 10)

        if (i > 2 && (int) (Math.random() * 100) + 1 >= 80) {
          // a second random number to chose a guest star list
          int random = (int) (Math.random() * (10*guestListCount)) + 1;
          // and a supposed 30% chance to gt any category of guest star
          if (random <= 10) { // Sonic
            randIndex = (int) (Math.random() * (guestStarSonic.size()));
            players[i] = guestStarSonic.get(randIndex);
            guestStarSonic.remove(randIndex);
            System.out.printf("Special guest star: %s, from Sonic the Hedgehog!\n", players[i]);
            // end sonic
          } else if (random > 10 && random <= 20) { // Uma
            randIndex = (int) (Math.random() * (guestStarUma.size()));
            players[i] = guestStarUma.get(randIndex);
            guestStarUma.remove(randIndex);
            System.out.printf("Special guest star: %s, from Uma Musume!\n", players[i]);
            // end uma
          } else if (random > 20 && random <= 30) { // Inventory
            randIndex = (int) (Math.random() * (guestStarUma.size()));
            players[i] = guestStarInventory.get(randIndex);
            guestStarInventory.remove(randIndex);
            System.out.printf("Special guest star: %s, from Poker Night at the Inventory!\n", players[i]);
            // end inventory
          } else if (random > 30 && random <= 40) { // Resident Evil
            randIndex = (int) (Math.random() * (guestStarResident.size()));
            players[i] = guestStarResident.get(randIndex);
            guestStarResident.remove(randIndex);
            System.out.printf("Special guest star: %s, from Resident Evil!\n", players[i]);
            // end resident
          }

        } else { // normal names
          randIndex = (int) (Math.random() * (autoGenNames.size()));
          players[i] = autoGenNames.get(randIndex);
          autoGenNames.remove(randIndex);
          System.out.println(players[i]);
        }

      }

    }
    System.out.println("-----");
    TimeUnit.SECONDS.sleep(1);

    tableHands = new Hand[players.length];

    for (int i = 0; i < tableHands.length; i++) { // deal cards to all including dealer
      tableHands[i] = new Hand(tableDeck.dealCard(), players[i]);
      System.out.println(tableHands[i].showHand() + "\n~~~");
      TimeUnit.SECONDS.sleep(1);
    }

    for (int i = 0; i < tableHands.length - 1; i++) { // deal cards again
      tableHands[i].hit(tableDeck.dealCard());
      System.out.println(tableHands[i].showHand() + "\n~~~");
      TimeUnit.SECONDS.sleep(1);
    }
    tableHands[tableHands.length - 1].hit(tableDeck.dealCard()); // seperate dealer card deal
    System.out.println(tableHands[tableHands.length - 1].showDealer() + "\n~~~");
    TimeUnit.SECONDS.sleep(1);

    System.out.println("-----\n\nLets play!\n\n");
    int stayCount = 0; // play until all players stay
    while (stayCount != players.length - 1) { // actual gameplay loop
      // System.out.println(stayCount);
      for (int i = 0; i < players.length - 1; i++) { // turn loop
        stayCount = 0;
        TimeUnit.SECONDS.sleep(1);

        if (tableHands[i].getHandValue() > 21) { // bust skip
          System.out.printf("Oops, sorry, %s. Looks like you've busted at a hand value of %d\n", players[i],
              tableHands[i].getHandValue());
              TimeUnit.SECONDS.sleep(1);
        } else if (tableHands[i].getHandValue() == 21) { // black-jack skip
          System.out.printf("Congrats, %s, you got a Black-Jack!\n", players[i]);
          TimeUnit.SECONDS.sleep(1);
        } else if (i > 0) { // ai choice
          System.out.printf("Its %1$s's turn. %1$s, do you hit, or do you stay? (Hand value: %2$d)\n", players[i],
              tableHands[i].getHandValue());
          TimeUnit.SECONDS.sleep((int) (Math.random() * 5) + 1);
          if (aiChoice(tableHands[i].getHandValue())) { // ai hit
            tableHands[i].hit(tableDeck.dealCard());
            System.out.printf("%s hits!\n", players[i]);
            TimeUnit.SECONDS.sleep(1);
          } else { // ai stay
            System.out.printf("%s stays!\n", players[i]);
            stayCount++;
            TimeUnit.SECONDS.sleep(1);
          }
        } else { // player turn
          System.out.printf("Its %1$s's turn. %1$s, do you hit, or do you stay? (Hand value: %2$d)\n", players[i],
              tableHands[i].getHandValue());
          if (MyTools.readTwoOptions("Hit or Stay?\n", "Hit", "Stay")) { // player hit
            tableHands[i].hit(tableDeck.dealCard());
            System.out.printf("%s hits!\n", players[i]);
            TimeUnit.SECONDS.sleep(1);
          } else { // player stay
            System.out.printf("%s stays!\n", players[i]);
            stayCount++;
            TimeUnit.SECONDS.sleep(1);
          }
        }
        if (tableHands[i].getHandValue() >= 21) {
          stayCount++;
        }
        System.out.println(tableHands[i].showHand() + "\n~~~");
        TimeUnit.SECONDS.sleep(1);
      } // end turn loop

      // end of round review
      System.out.println("Heres everyone's hands so far:");
      TimeUnit.SECONDS.sleep(1);
      for (int j = 0; j < tableHands.length - 1; j++) {
        System.out.println(tableHands[j].showHand() + "\n~~~");
        TimeUnit.SECONDS.sleep(1);
      }
      System.out.println(tableHands[tableHands.length - 1].showDealer() + "\n~~~");
    } // end of gameplay loop
    TimeUnit.SECONDS.sleep(1);
    System.out
        .println("Everyone has decided to stay! Heres a review of everyone's scores before the dealer gets his cards:");
    for (int j = 0; j < tableHands.length - 1; j++) {
      TimeUnit.SECONDS.sleep(1);
      System.out.println(tableHands[j].getOwner() + "'s hand: " + tableHands[j].getHandValue() + "\n~~~");
    }
    TimeUnit.SECONDS.sleep(1);
    System.out.println("The dealer is now getting his cards...\n" + tableHands[tableHands.length - 1].showHand());
    while (tableHands[tableHands.length - 1].getHandValue() < 17) {
      TimeUnit.SECONDS.sleep(1);
      tableHands[tableHands.length - 1].hit(tableDeck.dealCard());
      System.out.println(tableHands[tableHands.length - 1].showHand());
    }

    for (int i = 0; i < tableHands.length - 1; i++) {
      TimeUnit.SECONDS.sleep(1);
      if (tableHands[i].getHandValue() >= tableHands[tableHands.length - 1].getHandValue()
          && tableHands[i].getHandValue() <= 21 || tableHands[tableHands.length - 1].getHandValue() > 21) {
        System.out.printf("Congratulations %s, you won some cash!\n", players[i]);
      } else {
        System.out.printf("Ooh, sorry %s, looks like you lost your cash.\n", players[i]);
      }
    }

  }

  public static boolean aiChoice(int handValue) {
    int risk = (int) (Math.random() * 100);
    if (handValue < 16) {
      return true;
    } else if (handValue >= 16 && risk >= 80) {
      return true;
    } else {
      return false;
    }
  }
}
