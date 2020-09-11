package com.ungdunguel.appphapluat.data.local;

import android.content.Context;

import com.google.gson.Gson;

import com.ungdunguel.appphapluat.model.Landing;
import com.ungdunguel.appphapluat.util.OwnLib;

public class Landing_Local_Data {
    Context context;
    static Landing defLanding;

    public Landing_Local_Data(Context context) {
        this.context = context;
    }
    public static Landing getDefLanding(Context context)
    {
        if(defLanding ==null)
        {
            Gson gson = new Gson();

            String json = OwnLib.parseJSONToString("landing.json",context);
            defLanding = gson.fromJson(json, Landing.class);

        }
        return defLanding;
    }

}
