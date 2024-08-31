package com.example.easyassist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class mybooking extends AppCompatActivity {
    private ImageView notification,bookingprofile;
    BottomNavigationView bottomNavigationView;

    ArrayList<mybookingmodel> arrmybookings = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mybooking);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerview2);

        recyclerView2.setLayoutManager(new LinearLayoutManager(this));


        arrmybookings.add(new mybookingmodel(R.drawable.electrician,"Electrician","2000","Running"));
        arrmybookings.add(new mybookingmodel(R.drawable.plumbing,"Plumber","2000","Running"));
        arrmybookings.add(new mybookingmodel(R.drawable.mechanic,"Mechanic","5000","Running"));
        arrmybookings.add(new mybookingmodel(R.drawable.repair,"Ac Repair","6000","Running"));

        mybookingadapter adapter = new mybookingadapter(this,arrmybookings);
        recyclerView2.setAdapter(adapter);

        bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setSelectedItemId(R.id.navigation_booking);
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
        notification=findViewById(R.id.imageView12);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mybooking.this, notification.class);
                startActivity(intent);
            }
        });
        bookingprofile=findViewById(R.id.imageView15);
        bookingprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mybooking.this,myprofile.class);
                startActivity(intent);
            }
        });

        }
    }
