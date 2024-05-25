package com.example.fullapplication.utils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class firebaseutils {

    public static String userid(){
        return FirebaseAuth.getInstance().getUid();
    }
    public static DocumentReference documentRefrence(){
        return FirebaseFirestore.getInstance().collection("users").document(userid());
    }
}
