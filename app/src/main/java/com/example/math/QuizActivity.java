package com.example.math;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private Button buttonOption1, buttonOption2, buttonOption3, buttonOption4;
    private int currentQuestion = 0;
    private int score = 0;

    // Example questions and answers
    private String[] questions = {"2 + 2 =", "10 - 5 =", "6 * 3 =", "12 / 4 =", "8 + 5 =", "15 - 7 =", "9 * 2 =", "16 / 2 =", "3 + 9 =", "18 - 4 ="};
    private String[] answers = {"4", "5", "18", "3", "13", "8", "18", "8", "12", "14"};
    private String[] options = {"3", "4", "5", "6", "5", "8", "12", "14", "16", "18"};
    private String[][] op = {
            {"3", "4", "5", "6"},
            {"5", "4", "3", "1"},
            {"15", "14", "18", "23"},
            {"3", "14", "13", "33"},
            {"15", "14", "13", "23"},
            {"8", "14", "3", "2"},
            {"15", "14", "18", "12"},
            {"8", "4", "13", "11"},
            {"13", "12", "11", "22"},
            {"14", "4", "23", "21"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        buttonOption1 = findViewById(R.id.buttonOption1);
        buttonOption2 = findViewById(R.id.buttonOption2);
        buttonOption3 = findViewById(R.id.buttonOption3);
        buttonOption4 = findViewById(R.id.buttonOption4);

        updateQuestion();

        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonOption1.getText().toString());
            }
        });

        buttonOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonOption2.getText().toString());
            }
        });

        buttonOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonOption3.getText().toString());
            }
        });

        buttonOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonOption4.getText().toString());
            }
        });
    }

    private void updateQuestion() {
        Log.d("current", String.valueOf(currentQuestion));
        if (currentQuestion < questions.length) {
            String optionss[] = op[currentQuestion];
            textViewQuestion.setText(questions[currentQuestion]);
            buttonOption1.setText(optionss[0]);
            buttonOption2.setText(optionss[1]);
            buttonOption3.setText(optionss[2]);
            buttonOption4.setText(optionss[3]);
        } else {
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("score", score);
            intent.putExtra("p_name", getIntent().getStringExtra("p_name"));
            startActivity(intent);
            finish();
        }
    }



    private void checkAnswer(String selectedAnswer) {
        if (selectedAnswer.equals(answers[currentQuestion])) {
            score++;
        }
        currentQuestion++;
        updateQuestion();
    }
}
