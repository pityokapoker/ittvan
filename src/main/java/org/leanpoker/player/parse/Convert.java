package org.leanpoker.player.parse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import org.leanpoker.player.obj.Card;
import org.leanpoker.player.obj.GameSpace;
import org.leanpoker.player.obj.PlayerObj;

public class Convert
{
    public static GameSpace getGameSpace(JsonElement jsonElement)
    {
        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(GameSpace.class, new GameSpaceDeserializer());
        gsonBuilder.registerTypeAdapter(Card.class, new CardDeserializer());
        gsonBuilder.registerTypeAdapter(PlayerObj.class, new PlayerDeserializer());
        Gson gson = gsonBuilder.create();

        return gson.fromJson(jsonElement, GameSpace.class);
    }
}
