package com.ungdunguel.appphapluat.data.local;

import android.content.Context;

import com.google.gson.Gson;
import com.ungdunguel.appphapluat.model.Group;
import com.ungdunguel.appphapluat.model.Group_Data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Group_Local_Data {
    Context context;
    public Group_Local_Data(Context context)
    {
        this.context = context;
    }
    public Group[] getGroupRecords()
    {
        Gson gson = new Gson();
        Group_Data group_data =null;


        FileInputStream fis = null;
        try {
            fis = context.openFileInput("group.json");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            group_data = gson.fromJson(sb.toString(), Group_Data.class);
            //mEditText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    if(group_data!=null)
                        return group_data.records;

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
                    InputStream is = context.getAssets().open("group.json");
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

        group_data = gson.fromJson(ilocal.parseJSONToString(),  Group_Data.class);
        return group_data.records;
    }

}
