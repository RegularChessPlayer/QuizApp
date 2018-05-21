package com.example.thiago.quizproject.model;

import java.io.Serializable;

public class QuestionItem implements Serializable {

    private int id;
    private String descriptionItem;
    private boolean isCorrect;

    public QuestionItem(int id, String descriptionItem, boolean isCorrect) {
        this.id = id;
        this.descriptionItem = descriptionItem;
        this.isCorrect = isCorrect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionItem() {
        return descriptionItem;
    }

    public void setDescriptionItem(String descriptionItem) {
        this.descriptionItem = descriptionItem;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

}
