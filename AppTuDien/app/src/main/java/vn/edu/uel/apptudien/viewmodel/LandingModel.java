package vn.edu.uel.apptudien.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;

import java.io.File;
import java.lang.annotation.Target;

import vn.edu.uel.apptudien.model.Banner;
import vn.edu.uel.apptudien.model.Landing;
import vn.edu.uel.apptudien.util.OwnLibrary;

public class LandingModel extends BaseObservable {
    String datetime;
    static String link;
    static String filename;
    String width;
    String height;
    Context context;
    public LandingModel(Context context, Landing landing)
    {
        this.context =context;
        this.datetime = landing.getDatetime();
        link = landing.getLink();
        this.width = landing.getWidth();
        this.height = landing.getHeight();
        filename = landing.getFileName(context);
    }
    @BindingAdapter(value = {"nen","prs"}, requireAll = false)
    public static void setImageViewResource(final ImageView imageView, Context context, RequestListener requestListener) {
        //imageView.setImageDrawable(Drawable.createFromPath(filename.toString()));
        //imageView.setImageResource(resource);
    if(OwnLibrary.fileExists(context,filename)) {
        Glide.with(context)
                .load(filename)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(requestListener)
                .into(imageView);
    }
    else
    {
        Glide.with(context)
                .load(link)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(requestListener)
                .into(imageView);
    }
//  }     double ratio = 0;
//        try {
//            ratio = Integer.parseInt(width) * 1.0/ Integer.parseInt(height);
//        }
//        catch (Exception e)
//        {
//            Log.e("error", "Converting error");
//        }
//
//        if(ratio!=0) {
////
////            //int iheight = imageView.getLayoutParams().height;
////
////
////            //imageView.getLayoutParams().height = (int)(iwidth / ratio);
////            final double mRatio = ratio;
////            final Context mContext = context;
////            Glide.with(mContext)
////                    .load(filename)
////                    .diskCacheStrategy(DiskCacheStrategy.ALL)
////                    .dontAnimate()
////                    .dontTransform()
////                    .into(imageView);
//            final  double mRatio =  ratio;
//            imageView.post(new Runnable() {
//                @Override
//                public void run() {
//                    int iwidth = imageView.getWidth();
//                    int iheight = (int) (iwidth / mRatio);
////                    imageView.setLayoutParams(new RelativeLayout.LayoutParams(iwidth, iheight));
//                    //String fname = new File(filename).getAbsolutePath();
//
//                    Bitmap bitmap = BitmapFactory.decodeFile(filename, new BitmapFactory.Options());
//                    bitmap = Bitmap.createScaledBitmap(bitmap, iwidth, iheight, true);
//                    imageView.setImageBitmap(bitmap);
//
//
//                }
//////            });
//            });
//        }
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
