package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    List<Integer> numbers = IntStream.range(0, 4).boxed().collect(Collectors.toList());
    int points;
    int additionalPoints;
    int questionNumber = 0;
    int questionsRight = 0;

    private Button btnAnswer1;
    private Button btnAnswer2;
    private Button btnAnswer3;
    private Button btnAnswer4;

    private TextView questionTextView;
    private ImageView questionView;
    private ProgressBar progressBar;
    private CountDownTimer CountDownTimer;

    /**
     * Zestaw obiektów związanych z pytaniami
     */

    Answer Q1A1 = new Answer("kot", true);
    Answer Q1A2 = new Answer("pies", false);
    Answer Q1A3 = new Answer("kaczka", false);
    Answer Q1A4 = new Answer("krowa", false);
    ArrayList<Answer> q1a = new ArrayList<>(Arrays.asList(Q1A1, Q1A2, Q1A3, Q1A4));
    Question q1 = new Question("Jakie zwierzę jest na tym zdjęciu?", q1a, true, "cat");

    Answer Q2A1 = new Answer("wróbel", true);
    Answer Q2A2 = new Answer("papuga", false);
    Answer Q2A3 = new Answer("sikorka", false);
    Answer Q2A4 = new Answer("kopciuszek", false);
    ArrayList<Answer> q2a = new ArrayList<>(Arrays.asList(Q2A1, Q2A2, Q2A3, Q2A4));
    Question q2 = new Question("Jakie zwierzę jest na tym zdjęciu?", q2a, true, "bird");

    Answer Q3A1 = new Answer("Pies", true);
    Answer Q3A2 = new Answer("Chomik", false);
    Answer Q3A3 = new Answer("Kot", false);
    Answer Q3A4 = new Answer("Nie wiem", false);
    ArrayList<Answer> q3a = new ArrayList<>(Arrays.asList(Q3A1, Q3A2, Q3A3, Q3A4));
    Question q3 = new Question("Jakie zwierzę jest na tym zdjęciu?", q3a, true, "dog");

    Answer Q4A1 = new Answer("Gołąb", false);
    Answer Q4A2 = new Answer("Paw", true);
    Answer Q4A3 = new Answer("Kaczka", false);
    Answer Q4A4 = new Answer("Kura", false);
    ArrayList<Answer> q4a = new ArrayList<>(Arrays.asList(Q4A1, Q4A2, Q4A3, Q4A4));
    Question q4 = new Question("Jakie zwierzę jest na tym zdjęciu?", q4a, true, "paw");

    Answer Q5A1 = new Answer("Gołąb", false);
    Answer Q5A2 = new Answer("Paw", true);
    Answer Q5A3 = new Answer("Kaczka", false);
    Answer Q5A4 = new Answer("Kura", false);
    ArrayList<Answer> q5a = new ArrayList<>(Arrays.asList(Q5A1, Q5A2, Q5A3, Q5A4));
    Question q5 = new Question("Jakie zwierzę jest na tym zdjęciu?", q5a, true, "horse");

    Answer Q6A1 = new Answer("Gołąb", false);
    Answer Q6A2 = new Answer("Paw", true);
    Answer Q6A3 = new Answer("Kaczka", false);
    Answer Q6A4 = new Answer("Kura", false);
    ArrayList<Answer> q6a = new ArrayList<>(Arrays.asList(Q6A1, Q6A2, Q6A3, Q6A4));
    Question q6 = new Question("Jakie zwierzę jest na tym zdjęciu?", q6a, true, "hamster");

    Answer Q7A1 = new Answer("Gołąb", false);
    Answer Q7A2 = new Answer("Paw", true);
    Answer Q7A3 = new Answer("Kaczka", false);
    Answer Q7A4 = new Answer("Kura", false);
    ArrayList<Answer> q7a = new ArrayList<>(Arrays.asList(Q7A1, Q7A2, Q7A3, Q7A4));
    Question q7 = new Question("Jakie zwierzę jest na tym zdjęciu?", q7a, true, "elephant");

    Answer Q8A1 = new Answer("Gołąb", false);
    Answer Q8A2 = new Answer("Paw", true);
    Answer Q8A3 = new Answer("Kaczka", false);
    Answer Q8A4 = new Answer("Kura", false);
    ArrayList<Answer> q8a = new ArrayList<>(Arrays.asList(Q8A1, Q8A2, Q8A3, Q8A4));
    Question q8 = new Question("Jakie zwierzę jest na tym zdjęciu?", q8a, true, "cangaroo");

    Answer Q9A1 = new Answer("Plantan", true);
    Answer Q9A2 = new Answer("Banan", false);
    Answer Q9A3 = new Answer("Nie wiem", false);
    Answer Q9A4 = new Answer("Zielony banan", false);
    ArrayList<Answer> q9a = new ArrayList<>(Arrays.asList(Q9A1, Q9A2, Q9A3, Q9A4));
    Question q9 = new Question("Co jest na tym zdjęciu?", q9a, true, "plantan");

    Answer Q10A1 = new Answer("Różowy owoc", false);
    Answer Q10A2 = new Answer("Pitaja", true);
    Answer Q10A3 = new Answer("Odmiana śliwki", false);
    Answer Q10A4 = new Answer("Liczi", false);
    ArrayList<Answer> q10a = new ArrayList<>(Arrays.asList(Q10A1, Q10A2, Q10A3, Q10A4));
    Question q10 = new Question("Jaki owoc jest na tym zdjęciu?", q10a, true, "pitaja");

    Answer Q11A1 = new Answer("Gołąb", false);
    Answer Q11A2 = new Answer("Paw", false);
    Answer Q11A3 = new Answer("Kaczka", false);
    Answer Q11A4 = new Answer("Kuoka", true);
    ArrayList<Answer> q11a = new ArrayList<>(Arrays.asList(Q11A1, Q11A2, Q11A3, Q11A4));
    Question q11 = new Question("Jakie zwierzę jest na tym zdjęciu?", q11a, true, "kuoka");

    Answer Q12A1 = new Answer("Gołąb", false);
    Answer Q12A2 = new Answer("Paw", true);
    Answer Q12A3 = new Answer("Kaczka", false);
    Answer Q12A4 = new Answer("Kura", false);
    ArrayList<Answer> q12a = new ArrayList<>(Arrays.asList(Q12A1, Q12A2, Q12A3, Q12A4));
    Question q12 = new Question("Jakie zwierzę jest na tym zdjęciu?", q12a, true, "leniwiec");

    Answer Q13A1 = new Answer("Gołąb", false);
    Answer Q13A2 = new Answer("Ara", true);
    Answer Q13A3 = new Answer("Kaczka", false);
    Answer Q13A4 = new Answer("Kura", false);
    ArrayList<Answer> q13a = new ArrayList<>(Arrays.asList(Q13A1, Q13A2, Q13A3, Q13A4));
    Question q13 = new Question("Jakie zwierzę jest na tym zdjęciu?", q13a, true, "ara");

    Answer Q14A1 = new Answer("Jaszczurka", false);
    Answer Q14A2 = new Answer("Kameleon", true);
    Answer Q14A3 = new Answer("Kaczka", false);
    Answer Q14A4 = new Answer("Kura", false);
    ArrayList<Answer> q14a = new ArrayList<>(Arrays.asList(Q14A1, Q14A2, Q14A3, Q14A4));
    Question q14 = new Question("Jakie zwierzę jest na tym zdjęciu?", q14a, true, "kameleon");

    Answer Q15A1 = new Answer("Gołąb", false);
    Answer Q15A2 = new Answer("Paw", true);
    Answer Q15A3 = new Answer("Kaczka", false);
    Answer Q15A4 = new Answer("Kura", false);
    ArrayList<Answer> q15a = new ArrayList<>(Arrays.asList(Q15A1, Q15A2, Q15A3, Q15A4));
    Question q15 = new Question("Jakie zwierzę jest na tym zdjęciu?", q15a, true, "koala");

    Answer Q16A1 = new Answer("1982", false);
    Answer Q16A2 = new Answer("2021", false);
    Answer Q16A3 = new Answer("2020", false);
    Answer Q16A4 = new Answer("2022", true);
    ArrayList<Answer> q16a = new ArrayList<>(Arrays.asList(Q16A1, Q16A2, Q16A3, Q16A4));
    Question q16 = new Question("Który mamy rok?", q16a, false);

    Answer Q17A1 = new Answer("1996", false);
    Answer Q17A2 = new Answer("1995", true);
    Answer Q17A3 = new Answer("2000", false);
    Answer Q17A4 = new Answer("1997", false);
    ArrayList<Answer> q17a = new ArrayList<>(Arrays.asList(Q17A1, Q17A2, Q17A3, Q17A4));
    Question q17 = new Question("W którym po raz pierwszy pojawiła się Java?", q17a, false);

    Answer Q18A1 = new Answer("9 miesięcy", false);
    Answer Q18A2 = new Answer("6 miesięcy", false);
    Answer Q18A3 = new Answer("Prawie 2 lata", true);
    Answer Q18A4 = new Answer("Rok", false);
    ArrayList<Answer> q18a = new ArrayList<>(Arrays.asList(Q18A1, Q18A2, Q18A3, Q18A4));
    Question q18 = new Question("Ile trwa ciąża słonia?", q18a, false);

    Answer Q19A1 = new Answer("10-12", true);
    Answer Q19A2 = new Answer("15-30", false);
    Answer Q19A3 = new Answer("40-45", false);
    Answer Q19A4 = new Answer("50", false);
    ArrayList<Answer> q19a = new ArrayList<>(Arrays.asList(Q19A1, Q19A2, Q19A3, Q19A4));
    Question q19 = new Question("Ile par odnóg ma stonoga?", q19a, false);

    Answer Q20A1 = new Answer("Comet Lake", false);
    Answer Q20A2 = new Answer("Alder Lake", true);
    Answer Q20A3 = new Answer("Coffee Lake", false);
    Answer Q20A4 = new Answer("Kaby Lake", false);
    ArrayList<Answer> q20a = new ArrayList<>(Arrays.asList(Q20A1, Q20A2, Q20A3, Q20A4));
    Question q20 = new Question("Jak nazywa się 12. generacja procesorów Intel?", q20a, false);

    Answer Q21A1 = new Answer("2008", true);
    Answer Q21A2 = new Answer("2007", false);
    Answer Q21A3 = new Answer("2006", false);
    Answer Q21A4 = new Answer("2009", false);
    ArrayList<Answer> q21a = new ArrayList<>(Arrays.asList(Q21A1, Q21A2, Q21A3, Q21A4));
    Question q21 = new Question("W którym roku wydano Androida 1.0?", q21a, false);

    Answer Q22A1 = new Answer("Apple Crumble", false);
    Answer Q22A2 = new Answer("Apple", false);
    Answer Q22A3 = new Answer("Apple Strudel", false);
    Answer Q22A4 = new Answer("Apple Pie", true);
    ArrayList<Answer> q22a = new ArrayList<>(Arrays.asList(Q22A1, Q22A2, Q22A3, Q22A4));
    Question q22 = new Question("Jak nazywa się wersja Androida 1.0?", q22a, false);

    Answer Q23A1 = new Answer("Brown Sugar", false);
    Answer Q23A2 = new Answer("Banana", false);
    Answer Q23A3 = new Answer("Eclair", false);
    Answer Q23A4 = new Answer("Banana Bread", true);
    ArrayList<Answer> q23a = new ArrayList<>(Arrays.asList(Q23A1, Q23A2, Q23A3, Q23A4));
    Question q23 = new Question("Jak nazywa się wersja Androida 2.0?", q23a, false);

    Answer Q24A1 = new Answer("KitKat", true);
    Answer Q24A2 = new Answer("MilkyWay", false);
    Answer Q24A3 = new Answer("Mars", false);
    Answer Q24A4 = new Answer("Twix", false);
    ArrayList<Answer> q24a = new ArrayList<>(Arrays.asList(Q24A1, Q24A2, Q24A3, Q24A4));
    Question q24 = new Question("Jak nazywa się wersja Androida 4.4?", q24a, false);

    Answer Q25A1 = new Answer("Motorola", false);
    Answer Q25A2 = new Answer("LG", false);
    Answer Q25A3 = new Answer("Google", false);
    Answer Q25A4 = new Answer("HTC", true);
    ArrayList<Answer> q25a = new ArrayList<>(Arrays.asList(Q25A1, Q25A2, Q25A3, Q25A4));
    Question q25 = new Question("Która marka telefonów wypuściła pierwszy telefon z systemem Android 1.0?", q25a, false);

    Answer Q26A1 = new Answer("Android 12", false);
    Answer Q26A2 = new Answer("Android 11", false);
    Answer Q26A3 = new Answer("Android 10", true);
    Answer Q26A4 = new Answer("Android 9", false);
    ArrayList<Answer> q26a = new ArrayList<>(Arrays.asList(Q26A1, Q26A2, Q26A3, Q26A4));
    Question q26 = new Question("Która wersja systemu Android jest obecnie najpopularniejsza?", q26a, false);

    Answer Q27A1 = new Answer("8-12 godzin", false);
    Answer Q27A2 = new Answer("Poniżej 8 godzin", false);
    Answer Q27A3 = new Answer("Powyżej 16 godzin", false);
    Answer Q27A4 = new Answer("12-16 godzin", true);
    ArrayList<Answer> q27a = new ArrayList<>(Arrays.asList(Q27A1, Q27A2, Q27A3, Q27A4));
    Question q27 = new Question("Ile czasu średnio śpią koty w ciągu dnia?", q27a, false);

    Answer Q28A1 = new Answer("Java SE 16", true);
    Answer Q28A2 = new Answer("Java SE 15", false);
    Answer Q28A3 = new Answer("Java SE 17", false);
    Answer Q28A4 = new Answer("Java SE 18", false);
    ArrayList<Answer> q28a = new ArrayList<>(Arrays.asList(Q28A1, Q28A2, Q28A3, Q28A4));
    Question q28 = new Question("Jaka jest aktualnie najnowsza wersja Javy", q28a, false);

    Answer Q29A1 = new Answer("12. generacja", false);
    Answer Q29A2 = new Answer("10. generacja", false);
    Answer Q29A3 = new Answer("11. generacja", true);
    Answer Q29A4 = new Answer("Nie zaprezentował", false);
    ArrayList<Answer> q29a = new ArrayList<>(Arrays.asList(Q29A1, Q29A2, Q29A3, Q29A4));
    Question q29 = new Question("Wraz z którą wersją procesorów Intel zaprezentował Thunderbolt 4?", q29a, false);

    Answer Q30A1 = new Answer("Nie", false);
    Answer Q30A2 = new Answer("Jest super", false);
    Answer Q30A3 = new Answer("Jest najlepszy!!!", true);
    Answer Q30A4 = new Answer("Tak", true);
    ArrayList<Answer> q30a = new ArrayList<>(Arrays.asList(Q30A1, Q30A2, Q30A3, Q30A4));
    Question q30 = new Question("Czy podoba się ten projekt?", q30a, false);

    /**
     * questions - lista pytań do gry
     */

    ArrayList<Question> questions = new ArrayList<>(Arrays.asList(
            q1, q2, q3, q4, q5, q6, q7, q8, q9, q10,
            q11, q12, q13, q14, q15, q16, q17, q18, q19, q20,
            q21, q22, q23, q24, q25, q26, q27, q28, q29, q30));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questionView = findViewById(R.id.questionImageView);

        questionTextView = findViewById(R.id.questionTextView);
        shuffleQuestions(questions);


        btnAnswer1 = findViewById(R.id.btnAnswer1);
        btnAnswer1.setOnClickListener(this);
        setColor(btnAnswer1, 0);

        btnAnswer2 = findViewById(R.id.btnAnswer2);
        btnAnswer2.setOnClickListener(this);
        setColor(btnAnswer2, 0);

        btnAnswer3 = findViewById(R.id.btnAnswer3);
        btnAnswer3.setOnClickListener(this);
        setColor(btnAnswer3, 0);

        btnAnswer4 = findViewById(R.id.btnAnswer4);
        btnAnswer4.setOnClickListener(this);
        setColor(btnAnswer4, 0);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(10);
        progressBar.setIndeterminate(false);

        setQuestion();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAnswer1:
                if (checkAnswer(0)) {
                    questionsRight++;
                    points = 10 + additionalPoints;
                    setColor(btnAnswer1, 1);
                } else {
                    setColor(btnAnswer1, 2);
                }
                CountDownTimer.cancel();
                break;
            case R.id.btnAnswer2:
                if (checkAnswer(1)) {
                    questionsRight++;
                    points = 10 + additionalPoints;
                    setColor(btnAnswer2, 1);
                } else {
                    setColor(btnAnswer2, 2);
                }
                CountDownTimer.cancel();
                break;
            case R.id.btnAnswer3:
                if (checkAnswer(2)) {
                    questionsRight++;
                    points = 10 + additionalPoints;
                    setColor(btnAnswer3, 1);
                } else {
                    setColor(btnAnswer3, 2);
                }
                CountDownTimer.cancel();
                break;
            case R.id.btnAnswer4:
                if (checkAnswer(3)) {
                    questionsRight++;
                    points = 10 + additionalPoints;
                    setColor(btnAnswer4, 1);
                } else {
                    setColor(btnAnswer4, 2);
                }
                CountDownTimer.cancel();
                break;
        }
        nextQuestion();
    }

    private void setQuestion() {
        Question q = questions.get(questionNumber); //ustaw pytanie
        Collections.shuffle(numbers); //przelosuj nr odpowiedzi
        additionalPoints = 100; //ustaw pulę dodatkowych punktów

        /*
          Ustawianie obrazka i widoczności w zależności od tego, czy pytanie zawiera obrazek
         */

        if (q.hasImg) {
            questionView.setVisibility(View.VISIBLE);
            questionView.setImageResource(setResID(q.getImg())); //ustaw obrazek pytania jeżeli ma

        } else {
            questionView.setVisibility(View.INVISIBLE);
        }
        //ustaw tekst pytania
        questionTextView.setText(q.getQuestion());

        //ustaw tekst odpowiedzi
        btnAnswer1.setText(q.getAnswers().get(numbers.get(0)).answer);
        btnAnswer2.setText(q.getAnswers().get(numbers.get(1)).answer);
        btnAnswer3.setText(q.getAnswers().get(numbers.get(2)).answer);
        btnAnswer4.setText(q.getAnswers().get(numbers.get(3)).answer);

        //ustawianie progress bar i odliczanie czasu dla bonusowych punktów

        if (questionNumber < 10) {
            CountDownTimer = new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    int progress = (int) (millisUntilFinished / 1000);
                    additionalPoints = (int)(millisUntilFinished / 100);
                    progressBar.setProgress(progressBar.getMax() - progress);
                }
                @Override
                public void onFinish() {
                    nextQuestion();
                }
            };
            CountDownTimer.start();
        }
    }

    /**
     * Funkcja zwracająca id obrazka z resources o podanym drawable name
     *
     * @param drawableName
     * @return zwraca id obrazka
     */
    public int setResID(String drawableName) {
        return getResources().getIdentifier(drawableName, "drawable", getPackageName());
    }

    public void shuffleQuestions(ArrayList<Question> questions) {
        Collections.shuffle(questions);
    }

    public boolean checkAnswer(int answerIndex) {
        return questions.get(questionNumber).getAnswers().get(numbers.get(answerIndex)).isTrue;
    }

/*    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }*/

    public void resetStuff() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            setColor(btnAnswer1, 0);
            setColor(btnAnswer2, 0);
            setColor(btnAnswer3, 0);
            setColor(btnAnswer4, 0);
            progressBar.setProgress(0);
            setQuestion();
        }, 1000);
    }

    public void setColor(Button btn, int change) {
        switch (change) {
            case 0: //defaultowy kolor
                btn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.MediumPurple)));
                break;
            case 1: //kolor poprawnej odpowiedzi
                btn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.ForestGreen)));
                break;
            case 2: //kolor złej odpowiedzi
                btn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.OrangeRed)));
                break;
        }
    }

    public void endGame() {
        Intent intent = new Intent(GameActivity.this, SummaryActivity.class);
        intent.putExtra("points", points);
        intent.putExtra("rightAnswers", questionsRight);
        startActivity(intent);
    }
    public void nextQuestion() {
        if (questionNumber < 9) {
            questionNumber++;
            resetStuff();
        } else {
            endGame();
        }
    }
}