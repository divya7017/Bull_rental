package com.example.fullapplication;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

import kotlin.Pair;

public class car_adapter extends RecyclerView.Adapter<car_adapter.carviewholder> {

    private Context context;

    public car_adapter(Context context, ArrayList<allcar_model> car_data) {
        this.context = context;
        this.car_data = car_data;
    }

    ArrayList<allcar_model> car_data;

    @NonNull
    @Override
    public carviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_recylerview,parent,false);
        carviewholder car = new carviewholder(view);
        return car;
    }

    @Override
    public void onBindViewHolder(@NonNull carviewholder holder, int position) {
        holder.car_image.setImageResource(car_data.get(position).img);
        holder.car_recycler.setImageResource(car_data.get(position).img1);
        holder.car_company.setText(car_data.get(position).Company);
        holder.car_model.setText(car_data.get(position).Model);

        holder.car_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int date = calendar.get(Calendar.DATE);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                Intent intent = new Intent(v.getContext(),car_detail.class);
                android.util.Pair<View, String>[] pairs = new android.util.Pair[3];
                pairs[0] = new android.util.Pair<View, String>(holder.car_image, "car_img");
                pairs[1] = new android.util.Pair<View, String>(holder.car_company, "car_company");
                pairs[2] = new android.util.Pair<View, String>(holder.car_model, "car_model");

                intent.putExtra("car_img", car_data.get(position).img);
                intent.putExtra("car_Company", car_data.get(position).Company);
                intent.putExtra("car_Model", car_data.get(position).Model);
                intent.putExtra("car_gear", car_data.get(position).gear);
                intent.putExtra("car_fuel", car_data.get(position).fuel);
                intent.putExtra("car_lugage", car_data.get(position).lugage);
                intent.putExtra("car_seat", car_data.get(position).seat);
                intent.putExtra("car_expensive", car_data.get(position).expensive);
                intent.putExtra("car_medium", car_data.get(position).medium);
                intent.putExtra("car_best", car_data.get(position).best);
                intent.putExtra("date", date);
                intent.putExtra("month", month);
                intent.putExtra("year", year);
                ActivityOptions options;
                options = ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext(), pairs);
                v.getContext().startActivity(intent, options.toBundle());

            }
        });


        // Call animation method
        setanimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {

        return car_data.size();
    }

    public static class carviewholder extends RecyclerView.ViewHolder {

        ImageView car_image, car_recycler;
        TextView car_company, car_model;

        LinearLayout car_intent;


        public carviewholder(@NonNull View itemView) {
            super(itemView);
            car_image =itemView.findViewById(R.id.car_image);
            car_company =itemView.findViewById(R.id.car_company);
            car_model =itemView.findViewById(R.id.car_model);
            car_recycler =itemView.findViewById(R.id.car_recycler);
            car_intent =itemView.findViewById(R.id.car_intent);

        }
    }

    private void setanimation(View viewanimation, int position) {
        if (position > 0) {
            Animation slidein = AnimationUtils.loadAnimation(context, R.anim.recyler);
            viewanimation.startAnimation(slidein);
        }
    }
}
