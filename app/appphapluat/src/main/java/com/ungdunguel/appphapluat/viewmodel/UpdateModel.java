package com.ungdunguel.appphapluat.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.Gson;
import com.ungdunguel.appphapluat.data.local.Meta_Local_Data;
import com.ungdunguel.appphapluat.data.remote.IUelAPI;
import com.ungdunguel.appphapluat.data.remote.UelAPI;
import com.ungdunguel.appphapluat.model.Metadata;
import com.ungdunguel.appphapluat.util.OwnLib;

public class UpdateModel  extends BaseObservable {
    Metadata offlineMeta;
    Metadata onlineMeta;
    Context context;
    UelAPI uelAPI;
    int visibilityId;
    IUpdateModel iUpdateModel;

    public UpdateModel(final Context context, final IUpdateModel iUpdateModel) {
        this.context = context;
        offlineMeta = new Meta_Local_Data(context).getLocalMeta();

        //
        uelAPI = new UelAPI(context, new IUelAPI() {
            @Override
            public void onResponseMetadata(String response) {
                onlineMeta = (new Gson()).fromJson(response, Metadata.class);
                iUpdateModel.onResponseOnlineMeta();
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
            public void onResponseImage(Bitmap bitmap) {

            }

            @Override
            public void onResponseBanner(String Response) {

            }

            @Override
            public void onResponseLanding(String response) {

            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(context, message, Toast.LENGTH_LONG);
                iUpdateModel.onFailure();
            }
        });
        uelAPI.sendToGetMetaData();

    }

    @Bindable
    public int getIsUpdatable()
    {
        if(onlineMeta!=null)
        {
            if(OwnLib.isNewer(onlineMeta.word_meta_data.getVersion(),
                    offlineMeta.word_meta_data.getVersion()))
            {
                return View.VISIBLE;
            }
            return  View.GONE;
        }
        else
        {
            return  View.GONE;
        }

    }
    @Bindable
    public void setIsUpdatable(int visibilityId)
    {
        if(visibilityId == View.GONE || visibilityId == View.VISIBLE)
        {
            this.visibilityId = visibilityId;
        }
    }

    @Bindable
    public String getOffVersion()
    {
        return this.offlineMeta.word_meta_data.getVersion();
    }
    @Bindable
    public  void  setOffVersion(String version)
    {
        offlineMeta.word_meta_data.setVersion(version);
    }

    @Bindable
    public String getOnVersion()
    {
        return this.onlineMeta.word_meta_data.getVersion();
    }
    @Bindable
    public void setOnVersion(String version)
    {
        onlineMeta.word_meta_data.setVersion(version);
    }

    @Bindable
    public boolean getUpdateEnabled()
    {
        if(visibilityId == View.GONE)
            return false;
        return true;
    }
    @Bindable
    public void setUpdateEnabled(boolean b)
    {
        if(b)
            visibilityId = View.VISIBLE;
        else
            visibilityId = View.GONE;
    }

    public interface IUpdateModel
    {
        void onResponseOnlineMeta();
        void onFailure();
    }

    public Context getView()
    {
        return context;
    }

}
