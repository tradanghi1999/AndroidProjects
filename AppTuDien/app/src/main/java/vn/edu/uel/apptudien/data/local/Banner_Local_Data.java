package vn.edu.uel.apptudien.data.local;

import android.content.Context;
import android.graphics.Bitmap;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import vn.edu.uel.apptudien.model.Banner;
import vn.edu.uel.apptudien.model.Group_Data;

import static vn.edu.uel.apptudien.util.OwnLibrary.parseJSONToString;

public class Banner_Local_Data {
    Context context;
    private static Banner defBanner;

    public
    Banner_Local_Data(Context context) {
        this.context = context;
    }
    public Banner getBannerJson()
    {
        Gson gson = new Gson();
        Banner banner =null;


        FileInputStream fis = null;
        try {
            fis = context.openFileInput("banner.json");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            banner = gson.fromJson(sb.toString(), Banner.class);
            //mEditText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    if(banner!=null)
                        return banner;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return getDefBanner();
    }
    public Banner getDefBanner()
    {
        if(defBanner ==null)
        {
            Gson gson = new Gson();

            String json = parseJSONToString("banner.json",context);
            defBanner = gson.fromJson(json, Banner.class);

        }
        return defBanner;
    }
}
