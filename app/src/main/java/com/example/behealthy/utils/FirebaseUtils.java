package com.example.behealthy.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.behealthy.MainActivity;
import com.example.behealthy.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseUtils {

    private static FirebaseAuth mAuth;

    // Initialize Firebase Authentication instance
    public static void initFirebaseAuth() {
        mAuth = FirebaseAuth.getInstance();
    }

    // Register new user with email and password
    public static void registerUser(Context context, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Registration successful, navigate to main activity
                            Toast.makeText(context, "Registration successful", Toast.LENGTH_SHORT).show();
                            context.startActivity(new Intent(context, MainActivity.class));
                            ((Activity) context).finish();
                        } else {
                            // Registration failed
                            Toast.makeText(context, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // Sign in user with email and password
    public static void signInUser(Context context, String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in successful, navigate to main activity
                            Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show();
                            context.startActivity(new Intent(context, MainActivity.class));
                            ((Activity) context).finish();
                        } else {
                            // Sign in failed
                            Toast.makeText(context, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // Send password reset email
    public static void sendPasswordResetEmail(Context context, String email) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(context, "Password reset email sent", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Failed to send password reset email: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // Sign out the current user
    public static void signOutUser(Context context) {
        mAuth.signOut();
        Toast.makeText(context, "Logged out", Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context, RegisterActivity.class));
        ((Activity) context).finish();
    }
}
