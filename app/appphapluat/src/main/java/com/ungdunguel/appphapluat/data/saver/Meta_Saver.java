package com.ungdunguel.appphapluat.data.saver;

import android.content.Context;
import android.graphics.Bitmap;

import com.ungdunguel.appphapluat.data.remote.IUelAPI;
import com.ungdunguel.appphapluat.data.remote.UelAPI;

public class Meta_Saver extends  Saver{
    public Meta_Saver(Context context, ISaver iSaver) {
        super(context, iSaver);
    }
    public void downloadMetaData()
    {
        uelAPI = new UelAPI(context, new IUelAPI() {
            @Override
            public void onResponseMetadata(String response) {
                saveToFileName("meta_data.json", response);
                iSaver.onSaveComplete();
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

            }

            @Override
            public void onResponseImage(Bitmap bitmap) {

            }

            @Override
            public void onResponseLanding(String response) {

            }

            @Override
            public void onFailure(String message) {
                iSaver.onError();
            }
        });
        uelAPI.sendToGetMetaData();
    }
}
