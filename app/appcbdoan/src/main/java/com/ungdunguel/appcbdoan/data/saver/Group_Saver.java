package com.ungdunguel.appcbdoan.data.saver;

import android.content.Context;
import android.graphics.Bitmap;

import com.ungdunguel.appcbdoan.data.remote.IUelAPI;
import com.ungdunguel.appcbdoan.data.remote.UelAPI;

public class Group_Saver extends  Saver {
    public Group_Saver(Context context, ISaver iSaver) {
        super(context, iSaver);
    }
    public void downloadGroupData()
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
                saveToFileName("group.json", response);
                iSaver.onSaveComplete();
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
        uelAPI.sendToGetGroupData();
    }
}
