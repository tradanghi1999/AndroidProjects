package com.ungdunguel.appphapluat.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ungdunguel.appphapluat.databinding.NewsModelBinding;
import com.ungdunguel.appphapluat.viewmodel.NewsModel;

public class News_Recycler_Adapter extends  RecyclerView.Adapter<News_Recycler_Adapter.News_Recycler_ViewHolder>{
    class News_Recycler_ViewHolder extends RecyclerView.ViewHolder
    {
        private NewsModelBinding newsModelBinding;

        public News_Recycler_ViewHolder (NewsModelBinding binding)
        {
            super(binding.getRoot());
            this.newsModelBinding = binding;
        }

        public void bind(NewsModel newsModel)
        {
            newsModelBinding.setNewsView(newsModel);
            newsModelBinding.executePendingBindings();
        }

    }

    public News_Recycler_Adapter(NewsModel[] newsModels) {
        this.newsModels = newsModels;
    }

    private NewsModel[] newsModels;

    @NonNull
    @Override
    public News_Recycler_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsModelBinding newsModelBinding = NewsModelBinding.inflate(layoutInflater, parent,false);
        return  new News_Recycler_ViewHolder(newsModelBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull News_Recycler_ViewHolder holder, int position) {
        NewsModel newsModel = newsModels[position];
        holder.bind(newsModel);

    }

    @Override
    public int getItemCount() {
        return newsModels.length;
    }
}
