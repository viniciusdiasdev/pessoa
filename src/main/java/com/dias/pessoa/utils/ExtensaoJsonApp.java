package com.dias.pessoa.utils;

import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class ExtensaoJsonApp {

    public String toJson(Object requestObject){
        return JsonApp.toJson(requestObject);
    }
    public <T> T fromJson(String json, Type typeToken){
        return JsonApp.fromJson(json, typeToken);
    }
}
