package com.ungdunguel.appcbdoan.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ungdunguel.appcbdoan.R;
import com.ungdunguel.appcbdoan.data.saver.Group_Saver;
import com.ungdunguel.appcbdoan.data.saver.ISaver;
import com.ungdunguel.appcbdoan.data.saver.Meta_Saver;
import com.ungdunguel.appcbdoan.data.saver.News_Saver;
import com.ungdunguel.appcbdoan.data.saver.Word_Saver;

public class UpdateProgressActivity extends AppCompatActivity {
    TextView pro_text;
    //int i = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_processing_layout);

        pro_text = findViewById(R.id.pro_text);
        new UpdateAsync().execute(new Void[0]);



//        i=0;
//        //publishProgress(i+"");
//        Group_Saver group_saver = new Group_Saver(UpdateProgressActivity.this, new ISaver() {
//            @Override
//            public void onSaveComplete() {
//                i = i + 25;
//                //publishProgress(i+"");
//                if(i==100)
//                    finish();
//            }
//
//            @Override
//            public void onError() {
//
//            }
//        });
//        group_saver.downloadGroupData();
//
//        News_Saver news_saver = new News_Saver(UpdateProgressActivity.this, new ISaver() {
//            @Override
//            public void onSaveComplete() {
//                i = i + 25;
//                //publishProgress(i+"");
//                if(i==100)
//                    finish();
//            }
//
//            @Override
//            public void onError() {
//
//            }
//        });
//        news_saver.downloadNewsData();
//
//        Word_Saver word_saver = new Word_Saver(UpdateProgressActivity.this, new ISaver() {
//            @Override
//            public void onSaveComplete() {
//                i = i + 25;
//                //publishProgress(i+"");
//                if(i==100)
//                    finish();
//            }
//
//            @Override
//            public void onError() {
//
//            }
//        });
//        word_saver.downloadWordData();
//
//        Meta_Saver meta_saver = new Meta_Saver(UpdateProgressActivity.this, new ISaver() {
//            @Override
//            public void onSaveComplete() {
//                i = i + 25;
//                //publishProgress(i+"");
//                if(i==100)
//                    finish();
//            }
//
//            @Override
//            public void onError() {
//
//            }
//        });
//        meta_saver.downloadMetaData();
//        //return null;



    }
    public class UpdateAsync extends AsyncTask<Void,String,String>
    {
        int i = 0;
        @Override
        protected String doInBackground(Void... voids) {
            i=0;
            publishProgress(i+"");
//            Banner_Saver banner_saver = new Banner_Saver(UpdateProgressActivity.this, new ISaver() {
//                @Override
//                public void onSaveComplete() {
//                    i = i + 25;
//                    publishProgress(i+"");
//                    if(i==100)
//                        finishUpdate();
//                }
//
//                @Override
//                public void onError() {
//
//                }
//            });
//            banner_saver.downloadBanner();


            Group_Saver group_saver = new Group_Saver(UpdateProgressActivity.this, new ISaver() {
                @Override
                public void onSaveComplete() {
                    i = i + 25;
                    publishProgress(i+"");
                    if(i==100)
                        finishUpdate();
                }

                @Override
                public void onError() {

                }
            });
            group_saver.downloadGroupData();

            News_Saver news_saver = new News_Saver(UpdateProgressActivity.this, new ISaver() {
                @Override
                public void onSaveComplete() {
                    i = i + 25;
                    publishProgress(i+"");
                    if(i==100)
                        finishUpdate();
                }

                @Override
                public void onError() {

                }
            });
            news_saver.downloadNewsData();

            Word_Saver word_saver = new Word_Saver(UpdateProgressActivity.this, new ISaver() {
                @Override
                public void onSaveComplete() {
                    i = i + 25;
                    publishProgress(i+"");
                    if(i==100)
                        finishUpdate();
                }

                @Override
                public void onError() {

                }
            });
            word_saver.downloadWordData();

            Meta_Saver meta_saver = new Meta_Saver(UpdateProgressActivity.this, new ISaver() {
                @Override
                public void onSaveComplete() {
                    i = i + 25;
                    publishProgress(i+"");
                    if(i==100)
                        finishUpdate();
                }

                @Override
                public void onError() {

                }
            });
            meta_saver.downloadMetaData();
            return null;
        }

        @SuppressLint("WrongThread")
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            pro_text.setText(values[0].toString()+"%");


        }

        @Override
        protected void onPostExecute(String string) {
            super.onPostExecute(string);
            //pro_text.setText("Done");
        }
    }

    private void finishUpdate()
    {

        Intent i = new Intent(UpdateProgressActivity.this, MainActivityRecyler.class);
        startActivity(i);
    }

}
