package vn.edu.uel.realdevice.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;

import vn.edu.uel.realdevice.model.Banner;

public class BannerModel extends BaseObservable {
    String datetime;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    String link;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    String filename;
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
        this.filename = "file:///android_asset/banner.png";
    }
    @BindingAdapter(value = {"link", "name", "loaded"}, requireAll = false)
    public static void setImageViewResource(final ImageView imageView, String link, String name, RequestListener loadedEvnt) {
        //imageView.setImageDrawable(Drawable.createFromPath(filename.toString()));
        //imageView.setImageResource(resource);

        try
        {
            Glide.with(imageView.getContext())
                   .load(name)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(loadedEvnt)
                    .into(imageView);
        }
        catch (Exception e)
        {
            Log.d("loi","loi glide");
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
    public String getDai()
    {
        return width;
    }
    @Bindable
    public void setDai(String dai)
    {
        this.width = dai;
    }
    @Bindable
    public String getRong()
    {
        return height;
    }
    @Bindable
    public void setRong(String rong)
    {
        this.height = rong;
    }

}
