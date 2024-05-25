package com.example.fullapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class location_adapter extends RecyclerView.Adapter<location_adapter.locationviewholder> {
    ArrayList<lacation_model> locationdata;

    public location_adapter(ArrayList<lacation_model> locationdata) {
        this.locationdata = locationdata;
    }

    @NonNull
    @Override
    public locationviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_recyclerview,parent,false);
        locationviewholder location = new locationviewholder(view);
        return location;
    }

    @Override
    public void onBindViewHolder(@NonNull locationviewholder holder, int position) {
        holder.location_image.setImageResource(locationdata.get(position).image);
        holder.location_name.setText(locationdata.get(position).tittle);
        holder.location_about.setText(locationdata.get(position).description);
    }

    @Override
    public int getItemCount() {
        return locationdata.size();
    }


    public static class locationviewholder extends RecyclerView.ViewHolder {

        ImageView location_image;
        TextView location_name , location_about;
        public locationviewholder(@NonNull View itemView) {
            super(itemView);
            location_image = itemView.findViewById(R.id.location_image);
            location_name = itemView.findViewById(R.id.location_name);
            location_about = itemView.findViewById(R.id.location_about);
        }
    }
}
