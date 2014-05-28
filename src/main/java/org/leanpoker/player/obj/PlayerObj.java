package org.leanpoker.player.obj;

public class PlayerObj
{
    private int bet;
    private int id;
    private String name;
    private int stack;
    private Status status;
    private String version;

    public int getBet()
    {
        return bet;
    }

    public void setBet(int bet)
    {
        this.bet = bet;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getStack()
    {
        return stack;
    }

    public void setStack(int stack)
    {
        this.stack = stack;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }
}
