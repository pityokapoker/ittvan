package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.junit.Test;

import org.leanpoker.player.obj.GameSpace;
import org.leanpoker.player.parse.Convert;

import java.io.InputStreamReader;
import java.io.Reader;

public class GsonTest
{
    private static final String TEST_JSON = "../../../../../resources/test/test.json";

    @Test public void testGson() throws Exception
    {
        final JsonParser parser = new JsonParser();
        final Reader reader = new InputStreamReader(this.getClass().getResourceAsStream(TEST_JSON));
        final JsonElement jsonElement = parser.parse(reader);
        GameSpace gameSpace = Convert.getGameSpace(jsonElement);

        System.out.println(gameSpace);
    }
}
