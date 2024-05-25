package com.example.fullapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fullapplication.utils.firebaseutils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.concurrent.TimeUnit;

public class signup extends AppCompatActivity {

    private Button loginSwitch, go, verify, otp;
    private boolean otpVerification = false;
    private Long timeoutSecond = 60L;

    private ImageView logoImage;
    private TextView slogan, sloganSubhead;
    private TextInputLayout username, password, fullname, phoneNo, email, otpText;

    private String enteredPhoneNo, verificationCode;

    private PhoneAuthProvider.ForceResendingToken forceResendingToken;
    private FirebaseAuth mAuth;

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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        // Initialize UI elements
        initUI();

        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOtpRequest();
            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOtpVerification();
            }
        });

        loginSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToLogin();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignup();
            }
        });
    }

    private void initUI() {
        loginSwitch = findViewById(R.id.login_switch);
        logoImage = findViewById(R.id.Logo_image);
        slogan = findViewById(R.id.Slogan);
        sloganSubhead = findViewById(R.id.Slogansubhead);
        username = findViewById(R.id.username);
        password = findViewById(R.id.Password);
        go = findViewById(R.id.Go);
        email = findViewById(R.id.Email);
        phoneNo = findViewById(R.id.PhoneNo);
        fullname = findViewById(R.id.fullname);
        otpText = findViewById(R.id.otptext);
        verify = findViewById(R.id.verify);
        otp = findViewById(R.id.otp);
    }

    private void handleOtpRequest() {
        enteredPhoneNo = phoneNo.getEditText().getText().toString().trim();
        if (enteredPhoneNo.isEmpty() || enteredPhoneNo.length() != 10) {
            Toast.makeText(signup.this, "Please enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show();
            return;
        }
        enteredPhoneNo = "+91" + enteredPhoneNo;
        sendOtp(enteredPhoneNo, false);
    }

    private void handleOtpVerification() {
        String enterOtp = otpText.getEditText().getText().toString().trim();
        if (verificationCode == null || enterOtp.isEmpty()) {
            Toast.makeText(signup.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
            return;
        }
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, enterOtp);
        signInWithCredential(credential);
    }

    private void switchToLogin() {
        Intent intent = new Intent(signup.this, login.class);
        Pair[] pairs = new Pair[7];
        pairs[0] = new Pair<>(logoImage, "logo_image");
        pairs[1] = new Pair<>(slogan, "logo_name");
        pairs[2] = new Pair<>(sloganSubhead, "subhead");
        pairs[3] = new Pair<>(username, "username_logo");
        pairs[4] = new Pair<>(password, "password_logo");
        pairs[5] = new Pair<>(go, "button_transition");
        pairs[6] = new Pair<>(loginSwitch, "signup_switch");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(signup.this, pairs);
        startActivity(intent, options.toBundle());
    }

    private void handleSignup() {
        String enteredUsername = username.getEditText().getText().toString().trim();
        String enteredEmail = email.getEditText().getText().toString().trim();
        String enteredFullname = fullname.getEditText().getText().toString().trim();
        String enteredPassword = password.getEditText().getText().toString().trim();

        if (enteredUsername.isEmpty() || enteredEmail.isEmpty() || enteredPhoneNo.isEmpty() ||
                enteredFullname.isEmpty() || enteredPassword.isEmpty()) {
            Toast.makeText(signup.this, "Enter all the required values", Toast.LENGTH_SHORT).show();
            return;
        }
            if (otpVerification) {



                mAuth.createUserWithEmailAndPassword(enteredEmail, enteredPassword)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(signup.this, "Account created",
                                            Toast.LENGTH_SHORT).show();

                                    usermodel usermod = new usermodel(enteredFullname,enteredPhoneNo, enteredEmail,enteredUsername);
                                    firebaseutils.documentRefrence().set(usermod).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(signup.this, "Data saved",
                                                        Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(signup.this, login.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        }
                                    });
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(signup.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



            } else {
                Toast.makeText(getApplicationContext(), "Please verify your OTP", Toast.LENGTH_SHORT).show();
            }
    }

    private void sendOtp(String phoneNo, boolean isResend) {
        PhoneAuthOptions.Builder builder = PhoneAuthOptions.newBuilder(mAuth)
                .setPhoneNumber(phoneNo)
                .setTimeout(timeoutSecond, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(getApplicationContext(), "OTP verification failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("SignupActivity", "OTP verification failed", e);
                    }

                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        verificationCode = s;
                        signup.this.forceResendingToken = forceResendingToken;
                        Toast.makeText(getApplicationContext(), "OTP sent successfully", Toast.LENGTH_LONG).show();
                    }
                });

        if (isResend) {
            PhoneAuthProvider.verifyPhoneNumber(builder.setForceResendingToken(forceResendingToken).build());
        } else {
            PhoneAuthProvider.verifyPhoneNumber(builder.build());
        }
    }

    private void signInWithCredential(PhoneAuthCredential phoneAuthCredential) {
        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    otpVerification = true;
                    Toast.makeText(getApplicationContext(), "OTP verification successful", Toast.LENGTH_LONG).show();
                    verify.setBackgroundResource(R.drawable.green);
                } else {
                    otpVerification = false;
                    Toast.makeText(getApplicationContext(), "OTP verification Failed", Toast.LENGTH_LONG).show();
                    verify.setBackgroundResource(R.drawable.red);
                }
            }
        });
    }




}
