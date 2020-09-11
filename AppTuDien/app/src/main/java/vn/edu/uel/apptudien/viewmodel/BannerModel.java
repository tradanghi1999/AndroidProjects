package vn.edu.uel.apptudien.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;

import java.util.Observable;

import vn.edu.uel.apptudien.model.Banner;

public class BannerModel extends BaseObservable {
    String datetime;
    String link;
    static String filename;
    String width;
    String height;
    Context context;
    public BannerModel(Context context,Banner banner)
    {
        this.context =context;
        this.datetime = banner.getDatetime();
        this.link = banner.getLink();
        this.width = banner.getWidth();
        this.height = banner.getHeight();
        filename = banner.getFileName(context);
    }
    @BindingAdapter(value = {"tai", "dai", "rong"}, requireAll = false)
    public static void setImageViewResource(final ImageView imageView, Context context, String width, String height) {
        //imageView.setImageDrawable(Drawable.createFromPath(filename.toString()));
        //imageView.setImageResource(resource);
        double ratio = 0;
        try {
            ratio = Integer.parseInt(width) * 1.0/ Integer.parseInt(height);
        }
        catch (Exception e)
        {
            Log.e("error", "Converting error");
        }

        if(ratio!=0)
        {

            //int iheight = imageView.getLayoutParams().height;


            //imageView.getLayoutParams().height = (int)(iwidth / ratio);
            final double mRatio = ratio;
            final Context mContext = context;
            imageView.post(new Runnable() {
                @Override
                public void run() {
                    int iwidth = imageView.getWidth();
                    int iheight = (int)(iwidth /mRatio);
                    imageView.setLayoutParams(new RelativeLayout.LayoutParams(iwidth, iheight));

                    Glide.with(mContext)
                            .load(filename)
                            .into(imageView);
                }
            });
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
