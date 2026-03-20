package CardGame;

public class Hand {
  private Card[] hand;
  private String owner;

  public Hand(Card c1, Card c2, String name){
    hand = new Card[2];
    hand[0] = c1;
    hand[1] = c2;
    owner = name;
  }

  public void hit(Card newCard){
    Card[] temp = new Card[hand.length];
    for (int i = 0; i <  hand.length; i++) {
      temp[i] =  hand[i];
    }

    hand = new Card[temp.length+1];
    for (int i = 0; i < temp.length; i++) {
      hand[i] = temp[i];
    }

     hand[hand.length-1] = newCard;
  }

  public Card[] getHand(){
    return hand;
  }

  public String toString(){
    String handOut = "";
    for (int i = 0; i < hand.length; i++){
      handOut += hand[i] + " "
    }
    return owner + "'s hand:\n" + handOut;
  }

  public int getHandValue(){
    int sum = 0;
    for(Card c : hand){
      if c.getName()
    }
  }
}
