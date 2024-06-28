package com.example.behealthy;
import com.example.behealthy3.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InstructionActivity extends AppCompatActivity {

    private TextView instructionTextView;
    private Button nextInstructionButton;
    private Button disclaimerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        // Find views
        instructionTextView = findViewById(R.id.instructionTextView);
        nextInstructionButton = findViewById(R.id.nextInstructionButton);
        disclaimerButton = findViewById(R.id.button6);

        // Set initial text for instructionTextView
        instructionTextView.setText("Create an account or log in using your credentials \n \n Ensure your personal data is stored securely and protected");

        // Set click listener for nextInstructionButton
        nextInstructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
                Toast.makeText(InstructionActivity.this, "Next instruction button clicked", Toast.LENGTH_SHORT).show();
                // Example: Update instructionTextView text
                instructionTextView.setText("Results provided are purely tested");
            }
        });

        // Set click listener for disclaimerButton
        disclaimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
                Toast.makeText(InstructionActivity.this, "Disclaimer button clicked", Toast.LENGTH_SHORT).show();
                // Example: Update instructionTextView text
                instructionTextView.setText("Disclaimer: Information provided in this app is for educational purposes only.");
            }
        });
    }
}
