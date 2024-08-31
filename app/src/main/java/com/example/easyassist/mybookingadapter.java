package com.example.easyassist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mybookingadapter extends RecyclerView.Adapter<mybookingadapter.ViewHolder> {
    Context context;
    ArrayList<mybookingmodel> arrmybookings;

    mybookingadapter(Context context, ArrayList<mybookingmodel> arrmybookings) {
        this.context = context;
        this.arrmybookings = arrmybookings;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.mybooking_row,parent,false);
        mybookingadapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        mybookingmodel booking = arrmybookings.get(position);

        holder.imagetype.setImageResource(arrmybookings.get(position).img);
        holder.txttypename.setText(arrmybookings.get(position).type);
        holder.txtprice.setText(arrmybookings.get(position).price);
        holder.txtstatus.setText(arrmybookings.get(position).status);

        holder.itemView.setOnClickListener(v -> {
            // Create an intent to start the new activity
            Intent intent = new Intent(context, bookingdetails.class);

            // Pass the booking details to the new activity
            intent.putExtra("BOOKING_ID", booking.img);
            intent.putExtra("BOOKING_TYPE", booking.type);
            intent.putExtra("BOOKING_PRICE", booking.price);
            intent.putExtra("BOOKING_STATUS", booking.status);

            // Start the new activity
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return arrmybookings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttypename, txtprice, txtstatus;
        ImageView imagetype;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttypename = itemView.findViewById(R.id.typename);
            txtprice = itemView.findViewById(R.id.price);
            imagetype = itemView.findViewById(R.id.imagetype);
            txtstatus = itemView.findViewById(R.id.btn_status);
        }
    }
}

