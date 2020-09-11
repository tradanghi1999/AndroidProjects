package com.ungdunguel.appcbdoan.data.local;

import android.content.Context;

import com.google.gson.Gson;

import com.ungdunguel.appcbdoan.model.Landing;
import com.ungdunguel.appcbdoan.util.OwnLib;

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
