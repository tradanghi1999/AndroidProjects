package vn.edu.uel.nghiatd17411;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyExitCustiomDialog extends Dialog {

    Button btnYes, btnNo;
    Activity act;

    public MyExitCustiomDialog(@NonNull Activity context) {
        super(context);
        this.act = context;
        this.setContentView(R.layout.my_alert_layout);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.finish();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    private void addControls() {
        btnYes = findViewById(R.id.btn_yes_alert);
        btnNo = findViewById(R.id.btn_no_alert);
        //
        this.setCanceledOnTouchOutside(true);
    }
}
