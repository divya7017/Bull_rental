package com.example.fullapplication;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import kotlin.Pair;

public class allcar_adapter extends RecyclerView.Adapter<allcar_adapter.allcarviewholder> {
    private Context context;
    int lastpostiton = -1;
    ArrayList<allcar_model>allcar_data;

    public allcar_adapter(Context context,ArrayList<allcar_model> allcar_data) {

        this.allcar_data = allcar_data;
        this.context=context;
    }



    @NonNull
    @Override
    public allcarviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allcar,parent,false);
        allcarviewholder car = new allcarviewholder(view);
        return car;
    }

    @Override
    public void onBindViewHolder(@NonNull allcarviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.allcar_img.setImageResource(allcar_data.get(position).img);
        holder.allcar_comapny.setText(allcar_data.get(position).Company);
        holder.allcar_model.setText(allcar_data.get(position).Model);
        holder.gear.setText(allcar_data.get(position).gear);
        holder.fuel.setText(allcar_data.get(position).fuel);
        holder.lugage.setText(allcar_data.get(position).lugage);
        holder.seat.setText(allcar_data.get(position).seat);
        holder.expensive.setText(allcar_data.get(position).expensive);
        holder.medium.setText(allcar_data.get(position).medium);
        holder.best.setText(allcar_data.get(position).best);



        holder.allcar_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int date = calendar.get(Calendar.DATE);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                Intent intent = new Intent(v.getContext(), car_detail.class);
                android.util.Pair<View, String>[] pairs = new android.util.Pair[15];
                pairs[0] = new android.util.Pair<View, String>(holder.allcar_img, "car_img");
                pairs[1] = new android.util.Pair<View, String>(holder.allcar_comapny, "car_company");
                pairs[2] = new android.util.Pair<View, String>(holder.allcar_model, "car_model");
                pairs[3] = new android.util.Pair<View, String>(holder.gear, "gear_name");
                pairs[4] = new android.util.Pair<View, String>(holder.fuel, "fuel_name");
                pairs[5] = new android.util.Pair<View, String>(holder.lugage, "lugage_name");
                pairs[6] = new android.util.Pair<View, String>(holder.seat, "seat_name");
                pairs[7] = new android.util.Pair<View, String>(holder.expensive, "car_expensive");
                pairs[8] = new android.util.Pair<View, String>(holder.medium, "car_medium");
                pairs[9] = new android.util.Pair<View, String>(holder.best, "car_best");
                pairs[10] = new android.util.Pair<View, String>(holder.allcar_intent, "book_now");
                pairs[11] = new android.util.Pair<View, String>(holder.gear_img, "gear_img");
                pairs[12] = new android.util.Pair<View, String>(holder.fuel_img, "fuel_img");
                pairs[13] = new android.util.Pair<View, String>(holder.lugage_img, "signup_switch");
                pairs[14] = new android.util.Pair<View, String>(holder.seat_img, "seat_img");

                intent.putExtra("car_img", allcar_data.get(position).img);
                intent.putExtra("car_Company", allcar_data.get(position).Company);
                intent.putExtra("car_Model", allcar_data.get(position).Model);
                intent.putExtra("car_gear", allcar_data.get(position).gear);
                intent.putExtra("car_fuel", allcar_data.get(position).fuel);
                intent.putExtra("car_lugage", allcar_data.get(position).lugage);
                intent.putExtra("car_seat", allcar_data.get(position).seat);
                intent.putExtra("car_expensive", allcar_data.get(position).expensive);
                intent.putExtra("car_medium", allcar_data.get(position).medium);
                intent.putExtra("car_best", allcar_data.get(position).best);
                intent.putExtra("date", date);
                intent.putExtra("month", month);
                intent.putExtra("year", year);
                ActivityOptions options;
                options = ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext(), pairs);
                v.getContext().startActivity(intent, options.toBundle());
            }
        });
        holder.allcar_expensive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.allcar_expensive.setBackgroundResource(R.drawable.border_colour);
                holder.allcar_best.setBackgroundResource(R.drawable.border3);
                holder.allcar_medium.setBackgroundResource(R.drawable.border3);
            }
        });

        holder.allcar_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.allcar_expensive.setBackgroundResource(R.drawable.border3);
                holder.allcar_best.setBackgroundResource(R.drawable.border3);
                holder.allcar_medium.setBackgroundResource(R.drawable.border_colour);
            }
        });
        holder.allcar_best.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.allcar_expensive.setBackgroundResource(R.drawable.border3);
                holder.allcar_best.setBackgroundResource(R.drawable.border_colour);
                holder.allcar_medium.setBackgroundResource(R.drawable.border3);
            }
        });

        setanimation(holder.itemView,position);

    }

    @Override
    public int getItemCount() {
        return allcar_data.size();
    }

    public static class allcarviewholder extends RecyclerView.ViewHolder{

        ImageView allcar_img, gear_img,fuel_img,lugage_img,seat_img;
        TextView allcar_comapny, allcar_model, gear, fuel, lugage, seat, expensive, medium, best;
        AppCompatButton allcar_intent;

        RelativeLayout allcar_expensive,allcar_medium,allcar_best;

        public allcarviewholder(@NonNull View itemView) {
            super(itemView);
            allcar_img=itemView.findViewById(R.id.allcar_img);
            allcar_comapny=itemView.findViewById(R.id.allcar_comapny);
            allcar_model=itemView.findViewById(R.id.allcar_model);
            allcar_intent = itemView.findViewById(R.id.allcar_intent);
            fuel = itemView.findViewById(R.id.fuel);
            gear = itemView.findViewById(R.id.gear);
            lugage = itemView.findViewById(R.id.lugage);
            seat = itemView.findViewById(R.id.seat);
            expensive = itemView.findViewById(R.id.Expensive_price);
            medium = itemView.findViewById(R.id.medium_price);
            best = itemView.findViewById(R.id.best_price);
            allcar_expensive = itemView.findViewById(R.id.allcar_expensive);
            allcar_medium = itemView.findViewById(R.id.allcar_medium);
            allcar_best = itemView.findViewById(R.id.allcar_best);
            gear_img = itemView.findViewById(R.id.gear_img);
            fuel_img = itemView.findViewById(R.id.fuel_img);
            lugage_img = itemView.findViewById(R.id.lugage_img);
            seat_img = itemView.findViewById(R.id.seat_img);

        }
    }
    private void setanimation(View viewanimation, int position) {

        if(position > lastpostiton) {
            Animation slidein = AnimationUtils.loadAnimation(context, R.anim.recyler);
            viewanimation.startAnimation(slidein);
            lastpostiton=position;
        }

    }


}
