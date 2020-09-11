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
import com.ungdunguel.appphapluat.model.Banner;
import com.ungdunguel.appphapluat.util.OwnLib;

public class BannerModel extends BaseObservable {
    String datetime;
    String link;
    String filename;//fdsfsdafsdfasdfsdfsdfasfasfasdfa

    public String getAssetname() {
        return assetname;
    }

    public void setAssetname(String assetname) {
        this.assetname = assetname;
    }

    String assetname;
    String width;
    String height;
    Context context;
    public BannerModel(Context context, Banner banner)
    {
        this.context =context;
        this.datetime = banner.getDatetime();
        this.link = banner.getLink();
        this.width = banner.getWidth();
        this.height = banner.getHeight();
        this.filename = banner.getFileName(context);
        this.assetname = banner.getAssetName();
    }
    @BindingAdapter(value = {"link", "name","asset_name", "loaded"}, requireAll = false)
    public static void setImageViewResource(ImageView imageView, String link, String name, String asset_name, RequestListener loadedEvent) {
        //imageView.setImageDrawable(Drawable.createFromPath(filename.toString()));
        //imageView.setImageResource(resource);
//        double ratio = 0;
//        try {
//            ratio = Integer.parseInt(width) * 1.0/ Integer.parseInt(height);
//        }
//        catch (Exception e)
//        {
//            Log.e("error", "Converting error");
//        }
//
//        if(ratio!=0)
//        {
//
//            //int iheight = imageView.getLayoutParams().height;
//
//
//            //imageView.getLayoutParams().height = (int)(iwidth / ratio);
//            final double mRatio = ratio;
//            final Context mContext = context;
//            imageView.post(new Runnable() {
//                @Override
//                public void run() {
//                    int iwidth = imageView.getWidth();
//                    int iheight = (int)(iwidth /mRatio);
//                    imageView.setLayoutParams(new RelativeLayout.LayoutParams(iwidth, iheight));
//
//                    Glide.with(mContext)
//                            .load(filename)
//                            .into(imageView);
//                }
//            });
//        }

        if(OwnLib.fileExists(imageView.getContext(),name))
        {
            Glide.with(imageView.getContext())
                    .load(name)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(loadedEvent)
                    .into(imageView);
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
    public Context getView()
    {
        return  context;
    }
    @Bindable
    public void setView(Context context)
    {
        this.context = context;
    }

    @Bindable
    public String getLink()
    {
        return link;
    }
    @Bindable
    public void setLink(String link)
    {
        this.link = link;
    }
    @Bindable
    public String getFilename()
    {
        return filename;
    }
    @Bindable
    public void setFilename(String filename)
    {
        this.filename = filename;
    }

}

