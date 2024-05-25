package com.example.fullapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fullapplication.utils.firebaseutils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentSnapshot;

public class Profile extends AppCompatActivity {

    TextInputEditText profile_username ,profile_fullname, profile_email , profile_phoneno;
    TextView profile_name , profile_user;

    Button profile_update_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_username = findViewById(R.id.profile_username);
        profile_fullname = findViewById(R.id.profile_fullname);
        profile_phoneno = findViewById(R.id.profile_phoneno);
        profile_email = findViewById(R.id.profile_email);
        profile_name = findViewById(R.id.profile_name);
        profile_user = findViewById(R.id.profile_user);
        profile_update_button = findViewById(R.id.profile_update_button);

        getusername();


        profile_update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext = new Intent(Profile.this,home_page.class);
                startActivity(inext);
            }
        });










    }

    void getusername(){
        firebaseutils.documentRefrence().get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    usermodel usermod = new usermodel();
                    usermod = task.getResult().toObject(usermodel.class);
                    if (usermod != null){
                        profile_username.setText(usermod.getUsername());
                        profile_fullname.setText(usermod.getName());
                        profile_phoneno.setText(usermod.getPhoneno());
                        profile_email.setText(usermod.getEmail());
                        profile_name.setText(usermod.getName());
                        profile_user.setText(usermod.getUsername());
                    }
                }
            }
        });
    }


}