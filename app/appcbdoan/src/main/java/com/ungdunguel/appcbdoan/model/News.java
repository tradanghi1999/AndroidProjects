package com.ungdunguel.appcbdoan.model;

public class News {
    public String id;
    public String name;
    public String para;
    public String onlink;
    public String offlink;
    public String[] keywords;
    public String group_id;
    public String search_times;
    public String search_times_client;

    public News(String id, String name, String para ,String onlink, String offlink, String[] keywords, String group_id, String search_times, String search_times_client) {
        this.id = id;
        this.name = name;
        this.para = para;
        this.onlink = onlink;
        this.offlink = offlink;
        this.keywords = keywords;
        this.group_id = group_id;
        this.search_times = search_times;
        this.search_times_client = search_times_client;
    }


}
