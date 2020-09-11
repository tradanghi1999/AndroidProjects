package vn.edu.uel.apptudien.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;

import vn.edu.uel.apptudien.R;
import vn.edu.uel.apptudien.databinding.MessageUpdateLayoutBinding;

public class InfoDiaLogFragment extends DialogFragment {
    Button info_close_btn;

    public InfoDiaLogFragment() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewDataBinding binding = DataBindingUtil.inflate(inflater,R.layout.info_layout,container,false);

        View v = binding.getRoot();
        //View v = super.onCreateView(inflater, container, savedInstanceState);
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
