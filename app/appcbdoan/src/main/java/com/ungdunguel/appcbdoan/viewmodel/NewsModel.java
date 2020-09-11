package com.ungdunguel.appcbdoan.viewmodel;

import com.ungdunguel.appcbdoan.model.News;

public class NewsModel {
    public String name;
    public String onlink;
    public String para;
    public String offlink;

    public NewsModel(News news)
    {
        this.name = news.name;
        this.para = news.para;
        this.onlink = news.onlink;
        this.offlink = news.offlink;
    }
}
