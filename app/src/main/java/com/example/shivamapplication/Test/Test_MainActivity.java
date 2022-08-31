package com.example.shivamapplication.Test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shivamapplication.R;
import com.example.shivamapplication.json_demo.MainActivity;
import com.example.shivamapplication.login_demo.LoginActivity;
import com.example.shivamapplication.parsing.ParsingMainActivity;

public class Test_MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et1Name;
    EditText et1Password;

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);

        et1Name = findViewById(R.id.et1Name);
        et1Password = findViewById(R.id.et1Password);

        login = findViewById(R.id.login);

        login.setOnClickListener(Test_MainActivity.this);
        
    }

    @Override
    public void onClick(View view) {
        if (et1Name.getText().toString().equals("st456712389@gmail.com") && et1Password.getText().toString().equals("0611")) {
            Toast.makeText(Test_MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();


            Intent next = new Intent(Test_MainActivity.this, ParsingMainActivity.class);

            //next.putExtra("loggedInUsername",et1Name.getText().toString());

            Test_MainActivity.this.startActivity(next);
        }else {
            Toast.makeText(Test_MainActivity.this, "Email Or Password Not Found", Toast.LENGTH_SHORT).show();


        }

    }
}

