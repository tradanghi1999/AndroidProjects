package vn.edu.uel.apptudien.data.saver;

import android.content.Context;
import android.graphics.Bitmap;

import vn.edu.uel.apptudien.data.remote.IUelAPI;
import vn.edu.uel.apptudien.data.remote.UelAPI;

public class Word_Saver extends Saver {
    public Word_Saver(Context context, ISaver iSaver) {
        super(context, iSaver);
    }
    public void downloadWordData()
    {
        uelAPI = new UelAPI(context, new IUelAPI() {
            @Override
            public void onResponseMetadata(String response) {

            }

            @Override
            public void onResponeWordData(String response) {
                saveToFileName("database.json", response);
                iSaver.onSaveComplete();
            }

            @Override
            public void onResponeGroupData(String response) {

            }

            @Override
            public void onResponeNewsData(String response) {

            }

            @Override
            public void onResponeBanner(String respone) {

            }

            @Override
            public void onResponeImage(Bitmap bitmap) {

            }

            @Override
            public void onResponeLanding(String response) {

            }

            @Override
            public void onFailure(String message) {
                iSaver.onError();
            }
        });
        uelAPI.sendToGetWordData();
    }
}
