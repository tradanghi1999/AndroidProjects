package vn.edu.uel.apptudien.viewmodel.listener;

import android.widget.TextView;

import org.jetbrains.annotations.Contract;

import vn.edu.uel.apptudien.presenter.SearchPresenter;

public class SearchListener {
    public TextView.OnEditorActionListener onSearchListener;
    public SearchListener(TextView.OnEditorActionListener onEditorActionListener)
    {
        this.onSearchListener = onEditorActionListener;
    }


}
