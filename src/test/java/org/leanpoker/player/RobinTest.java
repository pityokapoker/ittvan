package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.junit.Assert;
import org.junit.Test;

import org.leanpoker.player.obj.GameSpace;
import org.leanpoker.player.parse.Convert;

import java.io.InputStreamReader;
import java.io.Reader;

public class RobinTest
{
    @Test public void testBet() throws Exception
    {
        final JsonParser parser = new JsonParser();
//        final FileReader reader = new FileReader("d:\\temp\\gson1.txt");
        final Reader reader = new InputStreamReader(this.getClass().getResourceAsStream(GsonTest.TEST_JSON));
        final JsonElement jsonElement = parser.parse(reader);
        GameSpace gameSpace = Convert.getGameSpace(jsonElement);
        int bet = Robin.getBet(0.2, gameSpace);

        Assert.assertEquals(0, bet);
        bet = Robin.getBet(0.3, gameSpace);
        Assert.assertEquals(0, bet);
        bet = Robin.getBet(0.4, gameSpace);
        Assert.assertEquals(0, bet);
        bet = Robin.getBet(0.5, gameSpace);
        Assert.assertEquals(0, bet);
        bet = Robin.getBet(0.6, gameSpace);
        Assert.assertEquals(240, bet);
        bet = Robin.getBet(0.7, gameSpace);
        Assert.assertEquals(240, bet);
        bet = Robin.getBet(0.8, gameSpace);
        Assert.assertEquals(264, bet);
        bet = Robin.getBet(0.9, gameSpace);
        Assert.assertEquals(264, bet);
    }
}
