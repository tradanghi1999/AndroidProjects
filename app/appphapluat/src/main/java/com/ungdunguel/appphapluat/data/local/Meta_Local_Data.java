package com.ungdunguel.appphapluat.data.local;

import android.content.Context;

import com.google.gson.Gson;
import com.ungdunguel.appphapluat.model.Metadata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Meta_Local_Data {
    Context context;

    public Meta_Local_Data(Context context) {
        this.context = context;
    }
    public Metadata getLocalMeta()
    {
        Gson gson = new Gson();
        Metadata meta_data =null;

        FileInputStream fis = null;
        try {
            fis = context.openFileInput("meta_data.json");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            meta_data = gson.fromJson(sb.toString(), Metadata.class);
            //mEditText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    if(meta_data!=null)
                        return meta_data;

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
                    InputStream is = context.getAssets().open("meta_data.json");
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

        meta_data = gson.fromJson(ilocal.parseJSONToString(),  Metadata.class);
        return meta_data;
    }
}