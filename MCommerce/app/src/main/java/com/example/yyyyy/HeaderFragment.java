package com.example.yyyyy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HeaderFragment extends Fragment {
    @Nullable
    ImageButton btnWarehouse;
    ImageButton btnNontification;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.header, container, false);

    //addControls();
    //addEvents();
        return view;
}

    private void addEvents() {
        btnWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View header = (View)btnWarehouse.getParent().getParent().getParent();
                View main =(View)header.getParent().getParent();

                View mainContent = (View) main.findViewById(R.id.content);

                if(mainContent!=null)
                {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(mainContent.getId(), new WarehouseFragment()).commit();
                }
            }
        });
    }

    private void addControls()
    {
        btnWarehouse = view.findViewById(R.id.btn_warehouse);
        btnNontification = view.findViewById(R.id.btn_notification);
    }
}