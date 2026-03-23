package CardGame;

import Util.MyTools;

public class BlackJack {
  public static void main(String[] args) {
    // initialize player count
    String[] players;
    Hand[] tableHands;
    while (true){
      players = new String[MyTools.readInt("How many CPUs do you want to play against? (0-9)\n") + 2];
      if (players.length > 11){
        System.out.println("Error: CPU count too high.");
      } else{
        break;
      }
    }

    // Auto generated and guest star names
    String[] autoGenNames = { "Julie", "August", "Lukas", "Max", "Adam", "Maddie", "Kody", "Toby", "Mr. Crockett",
        "Nolan", "Jason", "Brian", "Marzi", "Amber", "Eli", "Carson", "Nickolas", "Eefqu", "Shae", "Percy", "Darryl&",
        "Nathan", "Patrick", "Hazel", "Zach", "Russel", "Leo" };
    String[] guestStarSonic = { "Sonic", "Tails", "Knuckles", "Amy", "Dr. Eggman", "Shadow", "Rouge", "Omega", "Silver",
        "Blaze", "Vector", "Espio", "Charmy", "Mighty", "Ray" };
    String[] guestStarUma = { "Gold Ship", "Special Week", "Silence Suzuka", "Mejiro McQueen", "Tokai Teio",
        "Agnes Tachyon", "Agnes Digital", "Symboli Rudolf", "Oguri Cap", "Nice Nature", "Rice Shower", "Taiki Shuttle",
        "Aston Machan", "Daiwa Scarlet", "Vodka", "Curren Chan", "Daitaku Helios", "Daiichi Ruby", "Mejiro Palmer",
        "Kitasan Black", "Satano Diamond", "Gentildonna", "Gold City", "Tosen Jordan", "Maruzensky",
        "Matikanefukukitaru", "Matikanetannhouser", "Meisho Doto", "T.M Opera O", "Jungle Pocket", "Manhattan Cafe",
        "Dantsu Flame", "Stay Gold", "Sakura Bakushin O", "Haru Urara", "Super Creek", "Mihono Burbon" };
    String[] guestStarInventory = {"Heavy Weapons Guy", "CLAP-TRAP", "Sam", "Max", "Tycho", "Strong Bad", "Brock Samson", "GladOS"};

    // initialize player name
    players[0] = MyTools.readString("What is your name?\n");
    players[players.length-1] = "The Dealer";

    // naming CPUs
    if (players.length > 2) {
      tableHands = new Hand[players.length];
      System.out.printf("-----\nAnd you'll be playing with these %d players...\n", players.length-2);

      // goes from the second index onward but not the last one, the dealer
      for (int i = 1; i < players.length-2; i++) {
        
        // announce the final player
        if (i == players.length-2){
          System.out.println("And last but not least...");
        }

        // 20% chance for a guest star (supposedly 2 per 10)

        if (i > 3 && (int) (Math.random() * 100) > 80) {
          // a second random number to chose a guest star list
          int random = (int) (Math.random()*30);

          if (random <= 10) { // Sonic
            players[i] = guestStarSonic[(int) (Math.random() * (guestStarSonic.length - 1))];
            System.out.println("Special guest star: " + players[i] + ", from Sonic the Hedgehog!");
          } else if (random > 10 && random <= 20) { //Uma
            players[i] = guestStarUma[(int) (Math.random() * (guestStarUma.length - 1))];
            System.out.println("Special guest star: " + players[i] + ", from Uma Musume!");
          } else { // Inventory
            players[i] = guestStarInventory[(int) (Math.random() * (guestStarInventory.length - 1))];
            System.out.println("Special guest star: " + players[i] + ", from Poker Night at the Inventory!");
          }

        } else { // normal names
          players[i] = autoGenNames[(int) (Math.random() * (autoGenNames.length - 1))];
          System.out.println(players[i]);
        }

      }
    } else {
      tableHands = new Hand[2];
    }
    
  }
}
