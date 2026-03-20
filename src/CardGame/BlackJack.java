package CardGame;

import Util.MyTools;

public class BlackJack {
  public static void main(String[] args) {
    String[] players = new String[MyTools.readInt("How many CPUs do you want to play against? (0-9)\n") + 1];

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
        "Dantsu Flame", "Stay Gold", "Sakura Bakushin O", "Haru Urara" };
    String[] guestStarInventory = {"Misha", "CL4P-TP", "Sam", "Max", "Tycho", "Strong Bad", "Brock Samson", };

    players[0] = MyTools.readString("What is your name?\n");
    if (players.length > 1) {
      System.out.println("-----\nAnd you'll be playing with...");
      for (int i = 1; i < players.length; i++) {
        
        if (i == players.length-1){
          System.out.println("And last but not least...");
        }

        if (i > 3 && (int) (Math.random() * 100) > 80) {
          int random = (int) (Math.random()*30);

          if (random <= 10) {
            players[i] = guestStarSonic[(int) (Math.random() * (guestStarSonic.length - 1))];
            System.out.println("Special guest star: " + players[i] + ", from Sonic the Hedgehog!");
          } else if (random > 10 && random <= 20) {
            players[i] = guestStarUma[(int) (Math.random() * (guestStarUma.length - 1))];
            System.out.println("Special guest star: " + players[i] + ", from Uma Musume!");
          } else {
            players[i] = guestStarInventory[(int) (Math.random() * (guestStarInventory.length - 1))];
            System.out.println("Special guest star: " + players[i] + ", from Poker Night at the Inventory!");
          }

        } else {
          players[i] = autoGenNames[(int) (Math.random() * (autoGenNames.length - 1))];
          System.out.println(players[i]);
        }

      }
    }

  }
}
