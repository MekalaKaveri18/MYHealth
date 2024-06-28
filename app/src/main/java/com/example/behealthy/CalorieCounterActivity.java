package com.example.behealthy;
import com.example.behealthy3.R;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CalorieCounterActivity extends AppCompatActivity {

    private EditText etFoodName, etCalories;
    private Button btnSaveCalories;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_counter);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize Firebase Database
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Calories");

        etFoodName = findViewById(R.id.etFoodName);
        etCalories = findViewById(R.id.etCalories);
        btnSaveCalories = findViewById(R.id.btnSaveCalories);

        btnSaveCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCalories();
            }
        });
    }

    private void saveCalories() {
        String foodName = etFoodName.getText().toString().trim();
        String caloriesStr = etCalories.getText().toString().trim();

        if (foodName.isEmpty()) {
            etFoodName.setError("Food name is required");
            etFoodName.requestFocus();
            return;
        }

        if (caloriesStr.isEmpty()) {
            etCalories.setError("Calories count is required");
            etCalories.requestFocus();
            return;
        }

        int calories;
        try {
            calories = Integer.parseInt(caloriesStr);
        } catch (NumberFormatException e) {
            etCalories.setError("Please enter a valid number");
            etCalories.requestFocus();
            return;
        }

        // Check if user is authenticated
        if (mAuth.getCurrentUser() == null) {
            Toast.makeText(this, "User not authenticated", Toast.LENGTH_SHORT).show();
            return;
        }

        // Get current user's ID
        String userId = mAuth.getCurrentUser().getUid();

        // Create a new entry under "Calories" node for the current user
        DatabaseReference userCaloriesRef = mDatabase.child(userId);
        String entryId = userCaloriesRef.push().getKey();
        CalorieEntry calorieEntry = new CalorieEntry(foodName, calories);

        // Save entry to Firebase
        userCaloriesRef.child(entryId).setValue(calorieEntry)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(CalorieCounterActivity.this, "Calories saved successfully", Toast.LENGTH_SHORT).show();
                            etFoodName.setText("");
                            etCalories.setText("");
                        } else {
                            Toast.makeText(CalorieCounterActivity.this, "Failed to save calories: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // Inner class to represent a calorie entry
    public static class CalorieEntry {
        public String foodName;
        public int calories;

        public CalorieEntry() {
            // Default constructor required for calls to DataSnapshot.getValue(CalorieEntry.class)
        }

        public CalorieEntry(String foodName, int calories) {
            this.foodName = foodName;
            this.calories = calories;
        }
    }
}
