package com.example.behealthy;
import com.example.behealthy3.R;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ChallengeActivity extends AppCompatActivity {

    private Spinner challengeSpinner;
    private Button startChallengeButton;
    EditText btnStartTimer;
    private TextView timerTextView;
    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeftInMillis = 300000; // 5 minutes in milliseconds (5 * 60 * 1000)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        challengeSpinner = findViewById(R.id.challengeSpinner);
        startChallengeButton = findViewById(R.id.startChallengeButton);
        btnStartTimer = findViewById(R.id.editTextTime);
        timerTextView = findViewById(R.id.editTextTime);

        // Populate spinner with challenge options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.challenge_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        challengeSpinner.setAdapter(adapter);

        // Handle spinner item selection
        challengeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedChallenge = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Selected challenge: " + selectedChallenge,
                        Toast.LENGTH_SHORT).show();
                // Optionally, you can perform actions based on the selected challenge
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle case when nothing is selected (if needed)
            }
        });

        // Handle start challenge button click
        startChallengeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedChallenge = challengeSpinner.getSelectedItem().toString();
                startChallenge(selectedChallenge);
            }
        });

        // Handle start timer button click
        btnStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });
    }

    private void startChallenge(String selectedChallenge) {
        switch (selectedChallenge) {
            case "Yoga Practice":
                startYogaPracticeChallenge();
                break;
            case "Running Challenge":
                startRunningChallenge();
                break;
            case "Swimming Challenge":
                startSwimmingChallenge();
                break;
            default:
                Toast.makeText(getApplicationContext(), "Unknown challenge: " + selectedChallenge,
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void startYogaPracticeChallenge() {
        // Replace with logic to start yoga practice challenge
        Toast.makeText(getApplicationContext(), "Starting Yoga Practice Challenge",
                Toast.LENGTH_SHORT).show();
        // Example: Navigate to YogaActivity or start yoga practice routine
    }

    private void startRunningChallenge() {
        // Replace with logic to start running challenge
        Toast.makeText(getApplicationContext(), "Starting Running Challenge",
                Toast.LENGTH_SHORT).show();
        // Example: Start tracking running session or navigate to RunningActivity
    }

    private void startSwimmingChallenge() {
        // Replace with logic to start swimming challenge
        Toast.makeText(getApplicationContext(), "Starting Swimming Challenge",
                Toast.LENGTH_SHORT).show();
        // Example: Initiate swimming session or navigate to SwimmingActivity
    }

    private void startTimer() {
        if (!timerRunning) {
            countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    timerRunning = false;
                    updateCountDownText(); // Ensure countdown text displays "00:00"
                    Toast.makeText(ChallengeActivity.this, "Challenge Time Completed!", Toast.LENGTH_SHORT).show();
                }
            }.start();

            timerRunning = true;
            btnStartTimer.setText("Pause Timer");
        } else {
            countDownTimer.cancel();
            timerRunning = false;
            btnStartTimer.setText("Start Timer");
        }
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        timerTextView.setText(timeLeftFormatted);
    }
}
