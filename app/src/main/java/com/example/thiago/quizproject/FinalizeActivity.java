package com.example.thiago.quizproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        final QuizGameController quiz = (QuizGameController) intent.getSerializableExtra("quizFinalize");

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);//this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("last_score", String.valueOf(quiz.returnPercentCorrectAnswers()));
        editor.commit();

        TextView campFinalize = (TextView) this.findViewById(R.id.finalize_text);
        campFinalize.setText("Quiz Finalizado com " + quiz.returnPercentCorrectAnswers() + "% Questões Corretas!");

        Button finalizeQuizButton = (Button) findViewById(R.id.finalize_button);
        finalizeQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiz.resetGame();
                Intent itenSegueQuizActivity = new Intent(FinalizeActivity.this, QuizActivity.class);
                startActivity(itenSegueQuizActivity);
            }
        });

    }
}
