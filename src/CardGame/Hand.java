package CardGame;

public class Hand {
  private Card[] hand;
  private String owner;
  private int sum;

  /**
   * The basic constructor for the hand class.<br>
   * Takes the name of the owner and two cards to simulate creating a new hand for
   * black jack for a theoretically infinite amount of players.<br>
   * Also saves the card order and value of the hand.
   * <hr>
   * 
   * @param c1   the first card of the new hand
   * @param name the name of the hand's owner
   */
  public Hand(Card c1, String name) {
    hand = new Card[1];
    hand[0] = c1;
    owner = name;
    sum = getHandValue();
  }

  /**
   * The hit method simulates hitting in blackjack; getting a new card<br>
   * Creates a new hand array and lengthens it to include the new card.<br>
   * <hr>
   * 
   * @param newCard The card to be added into the hand.
   */
  public void hit(Card newCard) {
    Card[] temp = new Card[hand.length];
    for (int i = 0; i < hand.length; i++) {
      temp[i] = hand[i];
    }

    hand = new Card[temp.length + 1];
    for (int i = 0; i < temp.length; i++) {
      hand[i] = temp[i];
    }

    hand[hand.length - 1] = newCard;
  }

  /**
   * A getter method to see the hand object's cards.
   * <hr>
   * 
   * @return an array of the cards in the hand.
   */
  public Card[] getHand() {
    return hand;
  }

  /**
   * a getter method to see the hand object's owner.
   * <hr>
   * 
   * @return a string of the hand's owner.
   */
  public String getOwner() {
    return owner;
  }

  /**
   * A toString method that neatly formats out current hand, its owner, and its
   * value.<br>
   * Ex:<br>
   * Julie's hand:<br>
   * Ace of Spades, Three of Clubs, Five of Hearts, (Value: 19)
   * <hr>
   * 
   * @return a formatted string of the hand object.
   */
  public String showHand() {
    String handOut = "";
    String suffix = "";
    sum = getHandValue();
    for (Card crd : hand) {
      handOut += crd + ", ";
    }
    if (sum == 21){
      suffix = "(Black-Jack!)";
    } else if (sum > 21){
      suffix = "(out!)";
    }
    return owner + "'s hand:\n" + handOut + "(Value: " + sum + ")" + suffix;
  }

  public String showDealer(){
    String handOut = "";
    for (int i = 0; i < hand.length; i++) {
      if (i > 0){
        handOut += "?, ";
      } else {
        handOut += hand[i] + ", ";
      }
    }
    return "The Dealer's hand:\n" + handOut + "(Value: ?)";
  }

  /**
   * A complex method with like 40 else ifs to calculate the value of the hand
   * judging by the face values of the cards.<br>
   * Additionally calculates the value of an ace between 1 and 11.
   * <hr>
   * 
   * @return an integer of the hand's value.
   */
  public int getHandValue() {
    sum = 0;
    boolean bigAce = false;

    for (Card c : hand) {
      if (c.getFace().equals("Two")) {
        sum += 2;
      } else if (c.getFace().equals("Three")) {
        sum += 3;
      } else if (c.getFace().equals("Four")) {
        sum += 4;
      } else if (c.getFace().equals("Five")) {
        sum += 5;
      } else if (c.getFace().equals("Six")) {
        sum += 6;
      } else if (c.getFace().equals("Seven")) {
        sum += 7;
      } else if (c.getFace().equals("Eight")) {
        sum += 8;
      } else if (c.getFace().equals("Nine")) {
        sum += 9;
      } else if (c.getFace().equals("Ten") || c.getFace().equals("King") || c.getFace().equals("Queen")
          || c.getFace().equals("Jack")) {
        sum += 10;
      } else if (c.getFace().equals("Ace")) {
        if (sum + 11 <= 21 && !bigAce) {
          sum += 11;
          bigAce = true;
        } else {
          sum += 1;
        }
      }
    }
    
    if (sum > 21 && bigAce){
      sum -= 10;
    }

    return sum;
  }
}
