package com.example.yyyyy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomepageMarketplaceFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.marketplace_mini, container, false);

        //procecss

        Button btnShopee = view.findViewById(R.id.btnShopee);
        btnShopee.setOnClickListener(this);

        Button btnSendo = view.findViewById(R.id.btnSendo);
        btnSendo.setOnClickListener(this);

        Button btnTiki = view.findViewById(R.id.btnTiki);
        btnTiki.setOnClickListener(this);

        Button btnLaz = view.findViewById(R.id.btnLaz);
        btnLaz.setOnClickListener(this);

        return view;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btnShopee: {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://shopee.vn/"));
                startActivity(intent);
                break;
            }

            case R.id.btnSendo: {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sendo.vn/?modal=loginModal"));
                startActivity(intent);
                break;
            }

            case  R.id.btnTiki: {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tiki.vn/?utm_source=google&utm_medium=cpc&utm_campaign=SEA_YBR_GGL_TXT_SBR_ALL_VN_ALL_UNK_UNK_C.ALL_X.7602151122_Y.80058006606_Q.e_K.Tiki_W.DT_R.392788512413_L.HP&gclid=EAIaIQobChMI-K7J55-15gIVi2kqCh2ZmA_6EAAYASAAEgKanfD_BwE"));
                startActivity(intent);
                break;
            }

            case R.id.btnLaz: {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://member.lazada.vn/user/login?spm=a2o4n.main.header.d5.23ebe182C8T7HT&redirect=https%3A%2F%2Fwww.lazada.vn%2F%23hp-collections"));
                startActivity(intent);
                break;
            }
            //.... etc
        }
    }
}
