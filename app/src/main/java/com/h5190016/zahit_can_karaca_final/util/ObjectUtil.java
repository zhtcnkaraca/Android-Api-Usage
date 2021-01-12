package com.h5190016.zahit_can_karaca_final.util;

import com.google.gson.Gson;
import com.h5190016.zahit_can_karaca_final.model.BilesenModel;

public class ObjectUtil {
    public  static String bilesenToJsonString(BilesenModel bilesenModel)
    {
        Gson gson = new Gson();
        return gson.toJson(bilesenModel);
    }
    public  static BilesenModel jsonStringToBilesen(String jsonString)
    {
        Gson gson = new Gson();
        return gson.fromJson(jsonString,BilesenModel.class);
    }
}