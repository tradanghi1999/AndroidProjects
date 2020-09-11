package com.ungdunguel.appcbdoan.data.saver;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;

import com.ungdunguel.appcbdoan.data.remote.IUelAPI;
import com.ungdunguel.appcbdoan.data.remote.UelAPI;
import com.ungdunguel.appcbdoan.model.Landing;

public class Landing_Saver extends Saver {
    public Landing_Saver(Context context, ISaver iSaver) {
        super(context, iSaver);
    }
    public void downloadLanding()
    {
        uelAPI = new UelAPI(context, new IUelAPI() {
            @Override
            public void onResponseMetadata(String response) {

            }

            @Override
            public void onResponseWordData(String response) {

            }

            @Override
            public void onResponseGroupData(String response) {

            }

            @Override
            public void onResponseNewsData(String response) {

            }

            @Override
            public void onResponseLanding(String Response) {
                saveToFileName("landing.json", Response);

                //
                Gson gson = new Gson();
                Landing landing = gson.fromJson(Response, Landing.class);
                uelAPI.downloadLanding(landing.getLink());
                //

            }

            @Override
            public void onResponseBanner(String Response) {

            }

            @Override
            public void onResponseImage(Bitmap bitmap) {
                saveImageToFileName("landing.png",bitmap);
                iSaver.onSaveComplete();
            }

            @Override
            public void onFailure(String message) {
                iSaver.onError();
            }
        });
        uelAPI.sendToGetLanding();
    }


    private void saveImageToFileName(final String fileName, Bitmap bitmap)
    {
        String file_dir = Environment.getDataDirectory()
                + "/data/"
                + context.getPackageName()
                + "/files";
        File file = new File (file_dir+"/"+fileName);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}