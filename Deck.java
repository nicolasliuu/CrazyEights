/*
 * @author Gateway Instructors
 * @version 1.0
 */

import java.util.Collections;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents a standard deck (52 playing cards).
 */
public class Deck extends CardCollection {

   /**
    * Create a new full standard playing card deck that contains
    * 52 cards in standard order, using the generic label "Deck".
    */
   public Deck() {

      // initializes the deck of cards
      super("Deck");

      // can also make the loop without making new suit and ranks arrays.

      // creates a full deck of cards in standard order
      int[] suits = {1, 2, 3, 4};
      int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

      for (int i = 0; i < suits.length; i++) {
         for (int j = 0; j < ranks.length; j++) {
            this.cards[numFilled] = new Card(ranks[j], suits[i]);
            numFilled++;
         }
      }

   }
   
   
   /**
    * Create a new full standard playing card deck that contains
    * 52 cards in standard order, using the specified label.
    * @param label the label used to name this deck
    */
   public Deck(String label) {

      // initializes the list of cards
      super(label);

      // is it easier to do super(label); 

      // creates a full deck of cards in standard order
      int[] suits = {1, 2, 3, 4};
      int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

      for (int i = 0; i < suits.length; i++) {
         for (int j = 0; j < ranks.length; j++) {
            this.cards[numFilled] = new Card(ranks[j], suits[i]);
            numFilled++;
         }
      }

   }


   /**
    * Randomly permute the cards in this deck, leaving out nulls.
    */
   public void shuffle() {

      // Create a right-sized version of Cards array to avoid shuffling
      // in the nulls that might exist at the end of our Cards array
      Card[] rightSized = new Card[numFilled];
      System.arraycopy(this.cards, 0, rightSized, 0, numFilled);      

      List<Card> list = Arrays.asList(rightSized);
      Collections.shuffle(list);
      System.arraycopy(list.toArray(), 0, this.cards, 0, numFilled);
      
   }
   
}
