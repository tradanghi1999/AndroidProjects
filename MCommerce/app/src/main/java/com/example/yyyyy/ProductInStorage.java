package com.example.yyyyy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProductInStorage extends Fragment {
    @Nullable
    View view;




    public TextView txvProductName;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.choose_product2, container, false);
        //


        txvProductName = (TextView)view.findViewById(R.id.txvProductName);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        String productName = savedInstanceState.getString("productName");
        if(productName!=null)
        {
            txvProductName.setText(productName);
        }
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        String productName = outState.getString("productName");
        if(productName!=null)
        {
            txvProductName.setText(productName);
        }
        super.onSaveInstanceState(outState);
    }


    public void  setProductName(String s)
    {
        txvProductName.setText(s);



}
    }