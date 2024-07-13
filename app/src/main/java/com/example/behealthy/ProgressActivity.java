package com.example.behealthy;
import com.example.behealthy3.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView tvStressCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress); // Use the correct layout file here

        progressBar = findViewById(R.id.progress_bar);
        tvStressCategory = findViewById(R.id.tv_stress_category);

        Button btnShowResults = findViewById(R.id.btn_show_results);
        btnShowResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Example: Calculate stress level (replace with your own logic)
                int stressLevel = calculateStressLevel();

                // Update progress bar and stress category text based on stress level
                progressBar.setProgress(stressLevel);
                updateStressCategoryText(stressLevel);
            }
        });
    }

    private int calculateStressLevel() {
        // Example method to calculate stress level (replace with your own logic)
        Random random = new Random();
        return random.nextInt(6); // Generates a random number between 0 and 5
    }

    private void updateStressCategoryText(int stressLevel) {
        // Update the text view based on the stress level
        if (stressLevel >= 0 && stressLevel <= 1) {
            tvStressCategory.setText("Category: Low Stress");
        } else if (stressLevel >= 2 && stressLevel <= 3) {
            tvStressCategory.setText("Category: Moderate Stress");
        } else {
            tvStressCategory.setText("Category: High Stress");
        }
    }
}