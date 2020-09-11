package vn.edu.uel.realdevice.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class OwnLibrary {


    public static boolean isNewer(String v1, String v2)
    {
        Version ver1 = new Version(v1);
        Version ver2 = new Version(v2);
        if(ver1.compareTo(ver2)>0)
            return true;
        return false;
    }

    public static String getLocalStringFromSharePre(AppCompatActivity activity)
    {
        SharedPreferences sp = activity.getPreferences(MODE_PRIVATE);
        String locale = sp.getString("lang_locale","vi");
        return  locale;
    }

    public static String getLocalJsonStringFromSharePre(AppCompatActivity activity,String jsonKey)
    {
        SharedPreferences sp = activity.getPreferences(MODE_PRIVATE);
        String localJsonString = sp.getString(jsonKey,"");
        return  localJsonString;

    }

    public static void setLocalJsonStringToSharePre(AppCompatActivity activity,String jsonKey, String jsonValue)
    {
        SharedPreferences sp = activity.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(jsonKey,jsonValue);
        editor.apply();
        editor.commit();
    }

    public static void setLocalStringFromSharePre(AppCompatActivity activity,String lang_locale)
    {
        SharedPreferences sp = activity.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("lang_locale",lang_locale);
        editor.apply();
        editor.commit();
    }

    public static void makeResponsiveWithText(AppCompatActivity activity, String text)
    {
        //View home_search_button = activity.findViewById(R.id.home_search_button);
//        if(text==null || text=="")
//        {
//            make_home_search_spinner_default(activity, home_search_button);
//        }
//        else
//        {
//            make_home_search_spinner_responsive(activity,home_search_button);
//        }
    }


    private static void make_home_search_spinner_responsive(AppCompatActivity activity,View home_search_button) {
        home_search_button.setPadding(dpToPx(activity,5),0,dpToPx(activity, 0),0);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)home_search_button.getLayoutParams();
        layoutParams.width = dpToPx(activity,180);
    }
    private static void make_home_search_spinner_default(AppCompatActivity activity, View home_search_button) {


        home_search_button.setPadding(dpToPx(activity,0),0,0,0);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)home_search_button.getLayoutParams();
        layoutParams.width = dpToPx(activity,40);
    }

    public static void setAppLocale(AppCompatActivity activity,String localeCode)
    {
        Resources res = activity.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));
        res.updateConfiguration(conf,dm);
    }

    public static int dpToPx(Context context, int dp) {
        float density = context.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
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





    /**
     * Compares two version strings.
     *
     * Use this instead of String.compareTo() for a non-lexicographical
     * comparison that works for version strings. e.g. "1.10".compareTo("1.6").
     *
     * @param v1 a string of alpha numerals separated by decimal points.
     * @param v2 a string of alpha numerals separated by decimal points.
     * @return The result is 1 if v1 is greater than v2.
     *         The result is 2 if v2 is greater than v1.
     *         The result is -1 if the version format is unrecognized.
     *         The result is zero if the strings are equal.
     */


}