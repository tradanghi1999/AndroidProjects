package vn.edu.uel.nghiatd17411;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyExitCustiomDialog dialog = new MyExitCustiomDialog(MainActivity.this);
                dialog.show();
            }
        });
    }

    private void addControls() {
        btnImg =(ImageButton)(findViewById(R.id.btn_img_asus));
    }
}
