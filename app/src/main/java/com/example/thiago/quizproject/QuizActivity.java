package com.example.thiago.quizproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity implements ListAdapter.ViewHolderContract {

     ListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        RecyclerView rcView = findViewById(R.id.quiz_recycler_view);

        adapter = new ListAdapter(this);
        rcView.setAdapter(adapter);

        LinearLayoutManager lnLayout = new LinearLayoutManager(this);
        rcView.setLayoutManager(lnLayout);

        adapter.addNewWord("Joao");
        adapter.addNewWord("Thiago");
        adapter.addNewWord("Leandro");

    }

    @Override
    public View.OnClickListener onClick(View view, final int position) {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this, "out of touch: " + adapter.words.get(position) , Toast.LENGTH_SHORT).show();
            }
        };

    }
}
