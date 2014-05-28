package org.leanpoker.player.obj;

public class Card
{
    public enum Suit
    {
        clubs,
        spades,
        hearts,
        diamonds
    }

    private String rank;
    private Suit suit;
    private int value;

    public Card(String rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
        //vaule kiszámítás
    }

    public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public void setSuit(Suit suit)
    {
        this.suit = suit;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}
