package com.projeto.sumula.sumulaeletronica.util;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.projeto.sumula.sumulaeletronica.model.Clube;

import java.lang.reflect.Type;

/**
 * Created by Pedro on 29/09/2016.
 */

public class ClubeDes implements JsonDeserializer<Clube> {

    @Override
    public Clube deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonElement clube = json.getAsJsonObject();

        if ( json.getAsJsonObject().get("clube") != null ) {
            clube = json.getAsJsonObject();
        }
        return new Gson().fromJson(clube, Clube.class);
    }
}
