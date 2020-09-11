package vn.edu.uel.apptudien.data.saver;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;

import vn.edu.uel.apptudien.data.remote.IUelAPI;
import vn.edu.uel.apptudien.data.remote.UelAPI;
import vn.edu.uel.apptudien.model.Banner;
import vn.edu.uel.apptudien.model.Landing;

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
            public void onResponeWordData(String response) {

            }

            @Override
            public void onResponeGroupData(String response) {

            }

            @Override
            public void onResponeNewsData(String response) {

            }

            @Override
            public void onResponeLanding(String respone) {
                saveToFileName("landing.json", respone);

                //
                Gson gson = new Gson();
                Landing landing = gson.fromJson(respone, Landing.class);
                uelAPI.downloadLanding(landing.getLink());
                //

            }

            @Override
            public void onResponeBanner(String respone) {

            }

            @Override
            public void onResponeImage(Bitmap bitmap) {
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
