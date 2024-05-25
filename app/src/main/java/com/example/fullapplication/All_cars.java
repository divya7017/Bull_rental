package com.example.fullapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class All_cars extends AppCompatActivity {

    RecyclerView all_car_recyclerview;
    TextView viewdetail;

    RecyclerView.Adapter adapter;


    ArrayList<allcar_model>allcar_data = new ArrayList<>();

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cars);
        all_car_recyclerview = findViewById(R.id.all_car_recyclerview);

        all_car_recyclerview();

    }



    private void all_car_recyclerview() {
        all_car_recyclerview.setHasFixedSize(true);
        all_car_recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        allcar_data.add(new allcar_model(R.drawable.hyundai_creta,"Hyundai","Hyundai Creta","Automatic","Petrol","2 Baggage","5 Seater","₹5000","₹6500","₹8000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.mahindra_xuv_3001,"Mahindra","Mahindra TUV 300","Manual","Diesel","2 Baggage","7 Seater","₹4500","₹6000","₹7500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.toyota_innova_crysta,"Toyota","Toyota Innova Crysta","Automatic","Diesel","3 Baggage","7 Seater","₹5500","₹7000","₹8500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.scorpio,"Mahindra","Mahindra Scorpio","Manual","Diesel","2 Baggage","7 Seater","₹6000","₹7500","₹9000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.maruti_vitara_brezza,"Maruti","Maruti Vitara Brezza","Automatic","Petrol","2 Baggage","5 Seater","₹4800","₹6200","₹7500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.ford_ecosport,"Ford","Ford Ecosport","Manual","Petrol","2 Baggage","5 Seater","₹5000","₹6500","₹8000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.maruti_ertiga_hybrid,"Maruti","Maruti Ertiga Hybrid","Automatic","Petrol","2 Baggage","7 Seater","₹5500","₹7000","₹8500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.mahindra_kuv_100,"Mahindra","Mahindra KUV 100","Manual","Diesel","2 Baggage","6 Seater","₹3500","₹4500","₹5500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.maruti_baleno,"Maruti","Maruti Baleno","Manual","Diesel","2 Baggage","5 Seater","₹3200","₹4200","₹5200",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.hyundai_i20,"Hyundai","Hyundai I20","Manual","Petrol","2 Baggage","5 Seater","₹4500","₹6000","₹7500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.hyundai_verna,"Hyundai","Hyundai Verna","Automatic","Petrol","2 Baggage","5 Seater","₹4800","₹6200","₹7500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.maruti_swift_dzire,"Maruti","Maruti Swift Dzire","Manual","Petrol","2 Baggage","5 Seater","₹4200","₹5500","₹6800",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.honda_amaze,"Honda","Honda Amaze","Automatic","Petrol","2 Baggage","5 Seater","₹4900","₹6400","₹7900",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.honda_city,"Honda","Honda City","Manual","Petrol","2 Baggage","5 Seater","₹5200","₹6800","₹8500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.hyundai_xcent,"Hyundai","Hyundai Xcent","Manual","Petrol","2 Baggage","5 Seater","₹4300","₹5600","₹6900",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.hyundai_grand_i10,"Hyundai","Hyundai Grand I10","Manual","Petrol","2 Baggage","5 Seater","₹4100","₹5400","₹6700",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.ford_figo_aspire,"Ford","Ford Figo Aspire","Manual","Petrol","2 Baggage","5 Seater","₹4200","₹5500","₹6800",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.toyota_innova,"Toyota","Toyota Innova","Manual","Diesel","3 Baggage","7 Seater","₹5800","₹7300","₹8800",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.toyota_etios,"Toyota","Toyota Etios","Manual","Petrol","2 Baggage","5 Seater","₹4500","₹6000","₹7500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.hyundai_elite_i20,"Hyundai","Hyundai Elite I20","Manual","Petrol","2 Baggage","5 Seater","₹4300","₹5600","₹6900",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.suzuki_s_cross,"Suzuki","Suzuki S Cross","Manual","Petrol","2 Baggage","5 Seater","₹4700","₹6200","₹7700",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.toyota_etios,"Toyota","Toyota Etios Liva","Manual","Petrol","2 Baggage","5 Seater","₹4200","₹5500","₹6800",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.mahindra_xuv_500,"Mahindra","Mahindra XUV 500","Automatic","Diesel","3 Baggage","7 Seater","₹6500","₹8000","₹9500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.maruti_swift,"Maruti","Maruti Swift","Manual","Diesel","2 Baggage","5 Seater","₹5300","₹6800","₹8300",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.toyota_fortuner,"Toyota","Toyota Fortuner","Automatic","Diesel","3 Baggage","7 Seater","₹6800","₹8300","₹9800",R.drawable.car_wash));


        adapter = new allcar_adapter(this,allcar_data);
        all_car_recyclerview.setAdapter(adapter);

    }
}