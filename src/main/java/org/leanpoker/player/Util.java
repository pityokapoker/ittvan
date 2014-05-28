package org.leanpoker.player;

import org.leanpoker.player.obj.GameSpace;
import org.leanpoker.player.obj.PlayerObj;

import java.util.Arrays;

public class Util
{
    public static PlayerObj getBatman(GameSpace gameSpace)
    {
        PlayerObj result = null;

        for (PlayerObj player : gameSpace.getPlayers())
        {
            if ((player.getHoleCards() != null) && !player.getHoleCards().isEmpty())
            {
                result = player;

                break;
            }
        }

        return result;
    }

    public int[] sort(final int[] input)
    {
        Arrays.sort(input);

        return input;
    }
}
