package com.example.behealthy;

import com.example.behealthy3.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnStartWorkout, btnStartChallenge, btnStartInstruction, btnProgress, btnRelaxationSound,
            btnCalorieCounter, btnSupport, btnCall, btnPlay, btnQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        btnStartWorkout = findViewById(R.id.btn_start_workout);
        btnStartChallenge = findViewById(R.id.btn_start_challenge);
        btnStartInstruction = findViewById(R.id.btn_start_instruction);
        btnProgress = findViewById(R.id.btn_progress);
        btnRelaxationSound = findViewById(R.id.btn_relaxation_sound);
        btnCalorieCounter = findViewById(R.id.btn_calorie_counter);
        btnSupport = findViewById(R.id.btn_support);
        btnCall = findViewById(R.id.btn_call);
        btnPlay = findViewById(R.id.btn_play);
        btnQuiz = findViewById(R.id.btn_quiz);

        // Set click listeners
        btnStartWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WorkoutActivity.class));
            }
        });

        btnStartChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChallengeActivity.class));
            }
        });

        btnStartInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InstructionActivity.class));
            }
        });

        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProgressActivity.class));
            }
        });

        btnRelaxationSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RelaxationSoundActivity.class));
            }
        });

        btnCalorieCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CalorieCounterActivity.class));
            }
        });

        btnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SupportActivity.class));
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CallActivity.class));
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayActivity.class));
            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuizActivity.class));
            }
        });
    }
}
