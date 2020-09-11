package vn.edu.uel.apptudien.data.local;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import vn.edu.uel.apptudien.model.Group_Data;
import vn.edu.uel.apptudien.model.News;
import vn.edu.uel.apptudien.model.News_Data;

public class News_Local_Data {

    Context context;
    public News_Local_Data(Context context)
    {
        this.context = context;
    }
    public News[] getNewsRecords()
    {

        Gson gson = new Gson();
        News_Data news_data = null;

        FileInputStream fis = null;
        try {
            fis = context.openFileInput("news.json");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            news_data = gson.fromJson(sb.toString(), News_Data.class);
            //mEditText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    if(news_data!=null)
                        return news_data.records;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        Local_Data ilocal = new Local_Data() {
            @Override
            public String parseJSONToString() {
                String json = null;
                try {
                    InputStream is = context.getAssets().open("news.json");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    json = new String(buffer, "UTF-8");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    return null;
                }
                return json;
            }
        };

        news_data = gson.fromJson(ilocal.parseJSONToString(),  News_Data.class);
        return news_data.records;
    }
}
