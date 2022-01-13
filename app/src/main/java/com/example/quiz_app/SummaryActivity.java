package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SummaryActivity extends AppCompatActivity {
    TextView pointsView;
    TextView answersView;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        pointsView = findViewById(R.id.pointsTextView);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int points = extras.getInt("points");
            int answers = extras.getInt("rightAnswers");
            String text = String.valueOf(points) + " pkt!";
            String text2 = "Uzyskałeś " + String.valueOf(answers) + " dobrych odpowiedzi";
            pointsView.setText(text);
            Toast toast = Toast.makeText(this, text2,Toast.LENGTH_LONG);
            toast.show();
        }

        btnRestart = findViewById(R.id.btnRestart);
        btnRestart.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.Coral)));



    }
    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}