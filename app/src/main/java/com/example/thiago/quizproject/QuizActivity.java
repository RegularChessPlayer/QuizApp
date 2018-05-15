package com.example.thiago.quizproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;


public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        RecyclerView rcView = findViewById(R.id.quiz_recycler_view);
        RecyclerView.Adapter adapter =  new ListAdapter();

        rcView.setAdapter(adapter);

        LinearLayout lnLayout = new LinearLayout(this);
        rcView.setLayoutManager(lnLayout);


    }

}
