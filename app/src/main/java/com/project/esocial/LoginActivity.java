package com.project.esocial;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

    private EditText textUsername, textPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);


        userIsLoggedIn();

        textUsername = findViewById(R.id.inputUsername);
        textPassword = findViewById(R.id.inputUserpassword);
        btnLogin = findViewById(R.id.userLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                    System.out.println("onclick code");
                    verifyUserLogin();

            }

        });

    }

    private void verifyUserLogin(){
        System.out.println("Loging credentials " + textUsername.getText() + " and password " + textPassword.getText());
    }

    private void userIsLoggedIn() {

    }

}
