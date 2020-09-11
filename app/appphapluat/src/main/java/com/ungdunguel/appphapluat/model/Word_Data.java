package com.ungdunguel.appphapluat.model;

public class Word_Data {
    public Word_meta_data meta_data;
    public Word[] records;

    public Word_Data(Word_meta_data meta_data, Word[] records) {
        this.meta_data = meta_data;
        this.records = records;
    }
}

