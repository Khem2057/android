package com.example.easyassist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class booking extends AppCompatActivity {

    ArrayList<bookingModel> arrbookings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        arrbookings.add(new bookingModel(R.drawable.plumbing,"plumber","2000"));
        arrbookings.add(new bookingModel(R.drawable.electrician,"electrician","2000"));
        arrbookings.add(new bookingModel(R.drawable.mechanic,"mechanic","2000"));
        arrbookings.add(new bookingModel(R.drawable.cleaning,"cleaning","2000"));
        arrbookings.add(new bookingModel(R.drawable.technician,"technician","2000"));
        arrbookings.add(new bookingModel(R.drawable.repair,"Ac repair","2000"));

        bookingAdapter adapter = new bookingAdapter(this,arrbookings);
        recyclerView.setAdapter(adapter);
    }
}