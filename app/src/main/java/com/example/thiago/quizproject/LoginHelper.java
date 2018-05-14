package com.example.thiago.quizproject;

import android.widget.EditText;

import com.example.thiago.quizproject.model.Player;

public class LoginHelper {

    private final EditText fieldUserName;
    private final EditText fieldPassword;
    private Player player;

    public LoginHelper(LoginActivity activity){
        fieldUserName = (EditText) activity.findViewById(R.id.activity_login_username);
        fieldPassword = (EditText) activity.findViewById(R.id.activity_login_password);
        player = new Player();
    }

    public Player returnPlayer(){
        player.setUserName(fieldUserName.getText().toString());
        player.setPassword(fieldPassword.getText().toString());
        //do logic to persit score.
        return player;
    }

}
