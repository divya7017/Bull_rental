package com.example.fullapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Animation top_new, bottom_new;
    ImageView splash_image;
    TextView appname, myname,subappname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        top_new = AnimationUtils.loadAnimation(this,R.anim.top_new);
        bottom_new = AnimationUtils.loadAnimation(this,R.anim.bottom_new);
        splash_image = findViewById(R.id.splash_image);
        appname = findViewById(R.id.appname);
        myname = findViewById(R.id.myname);
        subappname = findViewById(R.id.subappname);

        splash_image.setAnimation(top_new);
        appname.setAnimation(bottom_new);
        myname.setAnimation(bottom_new);
        subappname.setAnimation(bottom_new);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, login.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(splash_image,"logo_image");
                pairs[1] = new Pair<View,String>(appname,"logo_name");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent,options.toBundle());
                finish();

            }
        },3000);
    }

}