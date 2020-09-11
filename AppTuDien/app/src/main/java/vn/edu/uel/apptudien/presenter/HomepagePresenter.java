package vn.edu.uel.apptudien.presenter;

import android.opengl.Visibility;
import android.view.View;

public interface HomepagePresenter {
    void openDrawer();
    void closeDrawer();
    void openUpdateBox();
    int haveNewUpdate();
    void onUpdateClick();
    void onInfoClick();


}
