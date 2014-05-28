package org.leanpoker.player.parse;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.leanpoker.player.obj.Card;
import org.leanpoker.player.obj.Card.Suit;

import java.lang.reflect.Type;

public class CardDeserializer implements JsonDeserializer<Card>
{
    @Override public Card deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        final JsonObject jsonObject = json.getAsJsonObject();
        String rank = jsonObject.get("rank").getAsString();
        Suit suit = Suit.valueOf(jsonObject.get("suit").getAsString());

        return new Card(rank, suit);
    }
}
