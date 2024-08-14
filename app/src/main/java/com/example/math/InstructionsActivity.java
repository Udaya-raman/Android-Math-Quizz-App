package com.example.math;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        Button buttonStartQuiz = findViewById(R.id.buttonStartQuiz);
        TextView textViewInstructions = findViewById(R.id.textViewInstructions);
        // Set the instructions text
        textViewInstructions.setText("Here are the instructions for the math quiz:\n\n" +
                "1. Read the instruction or guideline carefully before starting the quiz.\n\n" +
                "2. Answer each question by selecting the correct option.\n\n" +
                "3. Your score will be calculated based on the number of correct answers.\n\n" +
                "4. Try to answer as many questions as you can within the given time limit.\n\n" +
                "5. Choose the most appropriate answers for each questions .\n\n" +
                "6. Good luck and have fun!\n");
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstructionsActivity.this, QuizActivity.class);
                intent.putExtra("p_name", getIntent().getStringExtra("p_name"));
                startActivity(intent);
            }
        });
    }
}
