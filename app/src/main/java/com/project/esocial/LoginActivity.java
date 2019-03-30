package com.project.esocial;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


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
                    goToUserPage();

            }

        });

    }

    private void verifyUserLogin(){
        System.out.println("Loging credentials " + textUsername.getText() + " and password " + textPassword.getText());
    }

    private void userIsLoggedIn() {

    }

    private void goToUserPage(){


        //Setup an intent
        Intent startIntent = new Intent(getApplicationContext(), RemCategoryActivity.class);
        //pass info to another activity
        //startIntent.putExtra("MyReminderList", adapter.getMyList(position));
        //Toast.makeText(this, "You clicked " + adapter.getMyItem(position) + " on row", Toast.LENGTH_SHORT).show();
        //Start Activity
        startActivity(startIntent);


    }

}
