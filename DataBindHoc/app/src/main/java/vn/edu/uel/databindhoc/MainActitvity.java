package vn.edu.uel.databindhoc;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;


import vn.edu.uel.databindhoc.databinding.UserSearchBinding;
import vn.edu.uel.databindhoc.presenter.SpinPresenter;
import vn.edu.uel.databindhoc.viewmodel.UserModel;

public class MainActitvity extends AppCompatActivity {
    private UserModel userModel;
    private UserSearchBinding userBinding;
    //private UserSearchBinding userSearchBinding;
    //private SpinPresenter spinPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        userBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        UserModel user = new UserModel("alo", "123456");
        userBinding.setUserSearchview(user);



        userBinding.setPresenterSearch(new SpinPresenter() {
            @Override
            public void onSelectedChanged(UserModel user) {
                user.setUssername(spinner.getSelectedItem().toString());
            }
        });





        //View searchContext = findViewById(R.id.search_lay);
        //userSearchBinding = DataBindingUtil.setContentView(this, R.layout.search_layout);
        //userSearchBinding.setUserSearchview(userModel);
        addControl();
        addData();


    }

    private void addData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("alo");
        arrayList.add("ali");
        arrayList.add("ala");
        //
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        spinner.setAdapter(adapter);


    }

    Spinner spinner;
    void addControl(){

        spinner = findViewById(R.id.my_spinner);
        //LinearLayout linearLayout = findViewById(R.id.my_sin);


    }
}
