package com.ungdunguel.appphapluat.data.saver;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.google.gson.Gson;
import com.ungdunguel.appphapluat.data.remote.IUelAPI;
import com.ungdunguel.appphapluat.data.remote.UelAPI;
import com.ungdunguel.appphapluat.model.Banner;

import java.io.File;
import java.io.FileOutputStream;

public class Banner_Saver extends Saver{
    public Banner_Saver(Context context, ISaver iSaver) {
        super(context, iSaver);
    }
    public void downloadBanner()
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
            public void onResponseBanner(String Response) {
                saveToFileName("banner.json", Response);

                //
                Gson gson = new Gson();
                Banner banner = gson.fromJson(Response, Banner.class);
                uelAPI.downloadBanner(banner.getLink());
                //

            }

            @Override
            public void onResponseImage(Bitmap bitmap) {
                saveImageToFileName("banner.png",bitmap);
                iSaver.onSaveComplete();
            }

            @Override
            public void onResponseLanding(String response) {

            }

            @Override
            public void onFailure(String message) {
                iSaver.onError();
            }
        });
        uelAPI.sendToGetBanner();
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
