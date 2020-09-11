package com.ungdunguel.appphapluat.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import com.ungdunguel.appphapluat.R;
import com.ungdunguel.appphapluat.data.local.Landing_Local_Data;
import com.ungdunguel.appphapluat.data.saver.ISaver;
import com.ungdunguel.appphapluat.data.saver.Landing_Saver;
import com.ungdunguel.appphapluat.databinding.LandingLayoutBinding;
import com.ungdunguel.appphapluat.model.Landing;
import com.ungdunguel.appphapluat.presenter.LandingPresenter;
import com.ungdunguel.appphapluat.viewmodel.LandingModel;

public class LandingActivity extends AppCompatActivity {
    private static final  long SPLASH_TIME_OUT= 500;
    LandingLayoutBinding landingLayoutBinding;
    LandingModel landingModel;
    LandingPresenter landingPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        landingLayoutBinding = DataBindingUtil.setContentView(LandingActivity.this, R.layout.landing_layout);

        Landing mLanding
                = Landing_Local_Data.getDefLanding(LandingActivity.this);

        landingModel
                = new LandingModel(LandingActivity.this,
                mLanding);

        landingPresenter = new LandingPresenter() {
            @Override
            public RequestListener onImageLoaded() {
                RequestListener requestListener = new RequestListener() {
                    @Override
                    public boolean onLoadFailed(GlideException e, Object model, Target target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {

                        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {

                                Intent i = new Intent(LandingActivity.this, MainActivityRecyler.class);
                                startActivity(i);

                                // close this activity
                                finish();
                            }
                        }, SPLASH_TIME_OUT);
                        return false;
                    }
                };
                return  requestListener;
            }
        };

        landingLayoutBinding.setLandingView(landingModel);
        landingLayoutBinding.setLandingPrs(landingPresenter);


        AsyncTask asyncLanding = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Landing_Saver landing_saver = new Landing_Saver(LandingActivity.this, new ISaver() {
                    @Override
                    public void onSaveComplete() {

                    }

                    @Override
                    public void onError() {

                    }
                });
                landing_saver.downloadLanding();

                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                try {
                    //Toast.makeText(LandingActivity.this, "completed", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Log.e("error", "async Landing error");
                }

            }
        };
        asyncLanding.execute();




    }
}
