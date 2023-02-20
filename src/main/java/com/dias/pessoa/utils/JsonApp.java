package com.dias.pessoa.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import java.lang.reflect.Type;

public class JsonApp {
    public JsonApp() {
    }

    public static String toJson(Object requestObject) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.sssXXX");
        Gson gson = gsonBuilder.create();
        return gson.toJson(requestObject);
    }

    public static <T> T fromJson(String json, Type typeToken) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE);
        Gson gson = gsonBuilder.create();

        try {
            return gson.fromJson(json, typeToken);
        } catch (JsonSyntaxException var5) {
            return null;
        }
    }
}