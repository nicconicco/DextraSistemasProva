package br.com.cng.dextrasistemasprova.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by nicolaugalves on 20/08/17.
 */

public class JSONUtils {

        public JSONUtils() {
        }

        public static String toJSON(Object obj) {
            return toJSON(obj, false);
        }

        public static String toJSON(Object obj, boolean prettyPrinting) {
            Gson gson = prettyPrinting?(new GsonBuilder()).setPrettyPrinting().create():new Gson();
            String json = gson.toJson(obj);
            return json;
        }

        public static String toJSON(Object obj, Type type) {
            Gson gson = new Gson();
            String json = gson.toJson(obj, type);
            return json;
        }

        public static <T> T fromJSON(String json, Class<? extends Object> classOfT) {
            Gson gson = new Gson();
            T obj = (T) gson.fromJson(json, classOfT);
            return obj;
        }

        public static <T> T fromJSON(String json, Type typeOfT) {
            Gson gson = new Gson();
            T obj = gson.fromJson(json, typeOfT);
            return obj;
        }
}
