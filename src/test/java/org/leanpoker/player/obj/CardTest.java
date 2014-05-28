package org.leanpoker.player.obj;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.leanpoker.player.obj.Card.Suit;

public class CardTest
{
    @Test public void testClubs2() throws Exception
    {
        Card card = new Card("2", Suit.clubs);

        assertEquals(0, card.getValue());
    }

    @Test public void testDiamond2() throws Exception
    {
        Card card = new Card("2", Suit.diamonds);

        assertEquals(1, card.getValue());
    }

    @Test public void testHearts2() throws Exception
    {
        Card card = new Card("2", Suit.hearts);

        assertEquals(2, card.getValue());
    }

    @Test public void testSpades2() throws Exception
    {
        Card card = new Card("2", Suit.spades);

        assertEquals(3, card.getValue());
    }
}
