package com.example.yyyyy;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity{


    ImageButton btnWarehouse;
    ImageButton btnNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, new HomepageFragment(), "content").commit();

        btnWarehouse = findViewById(R.id.btn_warehouse);
        addEvents();
    }

    private void addEvents() {

        btnWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment selectedFragment = null;
                selectedFragment = new WarehouseFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new WarehouseFragment(), "content").commit();
            }
        });
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()) {
                case R.id.action_home:
                    selectedFragment = new HomepageFragment();
                    break;
                case R.id.action_order:
                    selectedFragment = new OrderFragment();
                    break;
                case R.id.action_feedback:
                    selectedFragment = new FeedbackFragment();
                    break;
                case R.id.action_report:
                    selectedFragment = new ReportFragment();
                    break;
                case R.id.action_user:
                    selectedFragment = new UserFragment();
                    break;
                default:
                    selectedFragment = new HomepageFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.content, selectedFragment).commit();
            return true;
        }
    };


}
