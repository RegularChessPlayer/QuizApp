package com.example.thiago.quizproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.thiago.quizproject.model.Player;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private LoginHelper helper;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        helper = new LoginHelper(this);

        Button btn1 = (Button) findViewById(R.id.activity_login_buttonOk);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //return the model object
                player = helper.returnPlayer();
                mAuth.signInWithEmailAndPassword(player.getUserName(), player.getPassword())
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("t1", "signInWithEmail:success");
                                    Intent itentGoQuiz = new Intent(LoginActivity.this, QuizActivity.class);
                                    itentGoQuiz.putExtra("player", player);
                                    startActivity(itentGoQuiz);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("t2", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Login Inválido.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }



}
