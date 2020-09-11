package com.ungdunguel.appcbdoan.sys;

import android.app.Application;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.franmontiel.localechanger.LocaleChanger;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class YUELApplication extends Application {
    public static final List<Locale> SUPPORTED_LOCALES =
            Arrays.asList(
                    new Locale("vi", "VN"),
                    new Locale("en", "US"),
                    new Locale("es", "ES"),
                    new Locale("fr", "FR"),
                    new Locale("ar", "JO")
            );

    @Override
    public void onCreate() {
        super.onCreate();
        LocaleChanger.initialize(getApplicationContext(), SUPPORTED_LOCALES);
        LocaleChanger.setLocale(SUPPORTED_LOCALES.get(0));
    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleChanger.onConfigurationChanged();
    }


}
