package org.leanpoker.player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Util
{
    public Map<Integer, Integer> compare(final Map<Integer, Integer> player, final Map<Integer, Integer> other)
    {
        Map<Integer, Integer> retV = new HashMap<Integer, Integer>(player.size());

        for (Integer playerKey : player.keySet())
        {
            for (Integer otherKey : other.keySet())
            {
                final Integer otherValue = player.get(otherKey);

                if (playerKey > otherKey)
                {
                    final Integer current = player.get(playerKey);

                    retV.put(playerKey, current + otherValue);
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
