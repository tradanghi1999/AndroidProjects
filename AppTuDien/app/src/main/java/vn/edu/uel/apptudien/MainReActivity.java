package vn.edu.uel.apptudien;

import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

import vn.edu.uel.apptudien.adapter.Spinner_Adapter;
import vn.edu.uel.apptudien.data.local.Group_Local_Data;
import vn.edu.uel.apptudien.databinding.ActivityHomeBinding;
import vn.edu.uel.apptudien.databinding.GroupBinding;
//import vn.edu.uel.apptudien.databinding.KeysBinding;
//import vn.edu.uel.apptudien.databinding.KeysBinding;
import vn.edu.uel.apptudien.model.Group;
import vn.edu.uel.apptudien.presenter.HomepagePresenter;
import vn.edu.uel.apptudien.presenter.SearchPresenter;
import vn.edu.uel.apptudien.presenter.SpinnerPresenter;
import vn.edu.uel.apptudien.viewmodel.GroupModel;
import vn.edu.uel.apptudien.util.OwnLibrary;
import vn.edu.uel.apptudien.viewmodel.KeywordModel;

import info.debatty.java.stringsimilarity.*;


public class MainReActivity extends AppCompatActivity {





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        OwnLibrary.setLocalStringFromSharePre(this,"vi");
        String locale = OwnLibrary.getLocalStringFromSharePre(this);
        OwnLibrary.setAppLocale(this,locale);

        //keysBinding = DataBindingUtil.setContentView(MainReActivity.this, R.layout.activity_home);
        dataBindingUtil = DataBindingUtil.setContentView(MainReActivity.this,R.layout.activity_home);
        //setContentView(R.layout.activity_main);
        addControls();
        addData();
        addEvents();
    }






    GroupModel[] groupModels;
    Spinner_Adapter groupAdapter;
    //KeysBinding keysBinding;
    ActivityHomeBinding dataBindingUtil;
    KeywordModel keysview;

    private void addData() {



        ///

        String lang = OwnLibrary.getLocalStringFromSharePre(this);

        Group[] groupRecords = (new Group_Local_Data(this)).getGroupRecords();
        groupModels = new GroupModel[groupRecords.length];
        for(int i = 0; i < groupModels.length; i++)
        {
            GroupModel groupModel = new GroupModel(groupRecords[i],lang);
            groupModels[i] = groupModel;
        }
        groupAdapter = new Spinner_Adapter(groupModels,this);
        home_search_spinner.setAdapter(groupAdapter);

        //
        keysview = new KeywordModel(this,null,null,getString(R.string.resultCount), groupModels[0].getName());
        //keysBinding.setKeysview(keysview);
        //
        dataBindingUtil.setKeysview(keysview);
        dataBindingUtil.bindSearchBar.setKeyWordToSearch(keysview);



    }

    private void addEvents() {

        SpinnerPresenter presenter = new SpinnerPresenter() {
            @Override
            public void onChangedOption() {

                String group_name_selected = null;
                if(home_search_spinner.getSelectedItemPosition() != 0)
                {
                    group_name_selected = groupModels[home_search_spinner.getSelectedItemPosition()].getName();
                }

                keysview.setGroupSearchZone(group_name_selected);
                dataBindingUtil.bindSearchBar.setKeyWordToSearch(keysview);
                OwnLibrary.makeResponsiveWithText(MainReActivity.this, group_name_selected);
                //Toast.makeText(MainReActivity.this, group_name_selected, Toast.LENGTH_LONG).show();
            }


        };
        //keysBinding

        dataBindingUtil.searchSpinner.setSpinnerPresenter(presenter);
        //


        SearchPresenter srchPresenter = new SearchPresenter() {
            @Override
            public void onSearchButtonClicked() {
                String t = keysview.getVi_word();
                //Toast.makeText(MainReActivity.this, t, Toast.LENGTH_LONG).show();
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,   //Source Language
                        Language.ENGLISH,         //Target Language
                        t);           //Query Text

                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        //Log.d(TAG, "onSuccess: "+translatedText);
                        keysview.setEn_word(translatedText);
                        dataBindingUtil.setKeysview(keysview);
                        //

                        Cosine cosine = new Cosine();
                        String s = "" + cosine.similarity("hi","hello");
                        Toast.makeText(MainReActivity.this,s, Toast.LENGTH_LONG).show();


                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        //Log.d(TAG, "onFailure: "+ErrorText);
                        keysview.setEn_word("Cannot translate");
                        dataBindingUtil.setKeysview(keysview);
                    }
                });


            }

            @Override
            public TextView.OnEditorActionListener onEnteredEditext() {
                return null;
            }
        };
        dataBindingUtil.bindSearchBar.setSrchPresenter(srchPresenter);



    }


    Spinner home_search_spinner;

    private void addControls() {
        home_search_spinner = findViewById(R.id.home_search_spinner);

    }




}
