package vn.edu.uel.apptudien.data.remote;

import android.graphics.Bitmap;

public interface IUelAPI {
    void onResponseMetadata(String response);
    void onResponeWordData(String response);
    void onResponeGroupData(String response);
    void onResponeNewsData(String response);
    void onFailure(String message);
    void onResponeBanner(String respone);
    void onResponeImage(Bitmap bitmap);
    void onResponeLanding(String response);
}
