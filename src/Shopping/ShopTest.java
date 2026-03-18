package Shopping;

import Util.MyTools;

public class ShopTest {
  public static void main(String[] args) {
    ShoppingCart cart1 = new ShoppingCart();

    boolean activeShopping = false;

    String wannaShop = MyTools.readString("Would you like to go shopping? (Yes or No)\n");

    if (wannaShop.equalsIgnoreCase("yes")) {
      activeShopping = true;
    }

    while (activeShopping) {
      String itemName = MyTools.readString("What would you like to buy?\n");
      double itemPrice = MyTools.readDouble("How much does it cost?");
      int itemCount = MyTools.readInt("How many do you want?\n");
      cart1.addToCart(itemName, itemPrice, itemCount);

      wannaShop = MyTools.readString("Would you like to get anything else? (Yes or No)\n");

      if (wannaShop.equalsIgnoreCase("no")) {
        activeShopping = false;
      }
    }

    System.out.println(cart1);
  }
}
