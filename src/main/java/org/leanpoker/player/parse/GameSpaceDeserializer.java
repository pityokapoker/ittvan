package org.leanpoker.player.parse;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.leanpoker.player.obj.Card;
import org.leanpoker.player.obj.GameSpace;
import org.leanpoker.player.obj.PlayerObj;

import java.lang.reflect.Type;

import java.util.Arrays;

public class GameSpaceDeserializer implements JsonDeserializer<GameSpace>
{
    @Override public GameSpace deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GameSpace result = new GameSpace();
        final JsonObject jsonObject = json.getAsJsonObject();

        result.setSmallBlind(jsonObject.get("small_blind").getAsInt());
        result.setCurrentBuyIn(jsonObject.get("current_buy_in").getAsInt());
        result.setPot(jsonObject.get("pot").getAsInt());
        result.setMinimumRaise(jsonObject.get("minimum_raise").getAsInt());
        result.setDealer(jsonObject.get("dealer").getAsInt());
        result.setOrbits(jsonObject.get("orbits").getAsInt());
        result.setInAction(jsonObject.get("in_action").getAsInt());
        Card[] communityCards = context.deserialize(jsonObject.get("community_cards"), Card[].class);

        result.setCommunityCard(Arrays.asList(communityCards));
        PlayerObj[] players = context.deserialize(jsonObject.get("players"), PlayerObj[].class);

        result.setPlayers(Arrays.asList(players));

        return result;
    }
}
