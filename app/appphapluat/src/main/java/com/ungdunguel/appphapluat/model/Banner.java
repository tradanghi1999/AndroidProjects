package com.ungdunguel.appphapluat.model;

import android.content.Context;
import android.os.Environment;

public class Banner {
    String datetime;
    String link;
    String width;
    String height;

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Banner(String datetime, String link, String width, String height) {
        this.datetime = datetime;
        this.link = link;
        this.width = width;
        this.height = height;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFileName(Context context)
    {
        String file_dir = Environment.getDataDirectory()
                + "/data/"
                + context.getPackageName()
                + "/files";
        return file_dir+"/"+ "banner.png";
    }

    public String getAssetName()
    {
        return "file:///android_asset/banner.png";
    }




}
