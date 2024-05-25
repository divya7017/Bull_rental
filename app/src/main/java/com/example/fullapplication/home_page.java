package com.example.fullapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class home_page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView location_recyclerview, car_recylerview, premium_recylerview, hotels_recylerview;
    RecyclerView.Adapter adapter, car_adapter;
    ImageView menu_icon, plus, search_icon;
    DrawerLayout drawer_layout;
    NavigationView nav_view;

    TextView most_sell_view, mostsellcar, appname2, prem, bike_recycler;

    SearchView search;

    ArrayList<lacation_model> locationdata = new ArrayList<>();
    ArrayList<allcar_model> car_data = new ArrayList<>();

    ArrayList<allcar_model> premium_data = new ArrayList<>();
    ArrayList<allcar_model> bike_data = new ArrayList<>();
    LinearLayout sellcar;

    Menu menu;

    private String user;
    private String mail;
    private String phone;
    private String name;

    String mail1 = "singhald7017@gmail.com";
    String phone1 = "8218800443";
    String name1 = "Divya Singhal";

    String user1 = "singhald7017";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        location_recyclerview = findViewById(R.id.location_recyclerview);
        car_recylerview = findViewById(R.id.most_car_recylerview);
        premium_recylerview = findViewById(R.id.premium_recylerview);
        hotels_recylerview = findViewById(R.id.hotels_recylerview);
        menu_icon = findViewById(R.id.menu_icon);
        nav_view = findViewById(R.id.nav_view);
        drawer_layout = findViewById(R.id.drawer_layout);
        most_sell_view = findViewById(R.id.most_sell_view);
        mostsellcar = findViewById(R.id.mostsellcar);
        search = findViewById(R.id.search);
        appname2 = findViewById(R.id.appname2);
        plus = findViewById(R.id.plus);
        sellcar = findViewById(R.id.sellcar);
        prem = findViewById(R.id.prem);
        bike_recycler = findViewById(R.id.bike_recycler);




        Intent fromact = getIntent();
        user = fromact.getStringExtra("username");
        mail = fromact.getStringExtra("Email");
        phone = fromact.getStringExtra("PhoneNo");
        name = fromact.getStringExtra("fullname");

        location_recyclerview();
        car_recylerview();
        premium_recylerview();
        hotels_recylerview();
        nav_view();

        search.clearFocus();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterlist(newText);
                return true;
            }
        });

        most_sell_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, All_cars.class);
                Pair[] pairs = new Pair[2];


                pairs[0] = new Pair<View, String>(mostsellcar, "car_value");

                pairs[1] = new Pair<View, String>(car_recylerview, "car_recycler");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(home_page.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });

        prem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this,premium_allcar.class);
                startActivity(intent);
            }
        });

        bike_recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this,premium_bike.class);
                startActivity(intent);
            }
        });


    }

    private void filterlist(String Text) {
    }

    private void nav_view() {
        nav_view.bringToFront();
        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setCheckedItem(R.id.nav_home);
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer_layout.isDrawerVisible(GravityCompat.START)) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                } else drawer_layout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void hotels_recylerview() {
        hotels_recylerview.setHasFixedSize(true);
        hotels_recylerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        bike_data.add(new allcar_model(R.drawable.kawasaki_ninja_image,"Kawasaki","Ninja","Sports","Petrol","₹500000","₹700000","₹1000000",R.drawable.bycicle1));
        bike_data.add(new allcar_model(R.drawable.royal_enfield_bullet_image,"Royal Enfield","Bullet","Cruiser","Petrol","₹300000","₹400000","₹500000",R.drawable.bycicle1));
        bike_data.add(new allcar_model(R.drawable.ktm_duke_image,"KTM","Duke","Street","Petrol","₹400000","₹600000","₹800000",R.drawable.bycicle1));
        bike_data.add(new allcar_model(R.drawable.bmw_bike_image,"BMW","S1000RR","Sports","Petrol","₹800000","₹1200000","₹1500000",R.drawable.bycicle1));
        bike_data.add(new allcar_model(R.drawable.ducati_bike_image,"Ducati","Panigale V4","Sports","Petrol","₹900000","₹1500000","₹2000000",R.drawable.bycicle1));
        car_adapter = new car_adapter(this, bike_data);
        hotels_recylerview.setAdapter(car_adapter);
    }

    private void premium_recylerview() {
        premium_recylerview.setHasFixedSize(true);
        premium_recylerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        premium_data.add(new allcar_model(R.drawable.audi_a8,"Audi","Audi A8","Automatic","Petrol","3 Baggage","5 Seater","₹10000","₹15000","₹20000",R.drawable.sedan));
        premium_data.add(new allcar_model(R.drawable.mercedes_benz_s_class,"Mercedes-Benz","S-Class","Automatic","Petrol","3 Baggage","5 Seater","₹12000","₹18000","₹25000",R.drawable.sedan));
        premium_data.add(new allcar_model(R.drawable.bentley_continental_gt,"Bentley","Bentley Continental GT","Automatic","Petrol","2 Baggage","4 Seater","₹25000","₹35000","₹45000",R.drawable.sedan));
        premium_data.add(new allcar_model(R.drawable.aston_martin_db11,"Aston Martin","Aston Martin DB11","Automatic","Petrol","2 Baggage","4 Seater","₹20000","₹30000","₹40000",R.drawable.sedan));
        premium_data.add(new allcar_model(R.drawable.jaguar_f_type,"Jaguar","Jaguar F-Type","Automatic","Petrol","2 Baggage","2 Seater","₹15000","₹22000","₹30000",R.drawable.sedan));
        car_adapter = new car_adapter(this, premium_data);
        premium_recylerview.setAdapter(car_adapter);
    }

    private void car_recylerview() {
        car_recylerview.setHasFixedSize(true);
        car_recylerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        car_data.add(new allcar_model(R.drawable.hyundai_creta,"Hyundai","Hyundai Creta","Automatic","Petrol","2 Baggage","5 Seater","₹5000","₹6500","₹8000",R.drawable.sedan));
        car_data.add(new allcar_model(R.drawable.mahindra_xuv_3001,"Mahindra","Mahindra TUV 300","Manual","Diesel","2 Baggage","7 Seater","₹4500","₹6000","₹7500",R.drawable.sedan));
        car_data.add(new allcar_model(R.drawable.toyota_innova_crysta,"Toyota","Toyota Innova Crysta","Automatic","Diesel","3 Baggage","7 Seater","₹5500","₹7000","₹8500",R.drawable.sedan));
        car_data.add(new allcar_model(R.drawable.scorpio,"Mahindra","Mahindra Scorpio","Manual","Diesel","2 Baggage","7 Seater","₹6000","₹7500","₹9000",R.drawable.sedan));
        car_data.add(new allcar_model(R.drawable.maruti_vitara_brezza,"Maruti","Maruti Vitara Brezza","Automatic","Petrol","2 Baggage","5 Seater","₹4800","₹6200","₹7500",R.drawable.sedan));
        car_adapter = new car_adapter(this, car_data);
        car_recylerview.setAdapter(car_adapter);

    }

    private void location_recyclerview() {
        location_recyclerview.setHasFixedSize(true);
        location_recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        locationdata.add(new lacation_model(R.drawable.laksahay, "Lakshaydweep", "Lakshadweep is best location in india for tourist."));
        locationdata.add(new lacation_model(R.drawable.agra, "agra", "Agra famous place is Taj mahal,Qutub Minar"));
        locationdata.add(new lacation_model(R.drawable.kedarnath, "Kedarnath", "Kedarnath is the best religious place for god MAHADEV"));
        locationdata.add(new lacation_model(R.drawable.mumbai, "MUmbai", "Mumbai the city of bollywood"));
        locationdata.add(new lacation_model(R.drawable.vaishnodevi, "Vaishno devi", "Vaishno devi is the relegious place for god durga maa "));
        locationdata.add(new lacation_model(R.drawable.hyderabad, "hyderabad", "Hyderabad famous place is Charminar and Ramoji film city "));
        locationdata.add(new lacation_model(R.drawable.delhi, "delhi", "Delhi is the capital of india and famous place is India Gate, Qutub Minar"));
        adapter = new location_adapter(locationdata);
        location_recyclerview.setAdapter(adapter);


    }


    @SuppressLint("NonConstantResourceId")
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        int menuItemId = menuItem.getItemId();

        // Assuming R.id.nav_home is the ID of the menu item you want to check
        if (menuItemId == R.id.nav_home) {
            return true;
        }
        if (menuItemId == R.id.nav_logout) {
            Intent intent = new Intent(home_page.this, login.class);
            startActivity(intent);
            finish();
            return true;
        }

        if (menuItemId == R.id.nav_profile) {

            if ("singhald7017".equals(user)) {
                Intent intent = new Intent(home_page.this, Profile.class);
                intent.putExtra("username", user1);
                intent.putExtra("Email", mail1);
                intent.putExtra("PhoneNo", phone1);
                intent.putExtra("fullname", name1);
                startActivity(intent);
                finish();
                return true;
            } else {
                Intent intent = new Intent(home_page.this, Profile.class);
                intent.putExtra("username", user);
                intent.putExtra("Email", mail);
                intent.putExtra("PhoneNo", phone);
                intent.putExtra("fullname", name);
                startActivity(intent);
                finish();
                return true;
            }
        }

        if (menuItemId == R.id.nav_car){
            Intent intent = new Intent(home_page.this, All_cars.class);
            startActivity(intent);
        }
        if (menuItemId == R.id.nav_prem_car){
            Intent intent = new Intent(home_page.this, premium_allcar.class);
            startActivity(intent);
        }
        if (menuItemId == R.id.nav_hotel){
            Intent intent = new Intent(home_page.this, premium_bike.class);
            startActivity(intent);
        }

        return true;
    }


}