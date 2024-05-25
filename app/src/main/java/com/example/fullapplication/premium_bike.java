package com.example.fullapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class premium_bike extends AppCompatActivity {

    RecyclerView premium_bike_recycler;
    RecyclerView.Adapter adapter;

    ArrayList<allcar_model>allcar_data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_bike);

        premium_bike_recycler =findViewById(R.id.premium_bike_recycler);

        premium_bike_recycler();
    }

    private void premium_bike_recycler() {

        premium_bike_recycler.setHasFixedSize(true);
        premium_bike_recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        allcar_data.add(new allcar_model(R.drawable.kawasaki_ninja_image,"Kawasaki","Ninja","Sports","Petrol","₹500000","₹700000","₹1000000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.royal_enfield_bullet_image,"Royal Enfield","Bullet","Cruiser","Petrol","₹300000","₹400000","₹500000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.ktm_duke_image,"KTM","Duke","Street","Petrol","₹400000","₹600000","₹800000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.bmw_bike_image,"BMW","S1000RR","Sports","Petrol","₹800000","₹1200000","₹1500000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.ducati_bike_image,"Ducati","Panigale V4","Sports","Petrol","₹900000","₹1500000","₹2000000",R.drawable.bycicle1));
// Add more premium bikes here
        allcar_data.add(new allcar_model(R.drawable.kawasaki_versys_image,"Kawasaki","Versys","Adventure","Petrol","₹900000","₹1200000","₹1500000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.triumph_bonneville_image,"Triumph","Bonneville","Cruiser","Petrol","₹800000","₹1100000","₹1400000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.ducati_diavel_image,"Ducati","Diavel","Cruiser","Petrol","₹1600000","₹2000000","₹2500000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.suzuki_gsx_s1000_image,"Suzuki","GSX-S1000","Street","Petrol","₹1000000","₹1300000","₹1600000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.yamaha_mt_10_image,"Yamaha","MT-10","Street","Petrol","₹950000","₹1250000","₹1550000",R.drawable.bycicle1));
// Add more premium bikes here
        allcar_data.add(new allcar_model(R.drawable.ducati_hypermotard_image,"Ducati","Hypermotard","Supermoto","Petrol","₹1400000","₹1700000","₹2000000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.ktm_1290_super_duke_image,"KTM","1290 Super Duke","Street","Petrol","₹1300000","₹1600000","₹1900000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.bmw_r_1250_gs_image,"BMW","R 1250 GS","Adventure","Petrol","₹1700000","₹2000000","₹2400000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.triumph_tiger_1200_image,"Triumph","Tiger 1200","Adventure","Petrol","₹1500000","₹1800000","₹2200000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.harley_davidson_fat_boy_image,"Harley Davidson","Fat Boy","Cruiser","Petrol","₹1800000","₹2200000","₹2600000",R.drawable.bycicle1));
// Add more premium bikes here
        allcar_data.add(new allcar_model(R.drawable.bmw_s_1000_rr_image,"BMW","S 1000 RR","Sports","Petrol","₹1800000","₹2200000","₹2600000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.ducati_streetfighter_v4_image,"Ducati","Streetfighter V4","Street","Petrol","₹2000000","₹2400000","₹2800000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.harley_davidson_iron_883_image,"Harley Davidson","Iron 883","Cruiser","Petrol","₹1500000","₹1800000","₹2100000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.triumph_speed_triple_image,"Triumph","Speed Triple","Street","Petrol","₹1600000","₹1900000","₹2200000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.yamaha_yzf_r6_image,"Yamaha","YZF-R6","Sports","Petrol","₹1400000","₹1700000","₹2000000",R.drawable.bycicle1));
// Add more premium bikes here
        allcar_data.add(new allcar_model(R.drawable.kawasaki_z_h2_image,"Kawasaki","Z H2","Naked","Petrol","₹1900000","₹2300000","₹2700000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.bmw_r_nine_t_image,"BMW","R Nine T","Cruiser","Petrol","₹1700000","₹2000000","₹2300000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.ducati_panigale_v2_image,"Ducati","Panigale V2","Sports","Petrol","₹1900000","₹2300000","₹2700000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.harley_davidson_cvo_street_glide_image,"Harley Davidson","CVO Street Glide","Cruiser","Petrol","₹2200000","₹2600000","₹3000000",R.drawable.bycicle1));
        allcar_data.add(new allcar_model(R.drawable.triumph_bonneville_t120_image,"Triumph","Bonneville T120","Cruiser","Petrol","₹1500000","₹1800000","₹2100000",R.drawable.bycicle1));
        adapter = new allcar_adapter(this,allcar_data);
        premium_bike_recycler.setAdapter(adapter);
    }
}