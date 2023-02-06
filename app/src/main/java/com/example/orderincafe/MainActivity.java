package com.example.orderincafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameOfUser;
    private EditText editPassword;
    private Button buttonSingIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


        buttonSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = nameOfUser.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();

                } else{
                    launchSecondScreen(username);
                }
            }
        });
    }

    private void launchSecondScreen(String username){
        Intent intent = OrderActivity.newIntent(this, username);
        startActivity(intent);
    }


    private void initViews(){
        nameOfUser = findViewById(R.id.editTextName);
        editPassword = findViewById(R.id.editTextPassword);
        buttonSingIn = findViewById(R.id.buttonSignIn);

    }
}