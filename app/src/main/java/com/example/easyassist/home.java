package com.example.easyassist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class home extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")

    BottomNavigationView bottomNavigationView;
    private TextView service;

    private ImageView notification,homeprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        service=findViewById(R.id.plumber);
        notification=findViewById(R.id.imageView16);
        homeprofile=findViewById(R.id.imageView17);

        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel("https://media.istockphoto.com/id/1069568218/photo/electrician-mounting-sockets-indoors.jpg?s=1024x1024&w=is&k=20&c=lzFJVsbzzTXQhThuse3lBECppjVz0ZzFpXVtTOvv_P8=", "Electrician.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://t3.ftcdn.net/jpg/00/27/61/68/360_F_27616800_mP42aLqY152iln3kHDTiAvlMrDoYU606.jpg", "Plumber.",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://www.nobroker.in/blog/wp-content/uploads/2024/04/home-cleaning-service-apps.jpg", "Cleaning.",ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home.this, service.class);
                startActivity(intent);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home.this,notification.class);
                startActivity(intent);
            }
        });
        homeprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home.this,myprofile.class);
                startActivity(intent);
            }
        });

        bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
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

    }
}