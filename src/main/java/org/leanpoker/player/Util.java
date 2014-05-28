package org.leanpoker.player;

import java.util.Arrays;
import java.util.Map;

public class Util
{
    public int compare(final Map<Integer, Integer> player, final Map<Integer, Integer> other)
    {
        int retV = 0;
        int playerSum = 0;
        int otherSum = 0;

        for (Integer playerKey : player.keySet())
        {
            Integer playerValue = player.get(playerKey);

            playerSum += playerValue;
            for (Integer otherKey : other.keySet())
            {
                Integer otherValue = other.get(otherKey);

                otherSum += otherValue;
                if (playerKey > otherKey)
                {
                    retV = retV + (playerValue * otherValue);
                }
                else if (playerKey == otherKey)
                {
                    retV = retV + (playerValue * otherValue / 2);
                }
            }
        }

        return retV / (playerSum * otherSum);
    }

    public int[] sort(final int... input)
    {
        Arrays.sort(input);

        return input;
    }
}
