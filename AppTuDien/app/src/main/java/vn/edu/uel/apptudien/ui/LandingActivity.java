package vn.edu.uel.apptudien.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import vn.edu.uel.apptudien.R;
import vn.edu.uel.apptudien.data.local.Landing_Local_Data;
import vn.edu.uel.apptudien.data.local.Local_Data;
import vn.edu.uel.apptudien.data.saver.ISaver;
import vn.edu.uel.apptudien.data.saver.Landing_Saver;
import vn.edu.uel.apptudien.databinding.LandingLayoutBinding;
import vn.edu.uel.apptudien.model.Landing;
import vn.edu.uel.apptudien.presenter.LandingPresenter;
import vn.edu.uel.apptudien.viewmodel.LandingModel;

public class LandingActivity extends AppCompatActivity {

    private static final  long SPLASH_TIME_OUT= 500;
    LandingLayoutBinding landingLayoutBinding;
    LandingModel landingModel;
    LandingPresenter landingPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.def_landing_layout);
        landingLayoutBinding = DataBindingUtil.setContentView(LandingActivity.this, R.layout.landing_layout);


        Landing mLanding = new Landing_Local_Data(LandingActivity.this).getDefLanding();
        landingModel = new LandingModel(LandingActivity.this, );
        landingLayoutBinding.setLandingView(landingModel);

        landingPresenter = new LandingPresenter() {
            @Override
            public RequestListener onImageLoaded() {
                RequestListener requestListener = new RequestListener() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {

                                Intent i = new Intent(LandingActivity.this, MainNavActivity.class);
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
