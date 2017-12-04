package com.pavser.easyblog.backend;

import com.google.gson.Gson;

public class JsonUtils {

    private static class GsonHolder{
        static Gson instance;

        public static Gson getInstance(){
            if (instance == null) {
                instance = new Gson();
            }
            return instance;
        }
    }

    public static <T> String toJson (T object){
        return GsonHolder.getInstance().toJson(object);
    }

    public static <T> T fromJson (String json, Class<T> clazz){
        return GsonHolder.getInstance().fromJson(json, clazz);
    }
}
