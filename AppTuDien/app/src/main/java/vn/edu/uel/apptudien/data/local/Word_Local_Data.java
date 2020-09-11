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
import vn.edu.uel.apptudien.model.Word;
import vn.edu.uel.apptudien.model.Word_Data;

public class Word_Local_Data {
    Context context;
    public Word_Local_Data(Context context)
    {
        this.context = context;
    }
    public Word[] getWordRecords()
    {
        Gson gson = new Gson();
        Word_Data word_data = null;

        FileInputStream fis = null;
        try {
            fis = context.openFileInput("database.json");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            word_data = gson.fromJson(sb.toString(), Word_Data.class);
            //mEditText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    if(word_data!=null)
                        return word_data.records;

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
                    InputStream is = context.getAssets().open("database.json");
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

        word_data = gson.fromJson(ilocal.parseJSONToString(),  Word_Data.class);
        return word_data.records;
    }
}
