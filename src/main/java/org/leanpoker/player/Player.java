package org.leanpoker.player;

import com.google.gson.JsonElement;

import org.leanpoker.player.obj.GameSpace;
import org.leanpoker.player.parse.Convert;

public class Player
{
    static final String VERSION = "Royal Pityoka AI player";

    public static int betRequest(JsonElement request)
    {
        GameSpace gameSpace = Convert.getGameSpace(request);

        return 50;
    }

    public static void showdown(JsonElement game)
    {
    }
}
