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


public class QuizActivity extends AppCompatActivity implements FragmentContract {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ListFragment listFragment = ListFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.first_fragment, listFragment);
        fragmentTransaction.commit();

    }


    @Override
    public void selectIndex(int position) {
        Toast.makeText(this,"Position" + position, Toast.LENGTH_SHORT).show();
    }
}
