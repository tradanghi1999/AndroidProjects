package com.ungdunguel.appphapluat.model;

public class News_Data {
    public News_meta_data meta_data;
    public News[] records;

    public News_Data(News_meta_data meta_data, News[] records) {
        this.meta_data = meta_data;
        this.records = records;
    }
}