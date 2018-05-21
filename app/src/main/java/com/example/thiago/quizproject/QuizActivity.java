package com.example.thiago.quizproject;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String lastScore = sharedPref.getString("last_score", "0");
        Toast.makeText(this, "Último score " + lastScore +"%", Toast.LENGTH_SHORT).show();

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
        listFragment.setQuestion(quizGameController.getQuestions().get(0));//set standart question

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
    public void selectIndex(int position) { //select the index intem
        //#3498db selected item position
        quizGameController.markIteInQUestion(position);
        Toast.makeText(this,"Item: " + position + "selecionado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.finalize_quiz_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.finalize_menu){
            //pass the quizGameControlelr
            Intent itenSegueFinalizeActivity = new Intent(QuizActivity.this, FinalizeActivity.class);
            itenSegueFinalizeActivity.putExtra("quizFinalize", quizGameController);
            startActivity(itenSegueFinalizeActivity);
            Toast.makeText(QuizActivity.this, "Finalize o Quiz",  Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
