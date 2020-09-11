package com.ungdunguel.appphapluat.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.ungdunguel.appphapluat.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class OwnLib {

    public static int countWords(String wd)
    {
        int wordCount = 1;

        for (int i = 0; i < wd.length(); i++)
        {
            if (wd.charAt(i) == ' ')
            {
                wordCount++;
            }
        }
        return wordCount;
    }

    public static String getShortName(String wd)
    {
        // tách thành chuỗi các từ
        String s = wd;
        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            // You may want to check for a non-word character before blindly
            // performing a replacement
            // It may also be necessary to adjust the character class
            words[i] = words[i].replaceAll("[^\\w]", "");
        }
        //lấy các chữ đầu
        String shortName = "";
        for(int i = 0; i < words.length;i++)
        {
            shortName = shortName + words[i].charAt(0);
        }
        return shortName;


    }
    public static void setLocalStringFromSharePre(AppCompatActivity activity,String lang_locale)
    {
        SharedPreferences sp = activity.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("lang_locale",lang_locale);
        editor.apply();
        editor.commit();
    }
    private static void make_home_search_spinner_default(AppCompatActivity activity, View home_search_button) {


        home_search_button.setPadding(dpToPx(activity,0),0,0,0);

        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)home_search_button.getLayoutParams();
        layoutParams.width = dpToPx(activity,40);
    }
    public static void makeResponsiveWithText(AppCompatActivity activity, String text)
    {
        View home_search_button = activity.findViewById(R.id.home_search_button);
        if(text==null || text=="")
        {
            make_home_search_spinner_default(activity, home_search_button);
        }
        else
        {
            make_home_search_spinner_responsive(activity,home_search_button);
        }
    }

    private static void make_home_search_spinner_responsive(AppCompatActivity activity,View home_search_button) {
        home_search_button.setPadding(dpToPx(activity,5),0,dpToPx(activity, 0),0);

        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)home_search_button.getLayoutParams();
        layoutParams.width = dpToPx(activity,180);
    }
    public static String[] getWordsArrayFromSentence(String s)
    {
        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            // You may want to check for a non-word character before blindly
            // performing a replacement
            // It may also be necessary to adjust the character class
            words[i] = words[i].replaceAll("[^\\w]", "");
        }
        return words;
    }

    public static int getMaxPos(int[] numbers){
        int maxPos = 0;
        for(int i=1;i<numbers.length;i++){
            if(numbers[i] > numbers[maxPos]){
                maxPos = i;
            }
        }
        return maxPos;
    }
    public static void setAppLocale(AppCompatActivity context,String localeCode)
    {
//        Resources res = activity.getResources();
//        DisplayMetrics dm = res.getDisplayMetrics();
//        Configuration conf = res.getConfiguration();
//        conf.setLocale(new Locale(localeCode.toLowerCase()));
//        res.updateConfiguration(conf,dm);

        Locale locale;

        //Log.e("Lan",session.getLanguage());
        locale = new Locale(localeCode);
        Configuration config = new Configuration(context.getResources().getConfiguration());
        Locale.setDefault(locale);
        config.setLocale(locale);

        context.getBaseContext().getResources().updateConfiguration(config,
                context.getBaseContext().getResources().getDisplayMetrics());
    }
    public static String getLocalStringFromSharePre(AppCompatActivity activity)
    {
        SharedPreferences sp = activity.getPreferences(MODE_PRIVATE);
        String locale = sp.getString("lang_locale","vi");
        return  locale;
    }


    public static boolean isNewer(String v1, String v2)
    {
        Version ver1 = new Version(v1);
        Version ver2 = new Version(v2);
        if(ver1.compareTo(ver2)>0)
            return true;
        return false;
    }
    public static boolean fileExists(Context context, String filename) {
        try
        {
            File file = new File(filename);
            if(file.exists())
            {
                return true;
            }
//Do something
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }

// Do something else.

    }

    public static String parseJSONToString(String s,Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(s);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    public static int dpToPx(Context context,int dp) {
        float density = context.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }


    public static void makeListViewHeightResponsive(ListView listView) {

        ListAdapter mAdapter = listView.getAdapter();

        int totalHeight = 0;

        for (int i = 0; i < mAdapter.getCount(); i++) {
            View mView = mAdapter.getView(i, null, listView);

            mView.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),

                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

            totalHeight += mView.getMeasuredHeight();
            Log.w("HEIGHT" + i, String.valueOf(totalHeight));

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (mAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();

    }


}
