import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class DeckTest {

    private Deck deck;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void deckStartsEmpty() {
      assertEquals(0, deck.getNumberOfCards());
    }

    @Test
    public void canPopulateDeck() {
      deck.populateDeck();
      assertEquals(52, deck.getNumberOfCards());
    }

    @Test
    public void canDealFromDeck(){
        deck.populateDeck();
        deck.dealCard();
        assertEquals(51, deck.getNumberOfCards());
    }

    @Test
    public void canDealTop(){
      Card card = new Card(SuitType.HEARTS, RankType.ACE);
      deck.populateDeck();
      Card dealtCard = deck.dealCard();
      assertEquals(card.getSuit(), dealtCard.getSuit());
      assertEquals(card.getRank(), dealtCard.getRank());
    }

    @Test
    public void canShuffle(){
      Card card = new Card(SuitType.HEARTS, RankType.ACE);
      deck.populateDeck();
      deck.shuffleDeck();
      assertNotSame(card, deck.dealCard());
    }

}
