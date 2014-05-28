package org.leanpoker.player;

import org.leanpoker.player.obj.GameSpace;
import org.leanpoker.player.obj.PlayerObj;

import java.util.Arrays;
import java.util.Map;

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

    public double compare(final Map<Integer, Integer> player, final Map<Integer, Integer> other)
    {
        int retV = 0;
        int sum = 0;

        for (Integer playerKey : player.keySet())
        {
            Integer playerValue = player.get(playerKey);

            for (Integer otherKey : other.keySet())
            {
                Integer otherValue = other.get(otherKey);

                sum = sum + (playerValue * otherValue);
                if (playerKey > otherKey)
                {
                    retV = retV + (playerValue * otherValue);
                }
                else if (playerKey == otherKey)
                {
                    retV = retV + ((playerValue * otherValue) / 2);
                }
            }
        }

        return ((double) retV) / sum;
    }

    public int[] sort(final int[] input)
    {
        Arrays.sort(input);

        return input;
    }
}
