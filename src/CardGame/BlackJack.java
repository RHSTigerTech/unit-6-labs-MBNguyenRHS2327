package CardGame;

import Util.MyTools;

public class BlackJack {
  public static void main(String[] args) {
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
   */
  public static void gamePlay() {
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
    String[] autoGenNames = { "Julie", "August", "Lukas", "Max", "Adam", "Maddie", "Kody", "Toby", "Mr. Crockett",
        "Nolan", "Jason", "Brian", "Marzi", "Amber", "Eli", "Carson", "Nickolas", "Eefqu", "Shae", "Percy", "Darryl&",
        "Nathan", "Patrick", "Hazel", "Zach", "Russel", "Leo" };
    String[] guestStarSonic = { "Sonic", "Tails", "Knuckles", "Amy", "Dr. Eggman", "Shadow", "Rouge", "Omega", "Silver",
        "Blaze", "Vector", "Espio", "Charmy", "Mighty", "Ray", "Metal Sonic" };
    String[] guestStarUma = { "Gold Ship", "Special Week", "Silence Suzuka", "Mejiro McQueen", "Tokai Teio",
        "Agnes Tachyon", "Agnes Digital", "Symboli Rudolf", "Oguri Cap", "Nice Nature", "Rice Shower", "Taiki Shuttle",
        "Aston Machan", "Daiwa Scarlet", "Vodka", "Curren Chan", "Daitaku Helios", "Daiichi Ruby", "Mejiro Palmer",
        "Kitasan Black", "Satano Diamond", "Gentildonna", "Gold City", "Tosen Jordan", "Maruzensky",
        "Matikanefukukitaru", "Matikanetannhouser", "Meisho Doto", "T.M Opera O", "Jungle Pocket", "Manhattan Cafe",
        "Dantsu Flame", "Stay Gold", "Sakura Bakushin O", "Haru Urara", "Super Creek", "Mihono Burbon",
        "Stardust Speedway", "Fenomeno" };
    String[] guestStarInventory = { "Heavy Weapons Guy", "CLAP-TRAP", "Sam", "Max", "Tycho", "Strong Bad",
        "Brock Samson", "GladOS" };

    // initialize player name
    players[0] = MyTools.readString("What is your name?\n");
    players[players.length - 1] = "The Dealer";
    System.out.printf("Hello, %s\n", players[0]);
    players[0] += " (you)";

    // naming CPUs
    if (players.length > 2) {
      System.out.printf("-----\nAnd you'll be playing with these %d players...\n", players.length - 2);

      // goes from the second index onward but not the last one, the dealer
      for (int i = 1; i < players.length - 1; i++) {

        // announce the final player
        if (i == players.length - 2) {
          System.out.println("And last but not least...");
        }

        // 20% chance for a guest star (supposedly 2 per 10)

        if (i > 2 && (int) (Math.random() * 100) + 1 >= 80) {
          // a second random number to chose a guest star list
          int random = (int) (Math.random() * 30) + 1;
          // and a supposed 30% chance to gt any category of guest star
          if (random <= 10) { // Sonic
            players[i] = guestStarSonic[(int) (Math.random() * (guestStarSonic.length - 1))];
            System.out.printf("Special guest star: %s, from Sonic the Hedgehog!\n", players[i]);
          } else if (random > 10 && random <= 20) { // Uma
            players[i] = guestStarUma[(int) (Math.random() * (guestStarUma.length - 1))];
            System.out.printf("Special guest star: %s, from Uma Musume!\n", players[i]);
          } else { // Inventory
            players[i] = guestStarInventory[(int) (Math.random() * (guestStarInventory.length - 1))];
            System.out.printf("Special guest star: %s, from Poker Night at the Inventory!\n",
                players[i]);
          }

        } else { // normal names
          players[i] = autoGenNames[(int) (Math.random() * (autoGenNames.length - 1))];
          System.out.println(players[i]);
        }

      }

    }
    System.out.println("-----");

    tableHands = new Hand[players.length];

    for (int i = 0; i < tableHands.length - 1; i++) {
      tableHands[i] = new Hand(tableDeck.dealCard(), players[i]);
      System.out.println(tableHands[i].showHand() + "\n~~~");
    }
    tableHands[tableHands.length - 1] = new Hand(tableDeck.dealCard(), "The Dealer");
    System.out.println(tableHands[tableHands.length - 1].showHand() + "\n~~~");

    for (int i = 0; i < tableHands.length - 1; i++) {
      tableHands[i].hit(tableDeck.dealCard());
      System.out.println(tableHands[i].showHand() + "\n~~~");
    }
    tableHands[tableHands.length - 1].hit(tableDeck.dealCard());
    System.out.println(tableHands[tableHands.length - 1].showDealer() + "\n~~~");

    System.out.println("-----\n\nLets play!\n\n");
    int noCount = 0;
    while (noCount != players.length - 2) {
      for (int i = 0; i < players.length - 1; i++) {
        if (tableHands[i].getHandValue() > 21) {
          System.out.printf("Oops, sorry, %s. Looks like you've busted at a hand value of %d", players[i],
              tableHands[i].getHandValue());
        } else if (tableHands[i].getHandValue() == 21) {
          System.out.printf("Congrats, %s, you got a Black-Jack!");
        } else if (i > 0) {
          System.out.printf("Its %s's turn. %s, do you hit, or do you stay?", players[i]);
          if (aiChoice(tableHands[i].getHandValue())) {
            tableHands[i].hit(tableDeck.dealCard());
            System.out.printf("%s hits!", players[i]);
          } else {
            System.out.printf("%s stays!", players[i]);
          }
        }
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
