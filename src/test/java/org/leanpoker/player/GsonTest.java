package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.junit.Test;
import org.leanpoker.player.obj.GameSpace;
import org.leanpoker.player.parse.Convert;

import java.io.FileReader;

public class GsonTest
{
    @Test public void testGson() throws Exception
    {
        final JsonParser parser = new JsonParser();
        final FileReader fileReader = new FileReader("d:\\temp\\gson1.txt");
        final JsonElement jsonElement = parser.parse(fileReader);
        GameSpace gameSpace = Convert.getGameSpace(jsonElement);

        System.out.println(gameSpace);
    }
}
