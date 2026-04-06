package Sales;

/**
 * Name: Juliette Nguyen
 * Date: 17/3/26
 * Period: 3
 *
 * Sales.Sales.java
 *
 * Reads in and stores sales for each of 5 salespeople.  Displays
 * sales entered by salesperson id and total sales for all salespeople.
 */

import Util.*;

public class Sales {
  public static void main(String[] args) {

    // TODO 4) Prompt the user for the number of sales people that they need to
    // enter
    // TODO 4) and modify the program to create an appropriately sized array.

    final int SALESPEOPLE = MyTools.readInt("Enter number of sales persons for the day: ");
    int[] sales = new int[SALESPEOPLE];
    int sum;

    for (int i = 0; i < sales.length; i++) {
      sales[i] = MyTools.readInt("Enter sales for salesperson " + (i + 1) + ": ");
    }
    // print the array for verification
    // System.out.println(Arrays.toString(sales));

    System.out.println("\nSalesperson   Sales");
    System.out.println("--------------------");
    sum = 0;
    for (int i = 0; i < sales.length; i++) {
      System.out.println((i + 1) + "\t\t" + sales[i]);
      sum += sales[i];
    }

    System.out.println("\nTotal sales: " + sum);

    // TODO 1b) Use your average method to print the average sales
    System.out.println("Today's average sales: " + average(sales) + " sales.");

    // TODO 2b) Use your indexOfMax method to print the index of the best sales
    // person
    // TODO 2b) and the sales amount for that sales person.
    System.out.print("Sales person " + (indexOfMax(sales) + 1) + " had the best sales at ");
    System.out.println(sales[indexOfMax(sales)] + " sales.");

    // TODO 3b) Do the same for the worst sales person
    System.out.print("Sales person " + (indexOfMin(sales) + 1) + " had the worst sales at ");
    System.out.println(sales[indexOfMin(sales)] + " sales.");

  }

  public static double average(int[] arr) throws IllegalStateException {
    // TODO 1a) compute and return the average of arr
    // Be sure to use the length instance variable and you may assume that the array
    // is full.
    // If the array does not have at least 1 element in it, throw an
    // IllegalStateException
    if (arr.length < 1) {
      throw new IllegalStateException("Array must have at least one statement to calculate the average");
    }

    double sum = 0.0;

    for (int num : arr) {
      sum += num;
    }

    return sum / arr.length;
  }

  public static int indexOfMax(int[] arr) {
    // TODO 2a) find and return the index of the max value in arr
    int max = Integer.MIN_VALUE;
    int maxIndex = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
        maxIndex = i;
      }
    }

    return maxIndex;
  }

  // TODO 3a) Do the same for an indexOfMin method
  public static int indexOfMin(int[] arr) {
    // TODO 2a) find and return the index of the max value in arr
    int min = Integer.MAX_VALUE;
    int minIndex = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
        minIndex = i;
      }
    }

    return minIndex;
  }

}
