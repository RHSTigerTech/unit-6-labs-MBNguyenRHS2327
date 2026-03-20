package CardGame;

public class Hand {
  private Card[] hand;

  public Hand(Card c1, Card c2){
    this.hand = new Card[2];
    this.hand[0] = c1;
    this.hand[1] = c2;
  }

  public void hit(Card newCard){
    Card[] temp = new Card[this.hand.length];
    for (int i = 0; i < this.hand.length; i++) {
      temp[i] = this.hand[i];
    }

    this.hand = new Card[temp.length+1];
    for (int i = 0; i < temp.length; i++) {
      this.hand[i] = temp[i];
    }

    this.hand[this.hand.length-1] = newCard;
  }
}
