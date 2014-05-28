package org.leanpoker.player;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UtilTest
{
    @Test public void compareTest()
    {
        final Util fixture = new Util();
        Map<Integer, Integer> player = new HashMap<Integer, Integer>();

        player.put(new Integer(3), new Integer(1));
        player.put(new Integer(5), new Integer(1));
        Map<Integer, Integer> other = new HashMap<Integer, Integer>();

        other.put(new Integer(2), new Integer(1));
        other.put(new Integer(3), new Integer(1));
        other.put(new Integer(4), new Integer(1));
        double result = fixture.compare(player, other);

        org.junit.Assert.assertTrue(result > 0.5);
    }

    @Test public void sortTest() throws Exception
    {
        Util fixture = new Util();
        int[] input = { 100, 1, 3 };

        fixture.sort(input);
        assertEquals(1, input[0]);
        assertEquals(3, input[1]);
        assertEquals(100, input[2]);
    }
}
