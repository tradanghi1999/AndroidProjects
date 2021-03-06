package vn.edu.uel.apptudien.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;

import vn.edu.uel.apptudien.R;
import vn.edu.uel.apptudien.databinding.ActivityHomeBinding;
import vn.edu.uel.apptudien.databinding.GroupBinding;
import vn.edu.uel.apptudien.databinding.NewsModelBinding;
import vn.edu.uel.apptudien.viewmodel.GroupModel;
import vn.edu.uel.apptudien.viewmodel.NewsModel;

public class News_Adapter extends BaseAdapter {
    private NewsModel[] newsModels;

    Context context;

    public News_Adapter(NewsModel[] newsModels, Context context) {
        this.newsModels = newsModels;
        this.context = context;
    }

    private NewsModelBinding newsModelBinding;
    @Override
    public int getCount() {
        return newsModels.length;
    }

    @Override
    public Object getItem(int position) {
        if(newsModels == null)
            return null;
        if(newsModels.length > position)
            return newsModels[position];
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        if(convertview == null)
        {

            convertview = LayoutInflater.from(context).inflate(R.layout.card_view,null);
            newsModelBinding = DataBindingUtil.bind(convertview);
            convertview.setTag(newsModelBinding);
        }
        else
        {
            newsModelBinding  = (NewsModelBinding) convertview.getTag();
        }



        newsModelBinding.setNewsView(newsModels[position]);


        return newsModelBinding.getRoot();
    }
}
