package org.leanpoker.player.obj;

import java.util.List;

public class GameSpace
{
    private List<Card> communityCard;
    private int currentBuyIn;
    private int dealer;
    private int inAction;
    private int minimumRaise;
    private int orbits;
    private List<PlayerObj> players;
    private int pot;
    private int smallBlind;

    public List<Card> getCommunityCard()
    {
        return communityCard;
    }

    public void setCommunityCard(List<Card> communityCard)
    {
        this.communityCard = communityCard;
    }

    public int getCurrentBuyIn()
    {
        return currentBuyIn;
    }

    public void setCurrentBuyIn(int currentBuyIn)
    {
        this.currentBuyIn = currentBuyIn;
    }

    public int getDealer()
    {
        return dealer;
    }

    public void setDealer(int dealer)
    {
        this.dealer = dealer;
    }

    public int getInAction()
    {
        return inAction;
    }

    public void setInAction(int inAction)
    {
        this.inAction = inAction;
    }

    public int getMinimumRaise()
    {
        return minimumRaise;
    }

    public void setMinimumRaise(int minimumRaise)
    {
        this.minimumRaise = minimumRaise;
    }

    public int getOrbits()
    {
        return orbits;
    }

    public void setOrbits(int orbits)
    {
        this.orbits = orbits;
    }

    public List<PlayerObj> getPlayers()
    {
        return players;
    }

    public void setPlayers(List<PlayerObj> players)
    {
        this.players = players;
    }

    public int getPot()
    {
        return pot;
    }

    public void setPot(int pot)
    {
        this.pot = pot;
    }

    public int getSmallBlind()
    {
        return smallBlind;
    }

    public void setSmallBlind(int smallBlind)
    {
        this.smallBlind = smallBlind;
    }

    @Override public String toString()
    {
        return "GameSpace [communityCard=" + communityCard + ", currentBuyIn=" + currentBuyIn + ", dealer=" + dealer + ", inAction="
              + inAction + ", minimumRaise=" + minimumRaise + ", orbits=" + orbits + ", players=" + players + ", pot=" + pot
              + ", smallBlind=" + smallBlind + "]";
    }
}
