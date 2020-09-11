package vn.edu.uel.apptudien.ui;

import android.opengl.Visibility;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

import vn.edu.uel.apptudien.MainReActivity;
import vn.edu.uel.apptudien.R;
import vn.edu.uel.apptudien.adapter.News_Adapter;
import vn.edu.uel.apptudien.adapter.Spinner_Adapter;
import vn.edu.uel.apptudien.data.SearchMachine;
import vn.edu.uel.apptudien.data.SearchReturn;
import vn.edu.uel.apptudien.data.local.Banner_Local_Data;
import vn.edu.uel.apptudien.data.local.Group_Local_Data;
import vn.edu.uel.apptudien.data.remote.IParallelDotsAPI;
import vn.edu.uel.apptudien.data.remote.ParallelDotsAPI;
import vn.edu.uel.apptudien.data.remote.ParallelDotsKey;
import vn.edu.uel.apptudien.data.saver.Banner_Saver;
import vn.edu.uel.apptudien.data.saver.ISaver;
import vn.edu.uel.apptudien.data.sync.SyncMachince;
import vn.edu.uel.apptudien.data.sync.SyncResult;
import vn.edu.uel.apptudien.databinding.ActivityHomeBinding;
import vn.edu.uel.apptudien.databinding.ActivityMainBinding;
import vn.edu.uel.apptudien.databinding.DrawContentBinding;
import vn.edu.uel.apptudien.databinding.DrawHeaderBinding;
import vn.edu.uel.apptudien.model.Banner;
import vn.edu.uel.apptudien.model.Group;
import vn.edu.uel.apptudien.model.News;
import vn.edu.uel.apptudien.presenter.HomepagePresenter;
import vn.edu.uel.apptudien.presenter.MainPresenter;
import vn.edu.uel.apptudien.presenter.SearchPresenter;
import vn.edu.uel.apptudien.presenter.SpinnerPresenter;
import vn.edu.uel.apptudien.util.OwnLibrary;
import vn.edu.uel.apptudien.viewmodel.BannerModel;
import vn.edu.uel.apptudien.viewmodel.GroupModel;
import vn.edu.uel.apptudien.viewmodel.KeywordModel;
import vn.edu.uel.apptudien.viewmodel.NewsModel;
import vn.edu.uel.apptudien.viewmodel.SuggestionModel;
import vn.edu.uel.apptudien.viewmodel.UpdateModel;
import vn.edu.uel.apptudien.viewmodel.listener.SearchListener;

public class MainNavActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String lang_locale = OwnLibrary.getLocalStringFromSharePre(this);
        OwnLibrary.setAppLocale(this, "vi");
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main);

        AsyncTask asyncSync = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                SyncMachince syncMachince = new SyncMachince(new SyncResult() {
                    @Override
                    public void onFailure() {

                    }

                    @Override
                    public void onSyncedWord() {
                        publishProgress("word in data");
                        //Toast.makeText(MainNavActivity.this,"word in data", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onSyncGroup() {
                        publishProgress("group in data");
                        //Toast.makeText(MainNavActivity.this,"group in data", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onSyncNews() {
                        publishProgress("news in data");
                        //Toast.makeText(MainNavActivity.this,"news in data", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onSyncMeta() {
                        publishProgress("meta in data");
                        //Toast.makeText(MainNavActivity.this,"meta in data", Toast.LENGTH_LONG).show();
                    }
                }, MainNavActivity.this);
                syncMachince.syncMetaData();
                syncMachince.syncNewsData();
                syncMachince.syncGroupData();
                syncMachince.syncWordData();
                return null;
            }

            @Override
            protected void onProgressUpdate(Object[] values) {
                super.onProgressUpdate(values);
                Toast.makeText(MainNavActivity.this, values[0].toString(), Toast.LENGTH_LONG).show();
            }
        };
        asyncSync.execute();

        AsyncTask asyncBanner = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Banner_Saver banner_saver = new Banner_Saver(MainNavActivity.this, new ISaver() {
                    @Override
                    public void onSaveComplete() {
                        publishProgress("_");
                    }

                    @Override
                    public void onError() {

                    }
                });
                banner_saver.downloadBanner();
                return null;
            }
        };
        asyncBanner.execute();



        addControls();
        addData();
        addEvents();


        //addData();

    }

    @Override
    protected void onStart() {
        super.onStart();
        hideSearchResult(true);
    }

    HomepagePresenter homePresenter;
    SuggestionModel suggestionModel;
    GroupModel[] groupModels;
    Spinner_Adapter groupAdapter;
    News_Adapter news_adapter;
    //KeysBinding keysBinding;
    //ActivityHomeBinding dataBindingUtil;
    KeywordModel keysview;
    SearchMachine searchMachine;
    UpdateModel updateModel;
    BannerModel bannerModel;

    private void addData() {


        ///

        String lang = OwnLibrary.getLocalStringFromSharePre(this);

        Group[] groupRecords = (new Group_Local_Data(this)).getGroupRecords();
        groupModels = new GroupModel[groupRecords.length];
        for (int i = 0; i < groupModels.length; i++) {
            GroupModel groupModel = new GroupModel(groupRecords[i], lang);
            groupModels[i] = groupModel;
        }
        groupAdapter = new Spinner_Adapter(groupModels, this);
        home_search_spinner.setAdapter(groupAdapter);

        //
        keysview = new KeywordModel(this,null, null, getString(R.string.resultCount), groupModels[0].getName());
        //keysBinding.setKeysview(keysview);
        //
        activityMainBinding.mainContent.setKeysview(keysview);
        activityMainBinding.mainContent.bindSearchBar.setKeyWordToSearch(keysview);
        //
        suggestionModel = new SuggestionModel(MainNavActivity.this);
        activityMainBinding.mainContent.bindSearchBar.setSuggestion(suggestionModel);
        //
        updateModel = new UpdateModel(this, new UpdateModel.IUpdateModel() {
            @Override
            public void onResponeOnlineMeta() {
                activityMainBinding.updateZone.setUpdatePrt(homePresenter);
            }

            @Override
            public void onFailure() {

            }
        });
        //
        Banner_Local_Data banner_local_data = new Banner_Local_Data(MainNavActivity.this);
        bannerModel = new BannerModel(MainNavActivity.this, banner_local_data.getBannerJson());
        activityMainBinding.mainContent.setBannerView(bannerModel);
        //
//        Glide.with(MainNavActivity.this)
//                .load(Environment.getDataDirectory()
//                        + "/data/"
//                        + MainNavActivity.this.getPackageName()
//                        + "/files/"+"banner.png")
//                .into(banner);

    }

    private void addEvents() {

        SpinnerPresenter presenter = new SpinnerPresenter() {
            @Override
            public void onChangedOption() {

                String group_name_selected = null;
                if (home_search_spinner.getSelectedItemPosition() != 0) {
                    group_name_selected = groupModels[home_search_spinner.getSelectedItemPosition()].getName();
                }

                keysview.setGroupSearchZone(group_name_selected);
                activityMainBinding.mainContent.bindSearchBar.setKeyWordToSearch(keysview);
                OwnLibrary.makeResponsiveWithText(MainNavActivity.this, group_name_selected);
                //Toast.makeText(MainReActivity.this, group_name_selected, Toast.LENGTH_LONG).show();

                ArrayAdapter adapter = new ArrayAdapter(MainNavActivity.this,
                        R.layout.spinner_item_layout,
                        suggestionModel.getWordsSuggestionBasedOnKeyWordMdel(
                                keysview
                        ));

                activityMainBinding.mainContent.bindSearchBar.autoCompleteEdt.setAdapter(adapter);
            }


        };
        //keysBinding

        activityMainBinding.mainContent.searchSpinner.setSpinnerPresenter(presenter);
        //


        final SearchPresenter srchPresenter = new SearchPresenter() {
            @Override
            public void onSearchButtonClicked() {
                String t = keysview.getVi_word();
                //Toast.makeText(MainNavActivity.this, t, Toast.LENGTH_LONG).show();
                if(t==""|| t==null)
                    return;
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.VIETNAMESE,   //Source Language
                        Language.ENGLISH,         //Target Language
                        t);           //Query Text

                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        //Log.d(TAG, "onSuccess: "+translatedText);
                        keysview.setEn_word(translatedText);
                        activityMainBinding.mainContent.setKeysview(keysview);
                        //

//                        IParallelDotsAPI iParallelDotsAPI = new IParallelDotsAPI() {
//                            @Override
//                            public void onSimilarityResponse(String json) {
//                                Toast.makeText(MainNavActivity.this, json,Toast.LENGTH_LONG).show();
//                            }
//
//                            @Override
//                            public void onFailire(String json) {
//                                Toast.makeText(MainNavActivity.this, json,Toast.LENGTH_LONG).show();
//                            }
//                        };
//
//                        ParallelDotsAPI parallelDotsAPI = new ParallelDotsAPI(iParallelDotsAPI,MainNavActivity.this);
//                        parallelDotsAPI.sendVolleyRequest(iParallelDotsAPI, keysview.getVi_word(), keysview.getEn_word());



                        //
                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        //Log.d(TAG, "onFailure: "+ErrorText);
                        keysview.setEn_word("Cannot translate");
                       activityMainBinding.mainContent.setKeysview(keysview);
                    }
                });

                searchMachine = new SearchMachine(MainNavActivity.this, keysview, new SearchReturn() {
                    @Override
                    public void onResponse(News[] news) {
                        NewsModel[] newsMdlGotten = new NewsModel[news.length];
                        for (int i = 0; i < newsMdlGotten.length;i++)
                        {
                            newsMdlGotten[i] = new NewsModel(news[i]);
                        }
                        news_adapter = new News_Adapter(newsMdlGotten,MainNavActivity.this);
                        home_cards.setAdapter(news_adapter);


                        keysview.setNewsFound(news.length);
                        activityMainBinding.mainContent.setKeysview(keysview);
                    }

                    @Override
                    public void onFailure() {

                    }
                });
                searchMachine.SentToGetNews();

                hideSearchResult(false);


                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

            @Override
            public TextView.OnEditorActionListener onEnteredEditext() {

                TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if(actionId == EditorInfo.IME_ACTION_SEARCH)
                        {
                            onSearchButtonClicked();
                        }
                        return false;
                    }
                };
                return onEditorActionListener;

                //return null;
            }
        };
        activityMainBinding.mainContent.bindSearchBar.setSrchPresenter(srchPresenter);


        //

        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH)
                {
                    srchPresenter.onSearchButtonClicked();

                }
                return false;
            }
        };
        SearchListener searchListener = new SearchListener(onEditorActionListener);
        activityMainBinding.mainContent.bindSearchBar.setListener(searchListener);


        //

        homePresenter = new HomepagePresenter() {
            @Override
            public void openDrawer() {

                DrawerLayout home_main_drawer = findViewById(R.id.main_drawer);
                NavigationView nav_drawer = findViewById(R.id.nav_drawer);
                home_main_drawer.openDrawer(nav_drawer);
            }
            @Override
            public void closeDrawer() {
                DrawerLayout home_main_drawer = findViewById(R.id.main_drawer);
                NavigationView nav_drawer = findViewById(R.id.nav_drawer);
                home_main_drawer.closeDrawer(nav_drawer);
            }

            @Override
            public void openUpdateBox() {

                //
                UpdateDialogFragment udf = new UpdateDialogFragment(updateModel);
                FragmentManager fm =  getSupportFragmentManager();
                udf.show(fm,"io");
            }

            @Override
            public void onUpdateClick() {
                closeDrawer();
                openUpdateBox();
            }

            @Override
            public void onInfoClick() {
                closeDrawer();
                openInfoBox();

            }

            @Override
            public int haveNewUpdate() {
                //return updateModel.getIsUpdatable();
                try {
                    return updateModel.getIsUpdatable();
                }
                catch (Exception e)
                {
                    return View.GONE;
                }
            }
        };
        activityMainBinding.mainContent.setPresenterHome(homePresenter);

        DrawHeaderBinding _headerDrawerBind  =  DataBindingUtil.inflate(getLayoutInflater(),R.layout.draw_header,activityMainBinding.navDrawer, false);
        activityMainBinding.navDrawer.addHeaderView(_headerDrawerBind.getRoot());
        _headerDrawerBind.setDrawerPresenter(homePresenter);

        //activityMainBinding.navDrawer.inflateHeaderView()


        //

        //DrawContentBinding _contentDrawerBind =  DataBindingUtil.inf(getLayoutInflater(),R.layout.draw_content,activityMainBinding.navDrawer, false);
        //activityMainBinding.navDrawer.addView(_contentDrawerBind.getRoot());
        //_headerDrawerBind.set
        //activityMainBinding.navDrawer.inflateMenu(R.layout.draw_content);


        //activityMainBinding.updateZone.setUpdateView(updateModel);


    }

    private void openInfoBox() {
        InfoDiaLogFragment udf = new InfoDiaLogFragment();
        FragmentManager fm =  getSupportFragmentManager();
        udf.show(fm,"io");
    }

    LinearLayout home_cards_wrapper;
    Spinner home_search_spinner;
    LinearLayout search_result_box;
    ListView home_cards;
    ImageView banner;

    private void addControls() {
        home_search_spinner = findViewById(R.id.home_search_spinner);
        search_result_box = findViewById(R.id.search_result_box);
        home_cards_wrapper = findViewById(R.id.home_cards_wrapper);
        home_cards = findViewById(R.id.home_cards);
        banner = findViewById(R.id.banner);
    }

    private void hideSearchResult(boolean b) {
        if(b)
        {
            search_result_box.setVisibility(View.GONE);
            home_cards_wrapper.setVisibility(View.GONE);
            return;
        }
        search_result_box.setVisibility(View.VISIBLE);
        home_cards_wrapper.setVisibility(View.VISIBLE);

    }

}
