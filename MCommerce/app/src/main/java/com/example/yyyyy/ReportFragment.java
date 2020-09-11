package com.example.yyyyy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class ReportFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.report, container, false);

        TabLayout tabs = view.findViewById(R.id.reportTabs);
        tabs.addOnTabSelectedListener(tabListener);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.reportContent,  new ReportStatisticFragment()).commit();

        return view;
    }

    private TabLayout.OnTabSelectedListener tabListener
            = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            Fragment selectedFragment;
            switch (tab.getPosition()){
                case 0:
                    selectedFragment = new ReportStatisticFragment();
                    break;
                case 1:
                    selectedFragment = new ReportPaymentFragment();
                    break;
                default:
                    selectedFragment = new ReportStatisticFragment();
                    break;
            }
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.reportContent, selectedFragment).commit();
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

}