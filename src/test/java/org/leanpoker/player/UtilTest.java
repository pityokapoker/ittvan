package org.leanpoker.player;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilTest
{
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
