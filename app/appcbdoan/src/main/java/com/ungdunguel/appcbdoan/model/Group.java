package com.ungdunguel.appcbdoan.model;
public class Group {


    public String group_id;
    public String group_name_vi;
    public String group_name_en;
    public String search_times;
    public String search_times_client;

    public Group(String group_id, String group_name_vi, String group_name_en, String search_times, String search_times_client) {
        this.group_id = group_id;
        this.group_name_vi = group_name_vi;
        this.group_name_en = group_name_en;
        this.search_times = search_times;
        this.search_times_client = search_times_client;
    }
}
