package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
    TextView pointsView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        pointsView = findViewById(R.id.pointsTextView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int points = extras.getInt("points");
            //The key argument here must match that used in the other activity
            pointsView.setText(String.valueOf(points));
        }


    }
}