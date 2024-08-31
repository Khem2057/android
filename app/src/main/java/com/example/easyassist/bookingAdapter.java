package com.example.easyassist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class bookingAdapter extends RecyclerView.Adapter<bookingAdapter.ViewHolder> {
    Context context;
    ArrayList<bookingModel> arrbookings;
    bookingAdapter(Context context, ArrayList<bookingModel> arrbookings){
        this.context = context;
        this.arrbookings = arrbookings;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.booking_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imagetype.setImageResource(arrbookings.get(position).img);
        holder.txttypename.setText(arrbookings.get(position).type);
        holder.txtprice.setText(arrbookings.get(position).price);


    }

    @Override
    public int getItemCount() {
        return arrbookings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttypename , txtprice;
        ImageView imagetype;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttypename = itemView.findViewById(R.id.typename);
            txtprice = itemView.findViewById(R.id.price);
            imagetype = itemView.findViewById(R.id.imagetype);


        }
    }
}
