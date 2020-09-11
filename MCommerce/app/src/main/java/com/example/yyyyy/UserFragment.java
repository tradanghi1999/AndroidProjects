package com.example.yyyyy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class UserFragment extends Fragment {
    @Nullable
    TabLayout userTab;
    LinearLayout userContent;
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.user, container, false);

        userContent = view.findViewById(R.id.userContent);

        userTab = view.findViewById(R.id.userTab);

        userTab.addOnTabSelectedListener(tabListener);

        Fragment selectedFragment;
        selectedFragment = new AccountFragment();
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.userContent, selectedFragment).commit();

        return view;
    }

    private TabLayout.OnTabSelectedListener tabListener
            = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            Fragment selectedFragment;

            userContent.removeAllViews();
            switch (tab.getPosition()) {
                case 0:

                    selectedFragment = new AccountFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.userContent, selectedFragment).commit();


                    break;

                default:
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