package com.example.thiago.quizproject.model;

import android.util.ArraySet;

import java.net.URL;
import java.util.ArrayList;

public class Question {

    private int id;
    private String desriptionQuestion;
    private URL image;
    private ArrayList<QuestionItem> items = new ArrayList<>();

    public Question(int id, String desriptionQuestion, URL image, ArrayList<QuestionItem> items){
        this.id = id;
        this.desriptionQuestion = desriptionQuestion;
        this.image = image;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesriptionQuestion() {
        return desriptionQuestion;
    }

    public void setDesriptionQuestion(String desriptionQuestion) {
        this.desriptionQuestion = desriptionQuestion;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public ArrayList<QuestionItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<QuestionItem> items) {
        this.items = items;
    }
}
