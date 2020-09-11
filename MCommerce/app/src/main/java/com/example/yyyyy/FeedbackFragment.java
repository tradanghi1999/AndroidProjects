package com.example.yyyyy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class FeedbackFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.feedback, container, false);

        TabLayout tabs = view.findViewById(R.id.feedbackTabs);
        tabs.addOnTabSelectedListener(tabListener);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.feedbackContent,  new FeedbackAllNewFragment()).commit();

        return view;
    }

    private TabLayout.OnTabSelectedListener tabListener
            = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            Fragment selectedFragment;
            switch (tab.getPosition()){
                case 0:
                    selectedFragment = new FeedbackAllNewFragment();
                    break;
                case 1:
                    selectedFragment = new FeedbackCommentFragment();
                    break;
                case 2:
                    selectedFragment = new FeedbackRatingFragment();
                    break;
                case 3:
                    selectedFragment = new FeedbackChatFragment();
                    break;
                default:
                    selectedFragment = new FeedbackAllNewFragment();
                    break;
            }
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.feedbackContent, selectedFragment).commit();
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

}