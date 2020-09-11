package vn.edu.uel.realdevice.data.local;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import vn.edu.uel.realdevice.model.Banner;

public class Banner_Local_Data {
    Context context;

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
        return null;
    }
}
