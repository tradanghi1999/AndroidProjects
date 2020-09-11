package vn.edu.uel.apptudien.presenter;

import android.widget.TextView;

public interface SearchPresenter {
    void onSearchButtonClicked();
    TextView.OnEditorActionListener onEnteredEditext();
}
