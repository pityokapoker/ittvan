package org.leanpoker.player.parse;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.leanpoker.player.obj.Card;
import org.leanpoker.player.obj.PlayerObj;
import org.leanpoker.player.obj.PlayerObj.Status;

import java.lang.reflect.Type;

import java.util.Arrays;

public class PlayerDeserializer implements JsonDeserializer<PlayerObj>
{
    @Override public PlayerObj deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        PlayerObj result = new PlayerObj();
        final JsonObject jsonObject = json.getAsJsonObject();

        result.setId(jsonObject.get("id").getAsInt());
        result.setName(jsonObject.get("name").getAsString());
        result.setStatus(Status.valueOf(jsonObject.get("status").getAsString()));
        result.setVersion(jsonObject.get("version").getAsString());
        result.setStack(jsonObject.get("stack").getAsInt());
        result.setBet(jsonObject.get("bet").getAsInt());
        Card[] holeCards = context.deserialize(jsonObject.get("hole_cards"), Card[].class);

        if (holeCards != null)
        {
            result.setHoleCards(Arrays.asList(holeCards));
        }

        return result;
    }
}
