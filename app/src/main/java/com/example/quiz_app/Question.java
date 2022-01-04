package com.example.quiz_app;

import android.widget.ImageView;

import java.util.ArrayList;

public class Question {
    String question;
    ArrayList<Answer> answers;
    boolean hasImg;
    String img;

    public Question(String question, ArrayList<Answer> answers, boolean hasImg) {
        this.question = question;
        this.answers = answers;
        this.hasImg = hasImg;
    }

    public Question(String question, ArrayList<Answer> answers, boolean hasImg, String img) {
        this.question = question;
        this.answers = answers;
        this.hasImg = hasImg;
        this.img = img;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public boolean isHasImg() {
        return hasImg;
    }

    public String getImg() {
        return img;
    }
}
