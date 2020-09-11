package com.ungdunguel.appcbdoan.data.saver;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.ungdunguel.appcbdoan.data.remote.UelAPI;

import static android.content.Context.MODE_PRIVATE;

public class Saver {
    protected UelAPI uelAPI;
    protected Context context;
    protected ISaver iSaver;

    public Saver(Context context, ISaver iSaver) {
        this.context = context;
        this.iSaver = iSaver;
    }

    protected boolean fileExist(String fname){
        File file = context.getFileStreamPath(fname);
        return file.exists();
    }

    protected void saveToFileName(final String fileName, String response)
    {

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(fileName, MODE_PRIVATE);
            fos.write(response.getBytes());

            //mEditText.getText().clear();
            //Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
            //        Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // isync.onFailure();
        } catch (IOException e) {
            e.printStackTrace();
            //isync.onFailure();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    //isync.onSyncNews();

                } catch (IOException e) {
                    e.printStackTrace();
                    //isync.onFailure();
                }
            }
        }
    }

}
