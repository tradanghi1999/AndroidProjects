package vn.edu.uel.apptudien.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import vn.edu.uel.apptudien.R;
import vn.edu.uel.apptudien.databinding.MessageUpdateLayoutBinding;
import vn.edu.uel.apptudien.presenter.UpdatePresenter;
import vn.edu.uel.apptudien.viewmodel.UpdateModel;

public class UpdateDialogFragment extends DialogFragment {

    UpdateModel updateModel;

    Button up_update_buton;
    Button up_cancle_buton;
    Button up_close_button;
    TextView up_old_version;
    TextView up_new_version;


    public UpdateDialogFragment(UpdateModel updateModel) {
        this.updateModel = updateModel;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        //addControls();
        //addEvents();

                
        return super.onCreateDialog(savedInstanceState);
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        // Get the layout inflater
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//
//        // Inflate and set the layout for the dialog
//        // Pass null as the parent view because its going in the dialog layout
//        builder.setView(inflater.inflate(R.layout.message_update_layout, null))
//                // Add action buttons
//                .setPositiveButton(R.string.update, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        // sign in the user ...
//                    }
//                })
//                .setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        UpdateDialogFragment.this.getDialog().cancel();
//                    }
//                });
//        return builder.create();
    }

    private void addEvents() {
        View.OnClickListener close_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateDialogFragment.this.dismiss();
            }
        };
        up_cancle_buton.setOnClickListener(close_listener);
        up_close_button.setOnClickListener(close_listener);

        //
        View.OnClickListener update_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        };
        up_update_buton.setOnClickListener(update_listener);


    }

    private void update() {
    }

    private void addControls() {
        //added OnCreateView
    }

    private void addControls(View v)
    {
        up_update_buton = v.findViewById(R.id.up_update_button);

        up_cancle_buton = v.findViewById(R.id.up_cancle_btn);
        up_close_button = v.findViewById(R.id.up_close);

        up_old_version = v.findViewById(R.id.up_old_version);
        up_new_version = v.findViewById(R.id.up_new_version);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        MessageUpdateLayoutBinding binding = DataBindingUtil.inflate(inflater,R.layout.message_update_layout,container,false);

        View v = binding.getRoot();
        binding.setUpdateView(updateModel);

        UpdatePresenter updatePresenter = new UpdatePresenter() {
            @Override
            public void updateDatabase() {
                Intent intent = new Intent(updateModel.getView(),UpdateProgressActivity.class);
                startActivity(intent);
                dismiss();
            }
        };
        binding.setUpdatePrstr(updatePresenter);

        // Do all the stuff to initialize your custom view
        addControls(v);
        addEvents();

        return v;
    }




}
