package Shopping;

import Util.MyTools;

public class ShopTest {
  public static void main(String[] args) {
    ShoppingCart cart1 = new ShoppingCart();

    boolean activeShopping = false;

    if (MyTools.readTwoOptions("Would you like to shop?\n", "Yes", "No")) {
      activeShopping = true;
    }

    while (activeShopping) {
      String itemName = MyTools.readString("What would you like to buy?\n");
      int itemCount = MyTools.readInt("How many do you want?\n");
      double itemPrice = MyTools.readDouble("How much does it cost?\n");
      cart1.addToCart(itemName, itemPrice, itemCount);

      if (!MyTools.readTwoOptions("Would you like to get something else?\n", "Yes", "No")) {
        activeShopping = false;
      }
    }

    System.out.println(cart1);
  }
}
