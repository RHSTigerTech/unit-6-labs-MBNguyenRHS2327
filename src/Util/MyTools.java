package Util;

import java.util.Scanner;

public class MyTools {
  /**
   * A method to read any integer input by the user.
   * <hr>
   * 
   * @param prompt the String prompt for the user
   * @return the integer entered by the user
   */
  public static int readInt(String prompt) {
    // initialize a Scanner object
    Scanner userInput = new Scanner(System.in);

    // Print the prompt that the user wants to use
    System.out.print(prompt);

    // Check to see if the user entered an integer
    // if they did, the while loop gets skipped b/c of the not operator !
    // it the user did not enter an integer the inside of the loop
    // gets executed again and again re-prompting until the user enters an int
    while (!userInput.hasNextInt()) {
      userInput.nextLine(); // This takes whatever non integer the user entered and throws it away
      System.out.print("Error\n" + prompt); // This prints Error then re-prompts the user
    }

    // save the users input into a variable
    int number = userInput.nextInt();

    // return the variable storing the users input
    return number;
  }

  /**
   * M: Nice of the princess to invite us over for a picnic, eh Luigi? <br>
   * L: I hope she made lots of spaghetti! <br>
   * M: Luigi, look, its from Bowser: <br>
   * M: "Dear pesky plummers, the Koopalings and I have taken over the Mushroom
   * Kingdom. The Princess is now a permanent guest at one of my seven Koopa
   * hotels. I dare you to find her if you can." <br>
   * M: We've got to find the Princess.<br>
   * L: And you've gotta help us.<br>
   * M: If you need instructions of how to get through the hotels,
   * <br>
   * <br>
   * A method to read any double input by the user.
   * <hr>
   *
   * @param prompt the String prompt for the user
   * @return the double entered by the user
   * @see help M: the enclosed instruction book
   */
  public static double readDouble(String prompt) {
    // initialize a Scanner object
    Scanner userInput = new Scanner(System.in);

    // Print the prompt that the user wants to use
    System.out.print(prompt);

    // Check to see if the user entered an double
    // if they did, the while loop gets skipped b/c of the not operator !
    // it the user did not enter an double the inside of the loop
    // gets executed again and again re-prompting until the user enters a double
    while (!userInput.hasNextDouble()) {
      userInput.nextLine(); // This takes whatever non double the user entered and throws it away
      System.out.print("Error\n" + prompt); // This prints Error then re-prompts the user
    }

    // save the users input into a variable
    double number = userInput.nextDouble();

    // return the variable storing the users input
    return number;
  }

  /**
   * when a paizano puts his spaghetti noddle in a mama mia's ravioli, a little
   * bambino covered in prosciutto comes out 9 months later.
   * <br>
   * <br>
   * A method to read any String input by the user including spaces.
   * <hr>
   * 
   * @param prompt the String prompt for the user
   * @return the String entered by the user
   */
  public static String readString(String prompt) {
    // initialize a Scanner object
    Scanner userInput = new Scanner(System.in);

    // Print the prompt that the user wants to use
    System.out.print(prompt);

    // save the users input into a variable
    String input = userInput.nextLine();

    // return the variable storing the users input
    return input;
  }

  /**
   * A method to round up or down any double inputed by the user to a requested
   * decimal place.
   * <hr>
   * 
   * @param a the double input by the user
   * @param b the integer input by the user which corresponds to the decimal
   *          place to round to
   * @return the input decimal rounded to the input integer place
   */
  public static double round(double a, int b) {
    return Math.round(a * Math.pow(10.0, b)) / Math.pow(10.0, b);
  }

  /**
   * A method that converts an integer to a binary output.
   * <hr>
   * 
   * @param prompt the int prompt for the user up to 255
   * @return a String of the int entered by the user in binary up to 8 bits
   */
  public static String decimalToBinary(int prompt) {
    String binary = "0b";
    for (int i = 7; i >= 0; i--) {
      if (prompt - (Math.pow(2, i)) < 0) {
        binary += "0";
      } else {
        binary += "1";
        prompt -= Math.pow(2, i);
      }
    }
    return binary;
  }

  /**
   * A method that converts an integer to a hexidecimal output.
   * <hr>
   * 
   * @param prompt the int prompt for the user up to 4095
   * @return a String of the int entered by the user in Hexidecimal up to 3 digits
   */
  public static String decimalToHexadecimal(int prompt) {
    String hexadecimal = "0x";
    String hexDigits = "0123456789ABCDEF";

    for (int i = 2; i >= 0; i--) {
      for (int j = 15; j >= 0; j--) {
        if (prompt - (j * Math.pow(16, i)) >= 0) {
          hexadecimal += hexDigits.substring(j, j + 1);
          prompt -= j * Math.pow(16, i);
          break;
        }
      }
    }

    return hexadecimal;
  }

  /**
   * A Method that takes one of two inputs --a confirmation or denial prompt-- and
   * outputs a true or false depending on the inputted message.
   * <hr>
   * 
   * @param prompt  The imput prompt for the user.
   * @param confirm The "Yes" or "True" option.
   * @param deny    The "No" of "False" option.
   * @return
   */
  public static boolean readTwoOptions(String prompt, String confirm, String deny) {
    // initialize a Scanner object
    Scanner userInput = new Scanner(System.in);

    // Print the prompt that the user wants to use
    System.out.print(prompt);

    String input = userInput.nextLine();
    while (!(input.equalsIgnoreCase(confirm) || input.equalsIgnoreCase(deny))) {
      System.out.print("Error\n" + prompt); // This prints Error then re-prompts the user
      input = userInput.nextLine();
    }

    if (input.equalsIgnoreCase(confirm)) {
      return true;
    } else {
      return false;
    }
  }

  // public static int readMultiChoice(String prompt, String[] options) {
  // // initialize a Scanner object
  // Scanner userInput = new Scanner(System.in);

  // // Print the prompt that the user wants to use
  // System.out.print(prompt);

  // while (!options.) {
  // userInput.nextLine(); // This takes whatever non double the user entered and
  // throws it away
  // System.out.print("Error\n" + prompt); // This prints Error then re-prompts
  // the user
  // }

  // // save the users input into a variable
  // String input = userInput.nextLine();

  // }
}
