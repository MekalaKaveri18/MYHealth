package com.example.behealthy;
import com.example.behealthy3.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    private Button btnPrev, btnNext, btnSubmit;

    // Array to hold quiz questions and answers
    private String[] questions = {
            "Q1. What are you looking for?",
            "Q2. Do you want to know about your health status?"
    };

    // Array to hold options for each question
    private String[][] options = {
            {"MyHealth tracking app", "Just want to check my health status", "", ""},
            {"Yes", "No", "", ""}
    };

    // Array to hold correct answers for evaluation
    private int[] correctAnswers = {0, 0}; // Index of correct answer for each question

    private int currentQuestionIndex = 0; // Tracks the current question index

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize views
        tvQuestion = findViewById(R.id.tvQuestion);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.option1);
        radioButton2 = findViewById(R.id.option2);
        radioButton3 = findViewById(R.id.option3);
        radioButton4 = findViewById(R.id.option4);
        btnPrev = findViewById(R.id.button);
        btnNext = findViewById(R.id.button3);
        btnSubmit = findViewById(R.id.button2);

        // Display initial question and options
        displayQuestion(currentQuestionIndex);

        // Next button click listener
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex < questions.length - 1) {
                    currentQuestionIndex++;
                    displayQuestion(currentQuestionIndex);
                    radioGroup.clearCheck(); // Clear radio button selection for next question
                }
            }
        });

        // Previous button click listener
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;
                    displayQuestion(currentQuestionIndex);
                    radioGroup.clearCheck(); // Clear radio button selection for next question
                }
            }
        });

        // Submit button click listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if an answer is selected
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get selected answer index (0-based)
                int selectedAnswerIndex = radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId()));

                // Evaluate selected answer
                evaluateAnswer(selectedAnswerIndex);

                // Move to the next question or finish quiz
                if (currentQuestionIndex < questions.length - 1) {
                    currentQuestionIndex++;
                    displayQuestion(currentQuestionIndex);
                    radioGroup.clearCheck(); // Clear radio button selection for next question
                } else {
                    // End of quiz
                    Toast.makeText(QuizActivity.this, "Quiz completed!", Toast.LENGTH_SHORT).show();
                    finish(); // Close quiz activity
                }
            }
        });
    }

    // Method to display question and options
    private void displayQuestion(int questionIndex) {
        // Set question text
        tvQuestion.setText(questions[questionIndex]);

        // Set options for the question
        radioButton1.setText(options[questionIndex][0]);
        radioButton2.setText(options[questionIndex][1]);

        // Hide unused radio buttons for current question
        if (options[questionIndex][2].isEmpty()) {
            radioButton3.setVisibility(View.GONE);
        } else {
            radioButton3.setVisibility(View.VISIBLE);
            radioButton3.setText(options[questionIndex][2]);
        }

        if (options[questionIndex][3].isEmpty()) {
            radioButton4.setVisibility(View.GONE);
        } else {
            radioButton4.setVisibility(View.VISIBLE);
            radioButton4.setText(options[questionIndex][3]);
        }
    }

    // Method to evaluate selected answer
    private void evaluateAnswer(int selectedAnswerIndex) {
        // Get correct answer index for current question
        int correctAnswerIndex = correctAnswers[currentQuestionIndex];

        // Compare selected answer with correct answer
        if (selectedAnswerIndex == correctAnswerIndex) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            // Handle correct answer logic if needed
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
            // Handle incorrect answer logic if needed
        }
    }
}
