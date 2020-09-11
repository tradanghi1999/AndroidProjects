package com.example.yyyyy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WarehouseFragment extends Fragment {
    @Nullable
    LinearLayout productsZone;
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.warehouse, container, false);

        productsZone = view.findViewById(R.id.productZoneInWarehouse);

        fakeData(productsZone);


        return view;
    }


    //ProductInStorage product2;

    @Override
    public void onStart() {
        super.onStart();

      //  Bundle bundle = new Bundle();
        // bundle.putString("productName", "Xaomi");
        //product2.setArguments(bundle);
    }

    private void fakeData(LinearLayout productsZone) {

        //productsZone.removeAllViews();

        ProductInStorage product1 = new ProductInStorage();
        getActivity().getSupportFragmentManager().beginTransaction().add(productsZone.getId(), product1).commit();


        Bundle bundle = new Bundle();
        bundle.putString("productName", "Xaomi");

        ProductInStorage product2 = new ProductInStorage();
        product2.setArguments(bundle);


//        product2.setImgId(R.mipmap.storage_product1);
//        product2.setProductName("Xiaomi Redmi Note 8 ");
  //      product2.setPriceInHouse("3,299,000đ");
    //    product2.setPriceOnSale("4,299,000đ");
      //  product2.setDes("Color Family blue,\nStorage Capacity 64GB");

        getActivity().getSupportFragmentManager().beginTransaction().add(productsZone.getId(), product2).commit();


//        Bundle bundle = new Bundle();
//        bundle.putString("productName", "Xaomi");
//        product2.setArguments(bundle);

        //product2.setProductName("Tran dai nghia");



    }


}