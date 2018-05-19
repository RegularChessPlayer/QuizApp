package com.example.thiago.quizproject;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.thiago.quizproject.fragments.FragmentContract;
import com.example.thiago.quizproject.fragments.ListFragment;
import com.example.thiago.quizproject.model.Question;
import com.example.thiago.quizproject.model.QuestionItem;
import com.example.thiago.quizproject.model.QuizGameController;

import java.util.ArrayList;


public class QuizActivity extends AppCompatActivity implements FragmentContract {

    ListFragment listFragment;
    FragmentManager fragmentManager;
    QuizGameController quizGameController = new QuizGameController();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        listFragment = ListFragment.newInstance();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.first_fragment, listFragment);
        fragmentTransaction.commit();
        quizGameController.setupDumyQuestions();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        listFragment.setQuestion(quizGameController.getQuestions().get(0));

        Button back = (Button) findViewById(R.id.back_question);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listFragment.setQuestion(quizGameController.backQuestion());
            }
        });

        Button next = (Button) findViewById(R.id.next_question);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listFragment.setQuestion(quizGameController.nexQuestion());
            }
        });

    }

    @Override
    public void selectIndex(int position) {
        Toast.makeText(this,"Questão  " + position, Toast.LENGTH_SHORT).show();
    }
}
