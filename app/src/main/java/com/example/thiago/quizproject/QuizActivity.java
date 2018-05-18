package com.example.thiago.quizproject;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.thiago.quizproject.fragments.FragmentContract;
import com.example.thiago.quizproject.fragments.ListFragment;
import com.example.thiago.quizproject.model.Question;
import com.example.thiago.quizproject.model.QuestionItem;

import java.util.ArrayList;


public class QuizActivity extends AppCompatActivity implements FragmentContract {

    ListFragment listFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        listFragment = ListFragment.newInstance();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.first_fragment, listFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();

        QuestionItem item1 = new QuestionItem();
        item1.setId(1);
        item1.setCorrect(true);
        item1.setDescriptionItem("Alemanha");

        QuestionItem item2 = new QuestionItem();
        item2.setId(2);
        item2.setCorrect(false);
        item2.setDescriptionItem("Italia");

        ArrayList<QuestionItem> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);

        Question q1 = new Question(1, "Questão1", null, list);

        listFragment.setQuestion(q1);
    }

    @Override
    public void selectIndex(int position) {
        Toast.makeText(this,"Position" + position, Toast.LENGTH_SHORT).show();
    }
}
