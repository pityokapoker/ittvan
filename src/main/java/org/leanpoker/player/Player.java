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
    private static Util util = new Util();
    private static Batman batman = new Batman();

    public static boolean isHigh(String figure)
    {
        return figure.equals("A") || figure.equals("J") || figure.equals("K") || figure.equals("Q");
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
                System.err.println(" ABC2 " + player.getId() + " " + player.getName());
                pokerPlayer = player;
            }
        }

        int[] sortedCards = Player.toArray((gameSpace.getCommunityCard() == null) ? new ArrayList<Card>() : gameSpace.getCommunityCard(),
                holeCards);

        util.sort(sortedCards);
        int rank = batman.getRealRank(sortedCards);
        boolean preflop = (gameSpace.getCommunityCard() != null) && gameSpace.getCommunityCard().isEmpty();

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

        if (!preflop && (rank > 23))
        {
            result = pokerPlayer.getStack();
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
