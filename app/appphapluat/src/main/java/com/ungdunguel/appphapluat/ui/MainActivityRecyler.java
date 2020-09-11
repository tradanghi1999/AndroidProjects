package com.ungdunguel.appphapluat.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.franmontiel.localechanger.LocaleChanger;
import com.google.android.material.navigation.NavigationView;
import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;
import com.ungdunguel.appphapluat.R;
import com.ungdunguel.appphapluat.adapter.News_Adapter;
import com.ungdunguel.appphapluat.adapter.News_Recycler_Adapter;
import com.ungdunguel.appphapluat.adapter.Spinner_Adapter;
import com.ungdunguel.appphapluat.data.local.Banner_Local_Data;
import com.ungdunguel.appphapluat.data.local.Group_Local_Data;
import com.ungdunguel.appphapluat.data.saver.Banner_Saver;
import com.ungdunguel.appphapluat.data.saver.ISaver;
import com.ungdunguel.appphapluat.data.search.SearchMachine;
import com.ungdunguel.appphapluat.data.search.SearchReturn;
import com.ungdunguel.appphapluat.data.sync.SyncMachince;
import com.ungdunguel.appphapluat.data.sync.SyncResult;
import com.ungdunguel.appphapluat.data.translate.ITranslateResult;
import com.ungdunguel.appphapluat.data.translate.TranslateMachine;
import com.ungdunguel.appphapluat.databinding.DrawHeaderBinding;
import com.ungdunguel.appphapluat.databinding.MainLayoutBinding;
import com.ungdunguel.appphapluat.listener.SearchListener;
import com.ungdunguel.appphapluat.model.Banner;
import com.ungdunguel.appphapluat.model.Group;
import com.ungdunguel.appphapluat.model.News;
import com.ungdunguel.appphapluat.presenter.BannerPresenter;
import com.ungdunguel.appphapluat.presenter.HomepagePresenter;
import com.ungdunguel.appphapluat.presenter.SearchPresenter;
import com.ungdunguel.appphapluat.presenter.SpinnerPresenter;
import com.ungdunguel.appphapluat.util.OwnLib;
import com.ungdunguel.appphapluat.viewmodel.BannerModel;
import com.ungdunguel.appphapluat.viewmodel.GroupModel;
import com.ungdunguel.appphapluat.viewmodel.KeywordModel;
import com.ungdunguel.appphapluat.viewmodel.NewsModel;
import com.ungdunguel.appphapluat.viewmodel.SuggestionModel;
import com.ungdunguel.appphapluat.viewmodel.UpdateModel;

public class MainActivityRecyler extends AppCompatActivity {
    public class MainAsyncTask extends AsyncTask<Void, Void, String>   {
        @Override protected String doInBackground(Void... params) {
            SyncMachince syncMachince = new SyncMachince(new SyncResult() {
                @Override
                public void onFailure() {

                }

                @Override
                public void onSyncedWord() {
                    //publishProgress("word in data");
                    //Toast.makeText(MainNavActivity.this,"word in data", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onSyncGroup() {
                    //publishProgress("group in data");
                    //Toast.makeText(MainNavActivity.this,"group in data", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onSyncNews() {
                    //publishProgress("news in data");
                    //Toast.makeText(MainNavActivity.this,"news in data", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onSyncMeta() {
                    //publishProgress("meta in data");
                    //Toast.makeText(MainNavActivity.this,"meta in data", Toast.LENGTH_LONG).show();
                }
            }, MainActivityRecyler.this);
            syncMachince.syncMetaData();
            syncMachince.syncNewsData();
            syncMachince.syncGroupData();
            syncMachince.syncWordData();

            ///

            Banner_Saver banner_saver = new Banner_Saver(MainActivityRecyler.this, new ISaver() {
                @Override
                public void onSaveComplete() {

                }

                @Override
                public void onError() {

                }
            });
            banner_saver.downloadBanner();


            return null;
        }
        @Override protected void onPostExecute(String result) {}
    }

    MainLayoutBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main_layout);

        //set locale


        //set binding obj and layout
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.main_layout);

        // async task




        //ui data
        addControls();

        //ui doing - flow

        //event binding
        addEvents();

        //data binding
        addData();



        // ui event
        addUIflows();



    }


    @Override
    protected void onResume() {
        super.onResume();

        MainAsyncTask mainAsyncTask = new MainAsyncTask();
        mainAsyncTask.execute();


//
//        AsyncTask asyncSync = new AsyncTask() {
//            @Override
//            protected Object doInBackground(Object[] objects) {
//                SyncMachince syncMachince = new SyncMachince(new SyncResult() {
//                    @Override
//                    public void onFailure() {
//
//                    }
//
//                    @Override
//                    public void onSyncedWord() {
//                        //publishProgress("word in data");
//                        //Toast.makeText(MainNavActivity.this,"word in data", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onSyncGroup() {
//                        //publishProgress("group in data");
//                        //Toast.makeText(MainNavActivity.this,"group in data", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onSyncNews() {
//                        //publishProgress("news in data");
//                        //Toast.makeText(MainNavActivity.this,"news in data", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onSyncMeta() {
//                        //publishProgress("meta in data");
//                        //Toast.makeText(MainNavActivity.this,"meta in data", Toast.LENGTH_LONG).show();
//                    }
//                }, MainActivityRecyler.this);
//                syncMachince.syncMetaData();
//                syncMachince.syncNewsData();
//                syncMachince.syncGroupData();
//                syncMachince.syncWordData();
//                return null;
//            }
//
//            @Override
//            protected void onProgressUpdate(Object[] values) {
//                super.onProgressUpdate(values);
//                //Toast.makeText(MainActivityRecyler.this, values[0].toString(), Toast.LENGTH_LONG).show();
//            }
//        };
//        asyncSync.execute();
//
//        AsyncTask asyncBanner = new AsyncTask() {
//            @Override
//            protected Object doInBackground(Object[] objects) {
//                Banner_Saver banner_saver = new Banner_Saver(MainActivityRecyler.this, new ISaver() {
//                    @Override
//                    public void onSaveComplete() {
//                        publishProgress("_");
//                    }
//
//                    @Override
//                    public void onError() {
//
//                    }
//                });
//                banner_saver.downloadBanner();
//                return null;
//            }
//        };
//        asyncBanner.execute();

    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        //closeKeyboard();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        newBase = LocaleChanger.configureBaseContext(newBase);
        super.attachBaseContext(newBase);
    }

    private void addUIflows() {
        String lang_locale = OwnLib.getLocalStringFromSharePre(this);

        //ui drawer
        DrawerLayout mHome = findViewById(R.id.main_drawer);
        mHome.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                closeKeyboard();
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        //ui on editor action

        //ui keyboard
        txtBox.clearFocus();
    }


    HomepagePresenter homePresenter;
    BannerPresenter bannerPresenter;
    SpinnerPresenter spinnerPresenter;
    SearchPresenter srchPresenter;
    SearchMachine searchMachine;
    News_Adapter news_adapter;
    private void addEvents() {
        //homepage presenter
        homePresenter = new HomepagePresenter() {
            @Override
            public void openDrawer() {

                closeKeyboard();

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

        //event for drawer header
        DrawHeaderBinding _headerBinding = DataBindingUtil.inflate(
                getLayoutInflater(),
                R.layout.draw_header,
                activityMainBinding.navDrawer,
                false
        );
        activityMainBinding.navDrawer.addHeaderView(_headerBinding.getRoot());
        _headerBinding.setDrawerPresenter(homePresenter);

        //event for drawer conntent



        //banner pressenter
        bannerPresenter = new BannerPresenter() {
            @Override
            public RequestListener onImageLoaded() {
                RequestListener requestListener = new RequestListener() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                        closeKeyboard();
                        //txtBox.clearFocus();
                        return false;
                    }
                };
                return requestListener;
            }
        };
        activityMainBinding.mainContent.setBannerPrs(bannerPresenter);

        // spinner presenter

        spinnerPresenter = new SpinnerPresenter() {
            @Override
            public void onChangedOption() {

                String group_name_selected = null;
                if (home_search_spinner.getSelectedItemPosition() != 0) {
                    group_name_selected = groupModels[home_search_spinner.getSelectedItemPosition()].getName();
                }

                keysview.setGroupSearchZone(group_name_selected);
                activityMainBinding.mainContent.bindSearchBar.setKeyWordToSearch(keysview);
                OwnLib.makeResponsiveWithText(MainActivityRecyler.this, group_name_selected);
                //Toast.makeText(MainReActivity.this, group_name_selected, Toast.LENGTH_LONG).show();


                String [] suggestWords = suggestionModel.getWordsSuggestionBasedOnKeyWordMdel(
                        keysview
                );
                ArrayAdapter adapter = new ArrayAdapter(MainActivityRecyler.this,
                        R.layout.spinner_item_layout, suggestWords
                        );

                activityMainBinding.mainContent.bindSearchBar.autoCompleteEdt.setAdapter(adapter);

                //ui đặc biệt - ẩn theo thư viện pháp luật
                //activityMainBinding.mainContent.spinnerWrapper.setVisibility(View.GONE);
            }


        };
        activityMainBinding.mainContent.searchSpinner.setSpinnerPresenter(spinnerPresenter);
        //activityMainBinding.mainContent.spinnerWrapper.setVisibility(View.GONE);

        //search presenter
        srchPresenter = new SearchPresenter() {
            @Override
            public void onSearchButtonClicked() {
                //ui first
                activityMainBinding.mainContent.opazone.setVisibility(View.VISIBLE);
                activityMainBinding.mainContent.uiProgress.setVisibility(View.VISIBLE);
                //
                String t = keysview.getVi_word();
                //Toast.makeText(MainNavActivity.this, t, Toast.LENGTH_LONG).show();
                if(t.toLowerCase().equalsIgnoreCase("")|| t.toLowerCase().equalsIgnoreCase(null))
                {
                    keysview.setVi_word("(Trống)");
                    keysview.setEn_word("(Emty)");

                    uiDoingWhenSearchButtonClickedAfterHandle();

                    return;
                }

                TranslateMachine translateMachine = new TranslateMachine(new ITranslateResult() {
                    @Override
                    public void onSuccess(String en_word) {
                        keysview.setEn_word(en_word);
                        activityMainBinding.mainContent.setKeysview(keysview);
                    }

                    @Override
                    public void onError(String vi_word) {
                        TranslateAPI translateAPI = new TranslateAPI(
                                Language.VIETNAMESE,   //Source Language
                                Language.ENGLISH,         //Target Language
                                vi_word);           //Query Text

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
                    }
                },  MainActivityRecyler.this);
                translateMachine.sendToGetEnWord(t);



                searchMachine = new SearchMachine(MainActivityRecyler.this, keysview, new SearchReturn() {
                    @Override
                    public void onResponse(News[] news) {
                        NewsModel[] newsMdlGotten = new NewsModel[news.length];
                        for (int i = 0; i < newsMdlGotten.length;i++)
                        {
                            newsMdlGotten[i] = new NewsModel(news[i]);
                        }
                        news_adapter = new News_Adapter(newsMdlGotten,MainActivityRecyler.this);
                        home_cards.setAdapter(news_adapter);


                        //
                        RecyclerView recyclerView = activityMainBinding.mainContent.homeCardsRecycler;
                        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivityRecyler.this);
                        recyclerView.setLayoutManager(layoutManager);
                        News_Recycler_Adapter recycler_adapter = new News_Recycler_Adapter(newsMdlGotten);
                        recyclerView.setAdapter(recycler_adapter);




                        keysview.setNewsFound(news.length);
                        activityMainBinding.mainContent.setKeysview(keysview);
                    }

                    @Override
                    public void onFailure() {

                    }
                });
                searchMachine.SentToGetNews();

                hideSearchResult(false);



                uiDoingWhenSearchButtonClickedAfterHandle();


            }

            private void uiDoingWhenSearchButtonClickedAfterHandle()
            {
                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }

                // ui - doing - last
                //ListView tListView = findViewById(R.id.home_cards);
                //OwnLib.makeListViewHeightResponsive(tListView);
                activityMainBinding.mainContent.opazone.setVisibility(View.GONE);
                activityMainBinding.mainContent.uiProgress.setVisibility(View.GONE);
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

    }


    SuggestionModel suggestionModel;
    GroupModel[] groupModels;
    Spinner_Adapter groupAdapter;
    //News_Adapter news_adapter;//ActivityHomeBinding dataBindingUtil;
    KeywordModel keysview;
    //
    UpdateModel updateModel;
    BannerModel bannerModel;
    private void addData() {
        String lang = OwnLib.getLocalStringFromSharePre(this);
        // add Banner
        Banner _banner = Banner_Local_Data.getDefBanner(MainActivityRecyler.this);
        bannerModel = new BannerModel(MainActivityRecyler.this,_banner);
        activityMainBinding.mainContent.setBannerView(bannerModel);

        //add Group Search
        Group[] groupRecords = (new Group_Local_Data(this)).getGroupRecords();
        groupModels = new GroupModel[groupRecords.length];
        for (int i = 0; i < groupModels.length; i++) {
            GroupModel groupModel = new GroupModel(groupRecords[i], lang);
            groupModels[i] = groupModel;
        }
        groupAdapter = new Spinner_Adapter(groupModels, this);
        home_search_spinner.setAdapter(groupAdapter);

        //add keyword_temp
        keysview = new KeywordModel(this,null, null, getString(R.string.resultCount), groupModels[0].getName());
        activityMainBinding.mainContent.setKeysview(keysview);
        activityMainBinding.mainContent.bindSearchBar.setKeyWordToSearch(keysview);

        //add suggestion model
        suggestionModel = new SuggestionModel(MainActivityRecyler.this);
        activityMainBinding.mainContent.bindSearchBar.setSuggestion(suggestionModel);

        //add update model
        UpdateModel.IUpdateModel _iupdateMdl = new UpdateModel.IUpdateModel() {
            @Override
            public void onResponseOnlineMeta() {
                activityMainBinding.updateZone.setUpdatePrt(homePresenter);
                activityMainBinding.mainContent.uiProgress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure() {
                activityMainBinding.updateZone.setUpdatePrt(homePresenter);
                activityMainBinding.updateZone.openUpdateboxButton.setEnabled(false);
                activityMainBinding.mainContent.uiProgress.setVisibility(View.GONE);
            }
        };

        updateModel = new UpdateModel(this, _iupdateMdl);


    }

    @Override
    protected void onStart() {
        super.onStart();
        hideSearchResult(true);
    }

    Spinner home_search_spinner;
    LinearLayout search_result_box;
    LinearLayout home_cards_wrapper;
    ListView home_cards;
    ImageView banner;
    AutoCompleteTextView txtBox;
    private void addControls() {
        home_search_spinner = findViewById(R.id.home_search_spinner);
        search_result_box = findViewById(R.id.search_result_box);
        home_cards_wrapper = findViewById(R.id.home_cards_wrapper);
        home_cards = findViewById(R.id.home_cards);
        banner = findViewById(R.id.banner);
        txtBox = findViewById(R.id.auto_complete_edt);
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
    private void openInfoBox() {
        InfoDiaLogFragment udf = new InfoDiaLogFragment();
        FragmentManager fm =  getSupportFragmentManager();
        udf.show(fm,"io");
    }
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


}
