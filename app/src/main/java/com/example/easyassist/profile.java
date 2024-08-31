package com.example.easyassist;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profile extends AppCompatActivity {
    private TextView profile, worker, out;


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setSelectedItemId(R.id.navigaton_profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.navigation_home) {
                    startActivity(new Intent(getApplicationContext()
                            , home.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                if (id == R.id.navigation_booking) {
                    startActivity(new Intent(getApplicationContext()
                            , mybooking.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                if (id == R.id.navigaton_profile) {
                    startActivity(new Intent(getApplicationContext()
                            , profile.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });
        profile=findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profile.this,myprofile.class);
                startActivity(intent);
            }
        });
        worker=findViewById(R.id.worker);
        worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profile.this,applyworker.class);
                startActivity(intent);
            }
        });
        out=findViewById(R.id.logout);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profile.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}