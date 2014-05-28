package org.leanpoker.player;

import com.google.gson.JsonElement;

import org.leanpoker.player.obj.Card;

public class PokerPlayer
{
    private int bet;
    private Card closedCard1;
    private Card closedCard2;
    private Card flop1;
    private Card flop2;
    private Card flop3;
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
        int cardValue1 = getValue(closedCard1.getRank());
        int cardValue2 = getValue(closedCard2.getRank());
        boolean hasHighPair = (cardValue1 == cardValue2) && (cardValue1 > 0);
        boolean hasAk = (cardValue1 + cardValue2) >= 21;

        if (hasHighPair || hasAk)
        {
            result = money;
        }

        return result;
    }

    public int betRequest(final JsonElement request)
    {
        return 50;
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
