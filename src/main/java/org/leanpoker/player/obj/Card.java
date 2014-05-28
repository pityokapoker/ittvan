package org.leanpoker.player.obj;

public class Card
{
    public enum Suit
    {
        clubs(0),
        spades(1),
        hearts(2),
        diamonds(3);
        public final int value;

        Suit(int value)
        {
            this.value = value;
        }
    }

    private final String rank;
    private final Suit suit;
    private final int value;

    public Card(String rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
        value = compute();
    }

    public String getRank()
    {
        return rank;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public int getValue()
    {
        return value;
    }

    int compute()
    {
        int intRank;

        if ("J".equals(rank))
        {
            intRank = 11;
        }
        else if ("Q".equals(rank))
        {
            intRank = 12;
        }
        else if ("K".equals(rank))
        {
            intRank = 13;
        }
        else if ("A".equals(rank))
        {
            intRank = 14;
        }
        else
        {
            intRank = Integer.valueOf(rank);
        }

        intRank = intRank - 2;

        return suit.value + (intRank << 2);
    }
}
