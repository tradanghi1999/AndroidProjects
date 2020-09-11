package vn.edu.uel.apptudien.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.Visibility;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.Gson;

import vn.edu.uel.apptudien.data.local.Meta_Local_Data;
import vn.edu.uel.apptudien.data.remote.IUelAPI;
import vn.edu.uel.apptudien.data.remote.UelAPI;
import vn.edu.uel.apptudien.model.Metadata;
import vn.edu.uel.apptudien.util.OwnLibrary;

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
                iUpdateModel.onResponeOnlineMeta();
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
            public void onResponeImage(Bitmap bitmap) {

            }

            @Override
            public void onResponeBanner(String respone) {

            }

            @Override
            public void onResponeLanding(String response) {

            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(context, message, Toast.LENGTH_LONG);
            }
        });
        uelAPI.sendToGetMetaData();

    }

    @Bindable
    public int getIsUpdatable()
    {
        if(onlineMeta!=null)
        {
            if(OwnLibrary.isNewer(onlineMeta.word_meta_data.getVersion(),
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
        void onResponeOnlineMeta();
        void onFailure();
    }

    public Context getView()
    {
        return context;
    }

}
