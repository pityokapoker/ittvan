package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStreamReader;
import java.io.Reader;

public class GsonTest
{
    public static final String TEST_JSON = "../../../../../resources/test/test.json";

    @Test public void testGson() throws Exception
    {
        final JsonParser parser = new JsonParser();
        final Reader reader = new InputStreamReader(this.getClass().getResourceAsStream(TEST_JSON));
        final JsonElement jsonElement = parser.parse(reader);

        Assert.assertTrue(0 < Player.betRequest(jsonElement));
    }
}
