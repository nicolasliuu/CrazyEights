/*
 * @author Gateway Instructors
 * @version 1.0
 */

import java.util.Scanner;

/**
 * This class represents a human player (user) in a game of Crazy Eights.
 */
public class User extends Player {

   /** Message to print when prompting User to enter Card number. */
   public static final String SELECT_CARD_FROM_HAND_PROMPT =
      "Select a card from your hand or enter 0 to draw a new card:  ";

   /** Message to print when user selects a Card that is not playable. */
   public static final String CARD_DOES_NOT_MATCH_MESSAGE =
      "\n--- This card is not a match!\n\n";
      
   /** Message to print when user attempts to draw a Card, but is already
       holding a playable Card in their hand. */
   public static final String NO_DRAW_IF_HAVE_PLAYABLE_CARD_MESSAGE =
      "\n--- Hand contains playable card, so you may not draw " +
      "from draw pile!\n\n";

   /** Scanner used to read user's input. */
   private Scanner input;

   /** 
    * Create a new human player with the specified name and an empty hand.
    * @param theName the name of the human player
    * @param in the Scanner to use to collect input from the user
    */
   public User(String theName, Scanner in) {
      super(theName);
      input = in;
   }


   /**
    * Allow the user to make a move (take one turn). If user's hand
    * contains a playable card, they must select a card from their hand 
    * and "play" it to end their move. If no card currently in the user's
    * hand is playable, then they must draw from the drawpile until a
    * playable card is drawn, and "play" that one. Makes use of named
    * constants above to match expected message formatting.
    * @param crazyEight gives access to the "draw pile"
    * @param top the top of the "discard pile"
    * @return the card played by the user
    */
   public Card makeMove(Game crazyEight, Card top) {
      Card card = null;
      boolean loop = true;
      int cardNum;

      while (loop) {
         System.out.print(SELECT_CARD_FROM_HAND_PROMPT);
         cardNum = input.nextInt();
         if (cardNum < 0 || cardNum > hand.size()) {
            continue;
         }
         if (!hasPlayableCard(top) && cardNum == 0) {
            card = crazyEight.draw();
            hand.addCard(card);
            System.out.println("*** " + name + " draws " + card);
            System.out.print(getHand());
            continue;
         }
         if (hasPlayableCard(top) && cardNum == 0) {
            System.out.print(NO_DRAW_IF_HAVE_PLAYABLE_CARD_MESSAGE);
            continue;
         }
         card = hand.getCard(cardNum - 1);
         if (hasPlayableCard(top) && Game.cardMatches(card, top)) {
            return hand.discard(cardNum - 1);
         }
         else if (hasPlayableCard(top) && !Game.cardMatches(card, top)) {
            System.out.print(CARD_DOES_NOT_MATCH_MESSAGE);
         }
      }

      return card; 

   }

}
