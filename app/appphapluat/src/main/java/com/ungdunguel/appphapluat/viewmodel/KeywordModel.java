package com.ungdunguel.appphapluat.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.ungdunguel.appphapluat.R;

public class KeywordModel  extends BaseObservable {
    Context context;
    String vi_word;
    String en_word;
    String newsFound;
    String groupSearchZone;

    public KeywordModel(Context context, String vi_word, String en_word, String newsFound, String groupSearchZone) {
        this.context = context;

        this.vi_word = vi_word;
        this.en_word = en_word;
        this.newsFound = newsFound;
        this.groupSearchZone = groupSearchZone;

    }

    @Bindable
    public String getGroupSearchZone()
    {

        return (this.groupSearchZone);
    }
    @Bindable
    public void setGroupSearchZone(String groupSearchZone)
    {
//        if(countWords(groupSearchZone) > 4)
//        {
//            this.groupSearchZone = getShortName(groupSearchZone);
//            return;
//        }
        this.groupSearchZone = groupSearchZone;
    }

    @Bindable
    public String getVi_word()
    {
        return vi_word;
    }
    @Bindable
    public void setVi_word(String vi_word)
    {
        this.vi_word = vi_word;
    }

    @Bindable
    public String getEn_word()
    {
        return  en_word;
    }
    @Bindable
    public void setEn_word(String en_word)
    {
        this.en_word = en_word;
    }

    @Bindable
    public String getNewsFound()
    {
        return newsFound;
    }
    @Bindable
    public  void setNewsFound(int newsFound)
    {
        String newsFoundString = context.getString(R.string.resultCount);
        newsFoundString= newsFoundString.replace("0",""+newsFound);
        this.newsFound = newsFoundString;
    }

    private int countWords(String wd)
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

    private String getShortName(String wd)
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



}
