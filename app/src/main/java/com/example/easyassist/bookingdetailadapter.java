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

public class bookingdetailadapter extends RecyclerView.Adapter<bookingdetailadapter.ViewHolder> {
    Context context;
    ArrayList<bookingdetailModel> arrbookingdetails;

    bookingdetailadapter(Context context, ArrayList<bookingdetailModel> arrbookingdetails) {
        this.context = context;
        this.arrbookingdetails = arrbookingdetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.bookingdetail_row,parent,false);
        bookingdetailadapter.ViewHolder viewHolder = new bookingdetailadapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtclient.setText(arrbookingdetails.get(position).client);
        holder.txtclientname.setText(arrbookingdetails.get(position).clientname);

    }

    @Override
    public int getItemCount() {
        return arrbookingdetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtclient, txtclientname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtclient = itemView.findViewById(R.id.client);
            txtclientname = itemView.findViewById(R.id.clientname);
        }
    }
}