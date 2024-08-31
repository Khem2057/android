package com.example.easyassist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class bookingdetails extends AppCompatActivity {
    private Button bookingconfirm, bookingcancel;
    private TextView bookingdetailarrow;


    ArrayList<bookingdetailModel> arrbookingdetails = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bookingdetails);
        RecyclerView recyclerView1 = findViewById(R.id.recyclerview1);

        recyclerView1.setLayoutManager(new LinearLayoutManager(this));


        arrbookingdetails.add(new bookingdetailModel("Name:","Kajal Magar"));
        arrbookingdetails.add(new bookingdetailModel("Phone no:" ,"98********"));
        arrbookingdetails.add(new bookingdetailModel("Email:" ,"thapakajal061@gmail.com"));
        arrbookingdetails.add(new bookingdetailModel("Description:" ,"Pipe leakage"));


        bookingdetailadapter adapter = new bookingdetailadapter(this,arrbookingdetails);
        recyclerView1.setAdapter(adapter);

        bookingconfirm=findViewById(R.id.cancel);
        bookingconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bookingdetails.this,mybooking.class);
                startActivity(intent);
            }
        });

        bookingcancel=findViewById(R.id.cancel);
        bookingcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bookingdetails.this,home.class);
                startActivity(intent);
            }
        });
        bookingdetailarrow=findViewById(R.id.bookingd);
        bookingdetailarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bookingdetails.this,mybooking.class);
                startActivity(intent);
            }
        });
        }
    }
