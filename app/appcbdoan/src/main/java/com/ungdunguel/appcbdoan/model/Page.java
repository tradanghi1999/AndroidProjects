package com.ungdunguel.appcbdoan.model;

import android.content.Context;

import com.google.gson.Gson;

import com.ungdunguel.appcbdoan.util.OwnLib;

public class Page {
    public String getHome_page() {
        return home_page;
    }

    public void setHome_page(String home_page) {
        this.home_page = home_page;
    }

    public String getHome_dir() {
        return home_dir;
    }

    public void setHome_dir(String home_dir) {
        this.home_dir = home_dir;
    }

    public String getHome_metadata() {
        return home_metadata;
    }

    public void setHome_metadata(String home_metadata) {
        this.home_metadata = home_metadata;
    }


    String home_page;
    String home_dir;
    String home_metadata;

    public String getHome_word() {
        return home_word;
    }

    public void setHome_word(String home_word) {
        this.home_word = home_word;
    }

    public String getHome_group() {
        return home_group;
    }

    public void setHome_group(String home_group) {
        this.home_group = home_group;
    }

    public String getHome_news() {
        return home_news;
    }

    public void setHome_news(String home_news) {
        this.home_news = home_news;
    }

    public Page(String home_page,
                String home_dir,
                String home_metadata,
                String home_word,
                String home_group,
                String home_news,
                String home_banner,
                String home_landing) {
        this.home_page = home_page;
        this.home_dir = home_dir;
        this.home_metadata = home_metadata;
        this.home_word = home_word;
        this.home_group = home_group;
        this.home_news = home_news;
        this.home_banner = home_banner;
        this.home_landing = home_landing;
    }

    String home_word;
    String home_group;
    String home_news;
    String home_banner;
    String home_landing;

    public String getHome_landing() {
        return home_landing;
    }

    public void setHome_landing(String home_landing) {
        this.home_landing = home_landing;
    }

    public String getHome_banner() {
        return home_banner;
    }

    public void setHome_banner(String home_banner) {
        this.home_banner = home_banner;
    }

    private static Page def_page;
    public static Page getInstance(Context context)
    {
        if(def_page == null)
        {
            def_page = getHomepage(context);

        }
        return  def_page;
    }

    private static Page getHomepage(Context context)
    {
        Gson gson = new Gson();

        String json = OwnLib.parseJSONToString("page_config.json",context);
        Page mPage = gson.fromJson(json, Page.class);
        return mPage;
    }

}