package CardGame;

/**
 * Name: Juliette Nguyen
 * Date: 17/3/26
 * Period: 3
 *
 * CardGame.Card.java
 *
 * Represents a Card with a face and a suit.
 */

public class Card
{
    private String face;
    private String suit;


    /**
     * Constructor: Sets the face and suit of the card.
     */
    public Card (String cardFace, String cardSuit)
    {
        face = cardFace;
        suit = cardSuit;
    }

    /**
     * Returns a String representation of this Card.
     */
    public String toString()
    {
        return face + " of " + suit;    
    }

    /**
     * Returns the face of this Card.
     */
    public String getFace() {
        return face;
    }
    
    /**
     * Returns the suit of this Card.
     */
    public String getSuit() {
        return suit;
    }
}
