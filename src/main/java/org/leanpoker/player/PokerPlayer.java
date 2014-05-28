package org.leanpoker.player;

import org.leanpoker.player.obj.Card;

import java.util.List;

public class PokerPlayer
{
    public final static String VERSION = "Royal Pityoka 1.0";
    private int bet;
    private Card flop1;
    private Card flop2;
    private Card flop3;
    private List<Card> holeCards;
    private int money;
    private int river;
    private int turn;

    public int getBet()
    {
        return bet;
    }

    public void setBet(int bet)
    {
        this.bet = bet;
    }

    public List<Card> getHoleCards()
    {
        return holeCards;
    }

    public void setHoleCards(List<Card> holeCards)
    {
        this.holeCards = holeCards;
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public int getRiver()
    {
        return river;
    }

    public void setRiver(int river)
    {
        this.river = river;
    }

    public int getTurn()
    {
        return turn;
    }

    public void setTurn(int turn)
    {
        this.turn = turn;
    }

    public int betRequest()
    {
        int result = 0;
        int cardValue1 = holeCards.get(0).getValue();
        int cardValue2 = holeCards.get(1).getValue();
        boolean hasHighPair = (cardValue1 == cardValue2) && (cardValue1 > 11);
        boolean hasAk = (cardValue1 + cardValue2) >= 27;

        if (hasHighPair || hasAk)
        {
            result = money;
        }

        return result;
    }

    private int getValue(String a)
    {
        if (a.equalsIgnoreCase("a"))
        {
            return 11;
        }

        if (a.equalsIgnoreCase("k"))
        {
            return 10;
        }

        if (a.equalsIgnoreCase("q"))
        {
            return 9;
        }

        if (a.equalsIgnoreCase("j"))
        {
            return 8;
        }

        return 0;
    }
}
