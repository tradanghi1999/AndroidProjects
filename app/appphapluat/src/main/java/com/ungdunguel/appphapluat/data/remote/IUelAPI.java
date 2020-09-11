package com.ungdunguel.appphapluat.data.remote;

import android.graphics.Bitmap;

public interface IUelAPI {
    void onResponseMetadata(String response);
    void onResponseWordData(String response);
    void onResponseGroupData(String response);
    void onResponseNewsData(String response);
    void onFailure(String message);
    void onResponseBanner(String response);
    void onResponseImage(Bitmap bitmap);
    void onResponseLanding(String response);
}
