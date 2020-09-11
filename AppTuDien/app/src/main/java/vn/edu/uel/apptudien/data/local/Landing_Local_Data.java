package vn.edu.uel.apptudien.data.local;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import vn.edu.uel.apptudien.model.Banner;
import vn.edu.uel.apptudien.model.Landing;

import static vn.edu.uel.apptudien.util.OwnLibrary.parseJSONToString;

public class Landing_Local_Data {
    Context context;
    Landing defLanding;

    public
    Landing_Local_Data(Context context) {
        this.context = context;
    }
    public Landing getLandingJson()
    {
        Gson gson = new Gson();
        Landing landing =null;


        FileInputStream fis = null;
        try {
            fis = context.openFileInput("landing.json");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            landing = gson.fromJson(sb.toString(), Landing.class);
            //mEditText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    if(landing!=null)
                        return landing;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return defLanding;
    }

    public Landing getDefLanding()
    {
        if(defLanding ==null)
        {
            Gson gson = new Gson();

            String json = parseJSONToString("landing.json",context);
            defLanding = gson.fromJson(json, Landing.class);

        }
        return defLanding;
    }
}
