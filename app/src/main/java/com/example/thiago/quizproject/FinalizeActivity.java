package com.example.thiago.quizproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.thiago.quizproject.model.QuizGameController;

public class FinalizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalize_activity);
        Intent intent = getIntent();
        QuizGameController quiz = (QuizGameController)intent.getSerializableExtra("quizFinalize");

        if(quiz != null){
            TextView campFinalize = (TextView) this.findViewById(R.id.finalize_text);
            campFinalize.setText("Quiz FInalizado com " + quiz.returnPercentCorrectAnswers() + "% Questões Corretas!");
        }

//        Button finalizeQuizButton = (Button) findViewById(R.id.finalize_button);
//        finalizeQuizButton.setOnClickListener();


    }
}
