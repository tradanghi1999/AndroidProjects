package vn.edu.uel.apptudien.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import vn.edu.uel.apptudien.R;

public class KeywordModel extends BaseObservable {
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
        return  this.groupSearchZone;
    }
    @Bindable
    public void setGroupSearchZone(String groupSearchZone)
    {
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

}
