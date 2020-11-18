import java.util.*;
import java.text.*;

public class Foothill
{
    public static void main (String[] args)
    {
        CardNode p_cardNode;

        //testing the CardNode class
        CardNode cn1, cn2, cn3;
        cn1 = new CardNode(new Card('2', Card.Suit.clubs)); 
        cn2 = new CardNode(new Card('A', Card.Suit.spades));
        cn3 = new CardNode(new Card('J', Card.Suit.hearts));

        // link up our three CardNodes
        cn1.next = cn2;
        cn2.next = cn3; 

        System.out.println("Testing the CardNode class...");
        // show the Queue
        for ( p_cardNode = cn1; p_cardNode != null; p_cardNode = (CardNode)(p_cardNode.next))
        {
            System.out.print( p_cardNode + " ");
        }
        System.out.println();

        //testing the CardQueue class
        CardQueue q_card = new CardQueue();
        Card c;

        q_card.addCard(new Card('2', Card.Suit.clubs));
        q_card.addCard(new Card('3', Card.Suit.hearts));
        q_card.addCard(new Card('4', Card.Suit.diamonds));
        System.out.println("\nThe queue of cards contains: ");
        System.out.println(q_card.toString());
        
        System.out.println("\nNow removing 10 cards and showing the cards as they are "
                + "removed ...");
        for (int k = 0; k < 10; k++)
            try
            {
                p_cardNode = (CardNode)q_card.remove();
                System.out.print(p_cardNode + " ");
            }
            catch (QueueEmptyException e)
            {
                System.out.print("\nToo far. Queue is empty.");
            }
        System.out.println();
    }
}

//Class Node  ----------------------------------
class Node
{
 // data (protected allows only certain other classes to access "next" directly)
 protected Node next;
  
 // constructor
 public Node()
 {
    next = null;
 }
 
 // console display
 public String toString()
 {
     return  toString();
 }
}


class QueueEmptyException extends Exception
{
    public QueueEmptyException ()
    {
       super("PLEASE TELL ME THE EXCEPTION IS WORKING");
    }
}

//Class Queue ---------------------------------------
class Queue
{
 // pointer to first node in Queue
 private Node head;
 private Node tail;
 
 // constructor
 public Queue()
 {
    head = null;
    tail = null;
 }
 
 public void add(Node newNode) //becomes the new tail
 {   
     Node current = tail;
     if (newNode == null) 
         return;   // emergency return
     
     tail = newNode;
     if (head == null)
         head = tail;
     else
         current.next = newNode;
 }  
 
 public Node remove() throws QueueEmptyException//returns oldest item
 {
    Node temp;
   
    temp = head;
    if (head == null)
        throw new QueueEmptyException();
    else
    {
       head = head.next; 
       temp.next = null; // don't give client access to Queue!
    }
    return temp;      
 }
 

 // console display
 public String toString()
 {
     Node np;
     String retVal = "";
     if (head == null)
         retVal = "QUEUE IS EMPTY";
     // Display all the nodes in the Queue
     for( np = head; np != null; np = np.next )
     {
         retVal += np.toString() + " ";
     }
     return retVal;
 }
}
//CardNode class
class CardNode extends Node
{
   // additional data for subclass
   private Card ncard;
   
   // constructor
   public CardNode(Card user_card)
   {
      super();  // constructor call to base class or constructor chaining
      ncard= user_card;
   }
   
   // accessor
   public Card getCard()
   {
      return ncard;
   }

   // overriding toString()
   public String toString()
   {
      return ncard.toString();
   }
}

class CardQueue extends Queue
{
    public static final Card QUEUE_EMPTY = null;

   public void addCard(Card card)
   {
      // create a new CardNode
      CardNode n_card = new CardNode(card);
   
      // add the Node onto the Queue (base class call)
      super.add(n_card);
   }

   public Card removeCard() throws QueueEmptyException
   {
      // remove a node
      CardNode n_card = (CardNode)remove();
      if (n_card == null)
          return QUEUE_EMPTY;
          else
         return n_card.getCard();
    }
}

class Card
{   
    // type and constants
    public enum Suit { clubs, diamonds, hearts, spades };

    static final char DEFAULT_VAL = 'A';
    static final Suit DEFAULT_SUIT = Suit.spades;

    // private data
    private char value;
    private Suit suit;
    private boolean errorFlag;

    // 4 overloaded constructors
    public Card(char value, Suit suit)
    {   // because mutator sets errorFlag, we don't have to test
        set(value, suit);
    }

    public Card(char value)
    {
        this(value, DEFAULT_SUIT);
    }

    public Card()
    {
        this(DEFAULT_VAL, DEFAULT_SUIT);
    }

    // copy constructor
    public Card(Card card)
    {
        this(card.value, card.suit);
    }

    // mutators
    public boolean set(char value, Suit suit)
    {
        char upVal;  // for upcasing char

        // convert to uppercase to simplify
        upVal = Character.toUpperCase(value);

        if ( !isValid(upVal, suit))
        {
            errorFlag = true;
            return false;
        }

        // else implied
        errorFlag = false;
        this.value = upVal;
        this.suit = suit;
        return true;
    }

    // accessors
    public char getVal()
    {
        return value;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public boolean getErrorFlag()
    {
        return errorFlag;
    }

    // stringizer
    public String toString()
    {
        String retVal;

        if (errorFlag)
            return "** illegal **";

        // else implied
        retVal =  String.valueOf(value);
        retVal += " of ";
        retVal += String.valueOf(suit);

        return retVal;
    }

    // helper
    private static boolean isValid(char value, Suit suit)
    {
        // don't need to test suit (enum), but leave in for clarity
        char upVal;  // string to hold the 1-char value
        String legalVals = "23456789TJQKA";

        // convert to uppercase to simplify (need #include <cctype>)
        upVal = Character.toUpperCase(value);

        // check for validity
        if ( legalVals.indexOf(upVal) >= 0 )
            return true;
        else
            return false;
    }

    public boolean equals(Card card)
    {
        if (this.value != card.value)
            return false;
        if (this.suit != card.suit)
            return false;
        if (this.errorFlag != card.errorFlag)
            return false;
        return true;
    }

}


/*********************CONSOLE OUTPUT*********************************************
Testing the CardNode class...
2 of clubs A of spades J of hearts 

The queue of cards contains: 
2 of clubs 3 of hearts 4 of diamonds 

Now removing 10 cards and showing the cards as they are removed ...
2 of clubs 3 of hearts 4 of diamonds 
Too far. Queue is empty.
Too far. Queue is empty.
Too far. Queue is empty.
Too far. Queue is empty.
Too far. Queue is empty.
Too far. Queue is empty.
Too far. Queue is empty.


 */





