package com.ungdunguel.appphapluat.data.sync;

import android.content.Context;
import android.os.AsyncTask;

import com.ungdunguel.appphapluat.data.local.Local_Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.content.Context.MODE_PRIVATE;

public class SyncMachince {
    public SyncResult isync;
    public Context context;

    public SyncMachince(SyncResult isync, Context context) {
        this.isync = isync;
        this.context = context;
    }


    private boolean fileExist(String fname){
        File file = context.getFileStreamPath(fname);
        return file.exists();
    }
    public void syncWordData()
    {

        //String text = mEditText.getText().toString();
        if(fileExist("database.json"))
        {
            isync.onSyncedWord();
            return;
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
                    isync.onFailure();
                    return null;
                }
                return json;
            }
        };

        String myDatabase = ilocal.parseJSONToString();


        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("database.json", MODE_PRIVATE);
            fos.write(myDatabase.getBytes());

            //mEditText.getText().clear();
            //Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
            //        Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            isync.onFailure();
        } catch (IOException e) {
            e.printStackTrace();
            isync.onFailure();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    isync.onSyncedWord();

                } catch (IOException e) {
                    e.printStackTrace();
                    isync.onFailure();
                }
            }
        }
    }

    public void syncNewsData()
    {

        //String text = mEditText.getText().toString();
        if(fileExist("news.json"))
        {
            isync.onSyncNews();
            return;
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
                    isync.onFailure();
                    return null;
                }
                return json;
            }
        };

        String myDatabase = ilocal.parseJSONToString();


        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("news.json", MODE_PRIVATE);
            fos.write(myDatabase.getBytes());

            //mEditText.getText().clear();
            //Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
            //        Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            isync.onFailure();
        } catch (IOException e) {
            e.printStackTrace();
            isync.onFailure();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    isync.onSyncNews();

                } catch (IOException e) {
                    e.printStackTrace();
                    isync.onFailure();
                }
            }
        }
    }

    public void syncGroupData()
    {

        //String text = mEditText.getText().toString();
        if(fileExist("group.json"))
        {
            isync.onSyncGroup();
            return;
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
                    isync.onFailure();
                    return null;
                }
                return json;
            }
        };

        String myDatabase = ilocal.parseJSONToString();


        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("group.json", MODE_PRIVATE);
            fos.write(myDatabase.getBytes());

            //mEditText.getText().clear();
            //Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
            //        Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            isync.onFailure();
        } catch (IOException e) {
            e.printStackTrace();
            isync.onFailure();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    isync.onSyncGroup();

                } catch (IOException e) {
                    e.printStackTrace();
                    isync.onFailure();
                }
            }
        }
    }
    public void syncMetaData()
    {

        //String text = mEditText.getText().toString();
        if(fileExist("meta_data.json"))
        {
            isync.onSyncMeta();
            return;
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
                    isync.onFailure();
                    return null;
                }
                return json;
            }
        };

        String myDatabase = ilocal.parseJSONToString();


        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("meta_data.json", MODE_PRIVATE);
            fos.write(myDatabase.getBytes());

            //mEditText.getText().clear();
            //Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
            //        Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            isync.onFailure();
        } catch (IOException e) {
            e.printStackTrace();
            isync.onFailure();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    isync.onSyncMeta();

                } catch (IOException e) {
                    e.printStackTrace();
                    isync.onFailure();
                }
            }
        }
    }


    private class SycnExecute extends AsyncTask
    {
        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }
    }
}
