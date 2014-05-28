package org.leanpoker.player;

import com.google.gson.JsonElement;

import org.leanpoker.player.obj.Card;
import org.leanpoker.player.obj.GameSpace;
import org.leanpoker.player.obj.PlayerObj;
import org.leanpoker.player.parse.Convert;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    static final String VERSION = "Royal Pityoka AI player";
    private final static String PLAYER_SHORTY = "Get Shorty";
    private static Util util = new Util();
    private static Batman batman = new Batman();

    public static boolean isHigh(String figure)
    {
        return figure.equals("A") || figure.equals("J") || figure.equals("K") || figure.equals("Q") || figure.equals("10")
              || figure.equals("T");
    }

    public static boolean isPlayerAllIn(GameSpace gameSpace, String strPlayer)
    {
        boolean result = false;
        PlayerObj player = getPlayerByName(gameSpace, strPlayer);

        if (player == null)
        {
            System.err.println("user cannot be found by name");
        }
        else
        {
            result = (player.getBet() > 0) && (player.getStack() == 0);
        }

        return result;
    }

    public static PlayerObj getPlayerByName(GameSpace gameSpace, String name)
    {
        PlayerObj result = null;

        for (PlayerObj player : gameSpace.getPlayers())
        {
            if (player.getName().equalsIgnoreCase(name))
            {
                return player;
            }
        }

        return result;
    }

    public static int betRequest(JsonElement request)
    {
        int result = 0;
        GameSpace gameSpace = Convert.getGameSpace(request);
        List<Card> holeCards = new ArrayList<Card>();
        PlayerObj pokerPlayer = null;

        for (PlayerObj player : gameSpace.getPlayers())
        {
            if ((player.getHoleCards() != null) && !player.getHoleCards().isEmpty())
            {
                holeCards = player.getHoleCards();
                System.err.println("PLAYER " + player.getId() + " " + player.getName());
                pokerPlayer = player;
            }
        }

        int[] sortedCards = Player.toArray((gameSpace.getCommunityCard() == null) ? new ArrayList<Card>() : gameSpace.getCommunityCard(),
                holeCards);

        util.sort(sortedCards);
        int rank = batman.getRealRank(sortedCards);
        boolean preflop = (gameSpace.getCommunityCard() != null) && gameSpace.getCommunityCard().isEmpty();
        int winRate = 0;

        if (!preflop)
        {
            int[] commonCards = Player.toArray((gameSpace.getCommunityCard() == null) ? new ArrayList<Card>()
                                                                                      : gameSpace.getCommunityCard(),
                    new ArrayList<Card>());
            int[] arrHoleCards = Player.toArray(new ArrayList<Card>(), holeCards);

            winRate = batman.getWinRate(arrHoleCards, commonCards);
        }

        if (winRate == 0)
        {
            if ((rank > 13) || (isHigh(holeCards.get(0).getRank()) && isHigh(holeCards.get(1).getRank()) && preflop))
            {
                if ((gameSpace.getSmallBlind() * 6) > gameSpace.getMinimumRaise())
                {
                    result = gameSpace.getMinimumRaise();
                }
                else
                {
                    result = 3 * gameSpace.getMinimumRaise();
                }
            }

            if (preflop && (rank > 20))
            {
                result = pokerPlayer.getStack();
            }

            if ((result == 0) && preflop && (gameSpace.getSmallBlind() >= gameSpace.getCurrentBuyIn()))
            {
                result = gameSpace.getCurrentBuyIn();
            }

//            if (preflop && ((gameSpace.getSmallBlind() * 6) > pokerPlayer.getStack()) && (rank > 12))
//            {
//                result = pokerPlayer.getStack();
//            }
        }
        else
        {
            if (winRate >= 13)
            {
                result = gameSpace.getSmallBlind() * 6;
            }
            else if (winRate >= 25)
            {
                result = pokerPlayer.getStack();
            }

            if ((gameSpace.getCommunityCard().size() == 5) && (result == 0) && (gameSpace.getCurrentBuyIn() == 0))
            {
                result = gameSpace.getSmallBlind();
            }
        }

        return result;
    }

    public static void showdown(JsonElement game)
    {
    }

    private static int[] toArray(List<Card> community, List<Card> hole)
    {
        int[] result = new int[community.size() + hole.size()];
        int i = 0;

        for (Card comm : community)
        {
            result[i++] = comm.getValue();
        }

        for (Card comm : hole)
        {
            result[i++] = comm.getValue();
        }

        return result;
    }
}
