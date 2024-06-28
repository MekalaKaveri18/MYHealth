package com.example.behealthy;
import com.example.behealthy3.R;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WorkoutActivity extends AppCompatActivity {

    private TextView yogaAsanaTextView;
    private TextView btnNextAsana;
    private ScrollView  btnStartPractice;
    private int currentAsanaIndex = 0; // Index to track current asana

    // Sample list of asanas (replace with your actual list)
    private String[] asanas = {"Sukhasana", "Balasana", "Virabhadrasana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        // Initialize TextView and Buttons
        yogaAsanaTextView = findViewById(R.id.yogaAsanaTextView);
        btnNextAsana = findViewById(R.id.yogaAsanaTextView);
        btnStartPractice = findViewById(R.id.asanaInfoScrollView);

        // Set initial asana
        displayYogaAsana(asanas[currentAsanaIndex]);

        // Button click listeners
        btnNextAsana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move to next asana
                currentAsanaIndex = (currentAsanaIndex + 1) % asanas.length;
                displayYogaAsana(asanas[currentAsanaIndex]);
            }
        });

        btnStartPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start practice session with a timer
                startPracticeTimer();
            }
        });
    }

    private void displayYogaAsana(String asanaName) {
        // Example method to display a yoga asana in the TextView
        String asanaDescription = getAsanaDescription(asanaName); // Replace with your logic
        yogaAsanaTextView.setText(asanaDescription);
    }

    // Example method to fetch asana description based on name
    private String getAsanaDescription(String asanaName) {
        // Replace with your actual descriptions
        switch (asanaName) {
            case "Sukhasana":
                return getString(R.string.sukhasana_description);
            case "Balasana":
                return getString(R.string.balasana_description);

            default:
                return "Description not available";
        }
    }

    private void startPracticeTimer() {
        // Example countdown timer for practice session (10 seconds)
        new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Update UI with remaining time if needed
            }

            public void onFinish() {
                // Session finished, you can add logic here for what happens after practice
                // For example, show a message or reset for next session
            }
        }.start();
    }
}
