package com.example.fullapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {

    Button signup_call , go , forgot;

    ImageView logo_image;
    TextView slogan,slogansubhead;
    TextInputLayout username, password;

    FirebaseAuth mAuth;

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent intent = new Intent(getApplicationContext(),home_page.class);
//            startActivity(intent);
//            finish();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        logo_image = findViewById(R.id.logo_image);
        signup_call = findViewById(R.id.signup_call);
        slogan = findViewById(R.id.slogan);
        slogansubhead = findViewById(R.id.slogansubhead);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.password);
        go = findViewById(R.id.go);
        forgot = findViewById(R.id.forgot);



        signup_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,signup.class);
                Pair[] pairs = new Pair[7];

                pairs[0] = new Pair<View,String>(logo_image,"logo_image");
                pairs[1] = new Pair<View,String>(slogan,"logo_name");
                pairs[2] = new Pair<View,String>(slogansubhead,"subhead");
                pairs[3] = new Pair<View,String>(username,"username_logo");
                pairs[4] = new Pair<View,String>(password,"password_logo");
                pairs[5] = new Pair<View,String>(go,"button_transition");
                pairs[6] = new Pair<View,String>(signup_call,"signup_switch");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(login.this,pairs);
                startActivity(intent,options.toBundle());



            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String enteredEmail = username.getEditText().getText().toString().trim();
                String enteredPassword = password.getEditText().getText().toString().trim();

                if (!enteredEmail.isEmpty() && !enteredPassword.isEmpty()) {
                    mAuth.signInWithEmailAndPassword(enteredEmail, enteredPassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(login.this, "Login Succesful",
                                                Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), home_page.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(login.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    // Display error message for empty username or password fields
                    Toast.makeText(login.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}