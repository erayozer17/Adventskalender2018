package com.ozer.eray.adventskalender2018;

import android.content.Context;
import android.support.annotation.Nullable;

import org.json.JSONObject;

import java.io.InputStream;

class JsonHelper {

    Context context;

    public JsonHelper(){}

    public JsonHelper(Context context){
        this.context = context;
    }

    @Nullable
    private String loadJSONFromAsset(){
        String json;
        try {
            InputStream is = context.getAssets().open("properties.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int isRead = is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public String gettingMesaj(int gun){
        try{
            JSONObject reader = new JSONObject(loadJSONFromAsset());
            return reader.getString(Integer.toString(gun));
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
