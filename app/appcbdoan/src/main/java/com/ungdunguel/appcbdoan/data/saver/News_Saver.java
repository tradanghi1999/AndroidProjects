package com.ungdunguel.appcbdoan.data.saver;

import android.content.Context;
import android.graphics.Bitmap;

import com.ungdunguel.appcbdoan.data.remote.IUelAPI;
import com.ungdunguel.appcbdoan.data.remote.UelAPI;

public class News_Saver extends Saver {
    public News_Saver(Context context, ISaver iSaver) {
        super(context, iSaver);
    }
    public void downloadNewsData()
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
                saveToFileName("news.json", response);
                iSaver.onSaveComplete();
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
        uelAPI.sendToGetNewsData();
    }
}
