package com.example.fullapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import kotlin.io.encoding.Base64;

public class car_detail extends AppCompatActivity {
    ArrayAdapter<String> adapterItems;

    ImageView car_detail_image;

    TextView return_date;
    TextView pick_up;
    TextView car_detail_company;
    TextView car_detail_model;
    TextView car_detail_gear;
    TextView car_detail_fuel;
    TextView car_detail_lugage;
    TextView car_detail_seat;
    TextView car_detail_car_detail_expensive;
    TextView car_detail_car_detail_medium;
    TextView car_detail_car_detail_best;
    TextView pickup_date;
    TextView return_date1, pickup_time1, return_Time1;

    AutoCompleteTextView autoComplete_text;
    AppCompatButton Purchase_button;


    RelativeLayout car_detail_best_layout, car_detail_medium_layout, car_detail_expensive_layout;

    String[] item = {"Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Ladakh", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal"};


    int pickupyear;
    int pickupdate;
    int pickupmonth;

    int returndate;
    int returnyear;
    int returnmonth;

    int pickuphour;
    int pickupminute;

    String expensive;
    String medium;

    String best;
    int price, img;

    String package_type;
    String free_kms, model;

    String extra_kms;

    String pickup_date2, pickup_time2, return_date2, return_time2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        autoComplete_text = findViewById(R.id.autoComplete_text);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, item);
        autoComplete_text.setAdapter(adapterItems);

        car_detail_image = findViewById(R.id.car_detail_image);
        car_detail_company = findViewById(R.id.car_detail_company);
        car_detail_model = findViewById(R.id.car_detail_model);
        car_detail_gear = findViewById(R.id.car_detail_gear);
        car_detail_fuel = findViewById(R.id.car_detail_fuel);
        car_detail_lugage = findViewById(R.id.car_detail_lugage);
        car_detail_seat = findViewById(R.id.car_detail_seat);
        car_detail_car_detail_expensive = findViewById(R.id.car_detail_car_detail_expensive);
        car_detail_car_detail_medium = findViewById(R.id.car_detail_car_detail_medium);
        car_detail_car_detail_best = findViewById(R.id.car_detail_car_detail_best);
        car_detail_best_layout = findViewById(R.id.car_detail_best_layout);
        car_detail_medium_layout = findViewById(R.id.car_detail_medium_layout);
        car_detail_expensive_layout = findViewById(R.id.car_detail_expesnse_layout);
        return_date = findViewById(R.id.return_date);
        pick_up = findViewById(R.id.pick_up);
        pickup_date = findViewById(R.id.pickup_date);
        return_date1 = findViewById(R.id.return_date1);
        pickup_time1 = findViewById(R.id.pickup_time1);
        return_Time1 = findViewById(R.id.return_time1);
        Purchase_button = findViewById(R.id.Purchase_button);


        Intent fromact = getIntent();
        img = fromact.getIntExtra("car_img", 0);
        String company = fromact.getStringExtra("car_Company");
        model = fromact.getStringExtra("car_Model");
        String gear = fromact.getStringExtra("car_gear");
        String fuel = fromact.getStringExtra("car_fuel");
        String lugage = fromact.getStringExtra("car_lugage");
        String seat = fromact.getStringExtra("car_seat");
        expensive = fromact.getStringExtra("car_expensive");
        medium = fromact.getStringExtra("car_medium");
        best = fromact.getStringExtra("car_best");
        int date = fromact.getIntExtra("date", 0);
        int month = fromact.getIntExtra("month", 0);
        int year = fromact.getIntExtra("year", 0);


        car_detail_image.setImageResource(img);
        car_detail_company.setText(company);
        car_detail_model.setText(model);
        car_detail_gear.setText(gear);
        car_detail_fuel.setText(fuel);
        car_detail_lugage.setText(lugage);
        car_detail_seat.setText(seat);
        car_detail_car_detail_expensive.setText(expensive);
        car_detail_car_detail_medium.setText(medium);
        car_detail_car_detail_best.setText(best);
        pickup_date.setText(date + "/" + (month + 1) + "/" + year);
        return_date1.setText(date + "/" + (month + 1) + "/" + year);


        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        pickup_time1.setText(hour + ":" + minute + " " + "Am");
        return_Time1.setText(hour + ":" + minute + " " + "Am");

        Purchase_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(car_detail.this,"Enter the Pickup and Return Date in appropriate manner",Toast.LENGTH_SHORT).show();
            }
        });

        pick_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdatepicker();
            }

            private void showdatepicker() {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int date = calendar.get(Calendar.DATE);

                DatePickerDialog dialog = new DatePickerDialog(car_detail.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int select_year, int select_month, int select_dayOfMonth) {
                        pickupdate = select_dayOfMonth;
                        pickupmonth = select_month;
                        pickupyear = select_year;
                        if (select_year < year || (select_year == year && select_month < month) || (select_year == year && select_month == month && select_dayOfMonth < date)) {
                            Toast.makeText(car_detail.this, "Choose Appropriate Date", Toast.LENGTH_SHORT).show();
                            showdatepicker();
                        } else {
                            pickup_date.setText(pickupdate + "/" + (pickupmonth + 1) + "/" + pickupyear);
                            pick_up.setBackgroundColor(R.drawable.border_colour);
                            pickup_date2 = pickup_date.getText().toString();
                            timepicker();

                        }

                    }
                }, year, month, date);
                dialog.show();
            }
        });


    }


    private void timepicker() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int Minute = calendar.get(Calendar.MINUTE);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        TimePickerDialog time = new TimePickerDialog(car_detail.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                pickuphour = hourOfDay;
                pickupminute = minute;

                if ((pickupdate == date) && (pickupmonth == month) && (pickupyear == year) && (hour > hourOfDay) || (hour == hourOfDay) && (Minute > minute)) {
                    Toast.makeText(car_detail.this, "Fill the Correct Date", Toast.LENGTH_SHORT).show();
                    timepicker();
                } else {
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar1.set(Calendar.MINUTE, minute);
                    calendar1.setTimeZone(TimeZone.getDefault());
                    SimpleDateFormat format = new SimpleDateFormat("k:mm a");
                    String time = format.format(calendar1.getTime());
                    pickup_time1.setText(time);
                    return_date.setBackgroundResource(R.drawable.border);
                    pickup_time2 = pickup_time1.getText().toString();
                    return_date1.setText(date + "/" + (month + 1) + "/" + year);
                    return_Time1.setText(hour + ":" + minute + " " + "Am");

                    return_date.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            showdatepicker1();

                            car_detail_best_layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    car_detail_best_layout.setBackgroundResource(R.drawable.border_colour);
                                    car_detail_medium_layout.setBackgroundResource(R.drawable.border1);
                                    car_detail_expensive_layout.setBackgroundResource(R.drawable.border1);
                                    price = Integer.parseInt(best.replaceAll("[^0-9]", ""));
                                    package_type = "unlimited";
                                    free_kms = "Unlimited kms";
                                    extra_kms = "-";
                                    purchsebuttom();
                                }
                            });

                            car_detail_medium_layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    car_detail_best_layout.setBackgroundResource(R.drawable.border1);
                                    car_detail_medium_layout.setBackgroundResource(R.drawable.border_colour);
                                    car_detail_expensive_layout.setBackgroundResource(R.drawable.border1);
                                    price = Integer.parseInt(medium.replaceAll("[^0-9]", ""));
                                    package_type = "300Kms/day";
                                    free_kms = "1013 Free Kms";
                                    extra_kms = "₹9/Km";
                                    purchsebuttom();
                                }
                            });

                            car_detail_expensive_layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    car_detail_best_layout.setBackgroundResource(R.drawable.border1);
                                    car_detail_medium_layout.setBackgroundResource(R.drawable.border1);
                                    car_detail_expensive_layout.setBackgroundResource(R.drawable.border_colour);
                                    price = Integer.parseInt(expensive.replaceAll("[^0-9]", ""));
                                    package_type = "120kms/day";
                                    free_kms = "405 Free Kms";
                                    extra_kms = "₹9/Km";
                                    purchsebuttom();
                                }
                            });
                            price = Integer.parseInt(medium.replaceAll("[^0-9]", ""));
                            package_type = "300Kms/day";
                            free_kms = "1013 Free Kms";
                            extra_kms = "₹9/Km";
                            purchsebuttom();
                        }
                    });
                }
            }
        }, hour, Minute, false);
        time.show();
    }

    private void timepicker1() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int Minute = calendar.get(Calendar.MINUTE);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        TimePickerDialog time = new TimePickerDialog(car_detail.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                if ((pickupdate == returndate) && (pickupmonth == returnmonth) && (pickupyear == returnyear) && (pickuphour > hourOfDay) || (pickuphour == hourOfDay) && (pickupminute > minute)) {
                    Toast.makeText(car_detail.this, "Fill the Correct Date", Toast.LENGTH_SHORT).show();
                    timepicker1();
                } else {
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar1.set(Calendar.MINUTE, minute);
                    calendar1.setTimeZone(TimeZone.getDefault());
                    SimpleDateFormat format = new SimpleDateFormat("k:mm a");
                    String time = format.format(calendar1.getTime());
                    return_Time1.setText(time);
                    return_time2 = return_Time1.getText().toString();
                }
            }
        }, hour, Minute, false);
        time.show();
    }

    private void showdatepicker1() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        DatePickerDialog dialog = new DatePickerDialog(car_detail.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int select_year1, int select_month1, int select_dayOfMonth1) {

                returndate = select_dayOfMonth1;
                returnmonth = select_month1;
                returnyear = select_year1;

                if (select_year1 < pickupyear || (select_year1 == pickupyear && select_month1 < pickupmonth) || (select_year1 == pickupyear && select_month1 == pickupmonth && select_dayOfMonth1 < pickupdate)) {
                    Toast.makeText(car_detail.this, "Choose Appropriate Date", Toast.LENGTH_SHORT).show();
                    showdatepicker1();
                } else {
                    return_date1.setText(select_dayOfMonth1 + "/" + (select_month1 + 1) + "/" + select_year1);
                    return_date.setBackgroundColor(R.drawable.border_colour);
                    return_date2 = return_date1.getText().toString();
                    timepicker1();

                }
            }
        }, year, month, date);
        dialog.show();
    }

    private void purchsebuttom() {
        Purchase_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = autoComplete_text.getText().toString();
                if(location.equals("") || pickup_date2.equals("") && return_date2.equals("")){
                    Toast.makeText(car_detail.this,"enter the Location",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(car_detail.this, car_purchse.class);
                    intent.putExtra("carimage", img);
                    intent.putExtra("carmodel", model);
                    intent.putExtra("package", package_type);
                    intent.putExtra("price", price);
                    intent.putExtra("free", free_kms);
                    intent.putExtra("extra", extra_kms);
                    intent.putExtra("pickdate", pickup_date2);
                    intent.putExtra("picktime", pickup_time2);
                    intent.putExtra("returndate", return_date2);
                    intent.putExtra("returntime", return_time2);
                    intent.putExtra("location", location);
                    startActivity(intent);
                }

            }
        });
    }
}