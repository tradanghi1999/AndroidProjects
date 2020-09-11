package com.ungdunguel.appphapluat.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;

import com.ungdunguel.appphapluat.model.Landing;
import com.ungdunguel.appphapluat.util.OwnLib;

public class LandingModel extends BaseObservable {
    Context context;

    String datetime;
    String link;
    String filename;
    String width;
    String height;

    public String getAssetname() {
        return assetname;
    }

    public void setAssetname(String assetname) {
        this.assetname = assetname;
    }

    String assetname;

    public LandingModel(Context context,Landing landing)
    {
        context = context;
        datetime = landing.getDatetime();
        link = landing.getLink();
        filename = landing.getFileName(context);
        width = landing.getWidth();
        height= landing.getHeight();
        assetname = landing.getAssetname();
    }

    @BindingAdapter(value = {"link","name","asset_name","loaded"}, requireAll = false)
    public static void loadImage(ImageView imageView, String link, String name, String asset_name, RequestListener loadedEvent) {
        if(OwnLib.fileExists(imageView.getContext(),name))
        {
            Glide.with(imageView.getContext())
                    .load(name)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(loadedEvent)
                    .into(imageView);

//            Glide.with(imageView.getContext())
//                    .load(name)
//                    .listener(loadedEvent)
//                    .into(imageView);
//            Glide.with(imageView.getContext())
//                    .load(Uri.parse(link))
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .listener(loadedEvent)
//                    .into(imageView);
        }
        else
        {

            try
            {
                Glide.with(imageView.getContext())
                        .load(asset_name)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .listener(loadedEvent)
                        .into(imageView);
            }
            catch (Exception e)
            {
                Glide.with(imageView.getContext())
                        .load(Uri.parse(link))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .listener(loadedEvent)
                        .into(imageView);
            }

        }
    }



    @Bindable
    public void setFilename(String  filename)
    {
        this.filename=filename;
    }
    @Bindable
    public String getFilename()
    {
        return this.filename;
    }

    @Bindable
    public void setLink(String link)
    {
        this.link = link;
    }
    @Bindable
    public String getLink()
    {
        return this.link;
    }

}
