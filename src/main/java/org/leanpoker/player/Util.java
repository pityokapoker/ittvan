package org.leanpoker.player;

import java.util.Arrays;
import java.util.Map;

public class Util
{
    public int compare(final Map<Integer, Integer> player, final Map<Integer, Integer> other)
    {
        int retV = 0;

        for (Integer playerKey : player.keySet())
        {
            Integer playerValue = player.get(playerKey);

            for (Integer otherKey : other.keySet())
            {
                if (playerKey > otherKey)
                {
                    retV = retV + (playerValue * other.get(otherKey));
                }
            }
        }

        return retV;
    }

    public int[] sort(final int[] input)
    {
        Arrays.sort(input);

        return input;
    }
}
