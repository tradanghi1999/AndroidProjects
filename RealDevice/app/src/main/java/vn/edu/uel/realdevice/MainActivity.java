package vn.edu.uel.realdevice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.Locale;

import vn.edu.uel.realdevice.data.saver.Banner_Saver;
import vn.edu.uel.realdevice.data.saver.ISaver;
import vn.edu.uel.realdevice.databinding.ActivityMainBinding;
import vn.edu.uel.realdevice.model.Banner;
import vn.edu.uel.realdevice.presenter.BannerPresenter;
import vn.edu.uel.realdevice.viewmodel.BannerModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //MainActivity.setLocale(MainActivity.this);
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        Banner banner = new Banner("1594926487", "http://ungdunguel.com/tudiencbdoan/API/Landing/landing.png","900","1600");
        BannerModel bannerModel = new BannerModel(MainActivity.this, banner);
        BannerPresenter bannerPresenter = new BannerPresenter() {
            @Override
            public RequestListener onImageLoaded() {
                RequestListener requestListener = new RequestListener() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                        Toast.makeText(MainActivity.this,"Loaded failed", Toast.LENGTH_LONG);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                        Toast.makeText(MainActivity.this,"Loaded", Toast.LENGTH_LONG);
                        return false;
                    }
                };

                return requestListener;

            }
        };

        activityMainBinding.setBannerMdl(bannerModel);
        activityMainBinding.setBannerPrs(bannerPresenter);
    }
    public static void setLocale(Activity context) {
        Locale locale;

        //Log.e("Lan",session.getLanguage());
        locale = new Locale("vi-rVN");
        Configuration config = new Configuration(context.getResources().getConfiguration());
        Locale.setDefault(locale);
        config.setLocale(locale);

        context.getBaseContext().getResources().updateConfiguration(config,
                context.getBaseContext().getResources().getDisplayMetrics());
    }

    public static void setAppLocale(AppCompatActivity activity,String localeCode)
    {
        Resources res = activity.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));
        res.updateConfiguration(conf,dm);
    }

}

