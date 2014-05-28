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

    public static int betRequest(JsonElement request)
    {
        int result = 0;
        GameSpace gameSpace = Convert.getGameSpace(request);
        List<Card> holeCards = new ArrayList<Card>();

        for (PlayerObj player : gameSpace.getPlayers())
        {
            if ((player.getHoleCards() != null) && !player.getHoleCards().isEmpty())
            {
                holeCards = player.getHoleCards();
            }
        }

        int[] sortedCards = Player.toArray((gameSpace.getCommunityCard() == null) ? new ArrayList<Card>() : gameSpace.getCommunityCard(),
                holeCards);

        util.sort(sortedCards);
        int rank = batman.getRealRank(sortedCards);

        if ((rank > 13) || ((rank > 10) && (gameSpace.getCommunityCard() != null) && gameSpace.getCommunityCard().isEmpty()))
        {
            result = gameSpace.getMinimumRaise();
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
