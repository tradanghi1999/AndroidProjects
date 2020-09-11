package vn.edu.uel.databindhoc.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModel;

import vn.edu.uel.databindhoc.BR;

public class UserModel extends BaseObservable {
    String ussername;
    String password;

    @Bindable
    public String getUssername() {
        return ussername;
    }
    @Bindable
    public void setUssername(String ussername) {
        this.ussername = ussername;
        notifyPropertyChanged(vn.edu.uel.databindhoc.BR.ussername);
    }
    @Bindable
    public String getPassword() {
        return password;
    }
    @Bindable
    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(vn.edu.uel.databindhoc.BR.password);
    }

    public UserModel(String ussername, String password) {
        this.ussername = ussername;
        this.password = password;
    }
}
