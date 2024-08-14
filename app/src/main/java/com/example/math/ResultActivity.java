package com.example.math;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewScore = findViewById(R.id.textViewScore);
        TextView textViewName = findViewById(R.id.textViewName);
        Button buttonRestart = findViewById(R.id.buttonRestart);

        int score = getIntent().getIntExtra("score", 0);
        String name = getIntent().getStringExtra("p_name");

        textViewScore.setText("Your score: " + score);
        textViewName.setText("Player name: " + name);

        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
