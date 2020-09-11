package com.ungdunguel.appphapluat.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;

import com.ungdunguel.appphapluat.R;

public class InfoDiaLogFragment extends DialogFragment {
    Button info_close_btn;

    public InfoDiaLogFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.info_layout,
                container, false);
        View v = binding.getRoot();
        addControls(v);
        addEvents();
        return v;
    }

    private void addEvents() {
        info_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoDiaLogFragment.this.dismiss();
            }
        });

    }

    private void addControls(View v) {
        info_close_btn = v.findViewById(R.id.info_close);
    }
}