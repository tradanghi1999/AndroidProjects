package com.ungdunguel.appphapluat.listener;

import android.widget.TextView;

public class SearchListener {
    public TextView.OnEditorActionListener onSearchListener;
    public SearchListener(TextView.OnEditorActionListener onEditorActionListener)
    {
        this.onSearchListener = onEditorActionListener;
    }
}
