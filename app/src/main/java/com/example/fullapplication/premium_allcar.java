package com.example.fullapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class premium_allcar extends AppCompatActivity {

    RecyclerView premium_cardata;

    RecyclerView.Adapter adapter;

    ArrayList<allcar_model>allcar_data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_allcar);
        premium_cardata = findViewById(R.id.premium_cardata);

        premium_cardata();
    }

    private void premium_cardata() {
        premium_cardata.setHasFixedSize(true);
        premium_cardata.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        allcar_data.add(new allcar_model(R.drawable.audi_a8,"Audi","Audi A8","Automatic","Petrol","3 Baggage","5 Seater","₹10000","₹15000","₹20000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.mercedes_benz_s_class,"Mercedes-Benz","Mercedes-Benz S-Class","Automatic","Petrol","3 Baggage","5 Seater","₹12000","₹18000","₹25000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.bentley_continental_gt,"Bentley","Bentley Continental GT","Automatic","Petrol","2 Baggage","4 Seater","₹25000","₹35000","₹45000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.aston_martin_db11,"Aston Martin","Aston Martin DB11","Automatic","Petrol","2 Baggage","4 Seater","₹20000","₹30000","₹40000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.jaguar_f_type,"Jaguar","Jaguar F-Type","Automatic","Petrol","2 Baggage","2 Seater","₹15000","₹22000","₹30000",R.drawable.car_wash));
// Add more premium cars here
        allcar_data.add(new allcar_model(R.drawable.audi_a7,"Audi","Audi A7","Automatic","Petrol","3 Baggage","5 Seater","₹9500","₹14000","₹19000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.mercedes_benz_e_class,"Mercedes-Benz","Mercedes-Benz E-Class","Automatic","Petrol","3 Baggage","5 Seater","₹10000","₹15000","₹22000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.bentley_flying_spur,"Bentley","Bentley Flying Spur","Automatic","Petrol","2 Baggage","5 Seater","₹30000","₹40000","₹50000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.aston_martin_vantage,"Aston Martin","Aston Martin Vantage","Automatic","Petrol","2 Baggage","2 Seater","₹16000","₹24000","₹32000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.jaguar_xj,"Jaguar","Jaguar XJ","Automatic","Petrol","3 Baggage","5 Seater","₹12000","₹18000","₹25000",R.drawable.car_wash));
// Add more premium cars here
        allcar_data.add(new allcar_model(R.drawable.audi_q8,"Audi","Audi Q8","Automatic","Petrol","3 Baggage","5 Seater","₹10000","₹15000","₹20000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.mercedes_benz_g_class,"Mercedes-Benz","Mercedes-Benz G-Class","Automatic","Petrol","3 Baggage","5 Seater","₹13000","₹20000","₹30000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.bentley_bentayga,"Bentley","Bentley Bentayga","Automatic","Petrol","3 Baggage","5 Seater","₹35000","₹45000","₹55000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.aston_martin_dbx,"Aston Martin","Aston Martin DBX","Automatic","Petrol","3 Baggage","5 Seater","₹25000","₹35000","₹45000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.jaguar_i_pace,"Jaguar","Jaguar I-Pace","Automatic","Electric","3 Baggage","5 Seater","₹18000","₹25000","₹35000",R.drawable.car_wash));
// Add more premium cars here
        allcar_data.add(new allcar_model(R.drawable.audi_r8,"Audi","Audi R8","Automatic","Petrol","2 Baggage","2 Seater","₹20000","₹30000","₹40000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.mercedes_amg_gt,"Mercedes-Benz","Mercedes-AMG GT","Automatic","Petrol","2 Baggage","2 Seater","₹22000","₹32000","₹45000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.bentley_mulsanne,"Bentley","Bentley Mulsanne","Automatic","Petrol","3 Baggage","5 Seater","₹45000","₹60000","₹75000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.aston_martin_rapide,"Aston Martin","Aston Martin Rapide","Automatic","Petrol","3 Baggage","5 Seater","₹30000","₹45000","₹60000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.jaguar_f_pace,"Jaguar","Jaguar F-Pace","Automatic","Petrol","3 Baggage","5 Seater","₹20000","₹28000","₹38000",R.drawable.car_wash));
// Add more premium cars here
        allcar_data.add(new allcar_model(R.drawable.audi_q7,"Audi","Audi Q7","Automatic","Petrol","3 Baggage","7 Seater","₹6000","₹9000","₹14000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.mercedes_benz_cls_class,"Mercedes-Benz","Mercedes-Benz CLS-Class","Automatic","Petrol","2 Baggage","5 Seater","₹5700","₹8200","₹12500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.bentley_bentley_arnage,"Bentley","Bentley Arnage","Automatic","Petrol","3 Baggage","5 Seater","₹13000","₹19000","₹24000",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.aston_martin_dbs_superleggera,"Aston Martin","Aston Martin DBS Superleggera","Automatic","Petrol","2 Baggage","2 Seater","₹8500","₹12500","₹18500",R.drawable.car_wash));
        allcar_data.add(new allcar_model(R.drawable.jaguar_xe,"Jaguar","Jaguar XE","Automatic","Petrol","2 Baggage","5 Seater","₹5300","₹7600","₹11500",R.drawable.car_wash));

        adapter = new allcar_adapter(this,allcar_data);
        premium_cardata.setAdapter(adapter);



    }
}