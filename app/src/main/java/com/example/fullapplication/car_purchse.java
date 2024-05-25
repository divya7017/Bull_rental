package com.example.fullapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class car_purchse extends AppCompatActivity {

    ImageView car_purchase_photo;
    TextView car_purchase_name,pickup_date_purchase,pickup_time_purchase,return_date_purchse,return_time_purchase,package_type,freekms,extra_kms,rental_charge,gst,total_amount,location_purchase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_purchse);

//< -------------------------find id --------------------->
        car_purchase_photo = findViewById(R.id.car_purchase_photo);
        car_purchase_name = findViewById(R.id.car_purchase_name);
        pickup_date_purchase = findViewById(R.id.pickup_date_purchase);
        pickup_time_purchase = findViewById(R.id.pickup_time_purchase);
        return_date_purchse = findViewById(R.id.return_date_purchse);
        return_time_purchase = findViewById(R.id.return_time_purchase);
        package_type = findViewById(R.id.package_type);
        freekms = findViewById(R.id.freekms);
        extra_kms = findViewById(R.id.extra_kms);
        rental_charge = findViewById(R.id.rental_charge);
        gst = findViewById(R.id.gst);
        total_amount = findViewById(R.id.total_amount);
        location_purchase = findViewById(R.id.location_purchase);

//<-----------------------------Intent -------------------------->
        Intent fromact = getIntent();
        int price = fromact.getIntExtra("price",0);
        int img = fromact.getIntExtra("carimage",0);
        String package_type1 = fromact.getStringExtra("package");
        String model = fromact.getStringExtra("carmodel");
        String free = fromact.getStringExtra("free");
        String extra = fromact.getStringExtra("extra");
        String pickdate = fromact.getStringExtra("pickdate");
        String picktime = fromact.getStringExtra("picktime");
        String returntime = fromact.getStringExtra("returntime");
        String returndate = fromact.getStringExtra("returndate");
        String location = fromact.getStringExtra("location");

//<------------------------------set-------------------------->
        car_purchase_photo.setImageResource(img);
        car_purchase_name.setText(model);
        pickup_date_purchase.setText(pickdate);
        pickup_time_purchase.setText(picktime);
        return_date_purchse.setText(returndate);
        return_time_purchase.setText(returntime);
        rental_charge.setText("₹"+price+"");
        extra_kms.setText(extra);
        freekms.setText(free);
        package_type.setText(package_type1);
        location_purchase.setText("Location : "+location);
        float Gst = price * 0.18f;
        gst.setText("₹"+Gst);
        float totalamount = price + Gst + 5000;
        total_amount.setText("₹"+ totalamount+"/-");

    }
}