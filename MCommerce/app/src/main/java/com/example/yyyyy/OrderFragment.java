package com.example.yyyyy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;

public class OrderFragment extends Fragment {


    View view;
    TabLayout orderTabControl;
    LinearLayout orderContent;
    TabItem uncofirmedTab, onDeliveryTab, finishedTab, canceledTab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);

        view = inflater.inflate(R.layout.order, container, false);

        orderContent = view.findViewById(R.id.orderContent);
        orderTabControl = view.findViewById(R.id.orderTab);


//        uncofirmedTab = view.findViewById(R.id.unconfirmedTab);
//        onDeliveryTab = view.findViewById(R.id.on_delivery_order);
//        finishedTab = view.findViewById(R.id.finishedTab);
//        canceledTab = view.findViewById(R.id.canceled_order);


        orderTabControl.addOnTabSelectedListener(tabListener);

        for(int i = 0; i < 10; i++)
        {
            Fragment selectedFragment;
            selectedFragment = new OrderUnconfirmedItemFragment();
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.orderContent, selectedFragment).commit();
        }


        return view;


    }


    private OnTabSelectedListener tabListener
            = new OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            Fragment selectedFragment;

            orderContent.removeAllViews();
            switch (tab.getPosition()) {
                case 0:
                    for(int i = 0; i < 10; i++)
                    {
                        selectedFragment = new OrderUnconfirmedItemFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.orderContent, selectedFragment).commit();
                    }

                    break;

                default:
                    for(int i = 0; i < 10; i++)
                    {
                        selectedFragment = new OrderTrackingItemFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.orderContent, selectedFragment).commit();
                    }

                    break;
            }

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }


    };
}
