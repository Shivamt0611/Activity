package com.example.shivamapplication.login_demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shivamapplication.MainActivity;
import com.example.shivamapplication.R;
import com.example.shivamapplication.registration_demo.Registration;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUserName;
    EditText etPassword;

    CheckBox cbRememberMe;

    Button btnLogin;

    TextView tvLoginStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = getSharedPreferences("spUserSettings", MODE_PRIVATE);


        String fetchedUserName = sp.getString("spKeyUserName", "No User found ");
        String fetchedUserPassword = sp.getString("spKeyUserPassword", "No Password found ");



        
        setContentView(R.layout.activity_login);

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);

        cbRememberMe = findViewById(R.id.cbRememberMe);

        etUserName.setText(fetchedUserName);
        etPassword.setText(fetchedUserPassword);

        btnLogin = findViewById(R.id.btnLogin);

        //tvLoginStatus = findViewById(R.id.tvLoginStatus);

        // bind an event listner with the button
        btnLogin.setOnClickListener(LoginActivity.this);


    }

    @Override
    public void onClick(View view) {

        // check the user name and the password to be correct
       // if (etPhone.getText().toString().equals("Shivam123") && etPassword.getText().toString().equals("Shivam@0611")){
         if ( etPassword.getText().toString().equals("Shivam@0611")){

       // if 'remember me' is selected then save the user name and password for next use
             if(cbRememberMe.isChecked())
             {
                 SharedPreferences sp = getSharedPreferences(getResources().getString(R.string.spUserSettings), MODE_PRIVATE);

                 SharedPreferences.Editor spEditor = sp.edit();
                 spEditor.putString(getResources().getString(R.string.spKeyUserName),etUserName.getText().toString());
                 spEditor.putString(getResources().getString(R.string.spKeyUserPassword),etPassword.getText().toString());
                 spEditor.apply();
             }


            // if correct then display OK in the text view
            //tvLoginStatus.setText("Login Successful");

            //if the credentials are correct,then start a new activity

            //Intent specifies from which OBJECT to move to new CLASS
            Intent next = new Intent(LoginActivity.this, MainActivity.class);

            // put the (key, value) pair to transfer to the next activity
            next.putExtra("loggedInUsername",etUserName.getText().toString());


            //Once the intent is specified,start the activity with the intent
            LoginActivity.this.startActivity(next);

        }
        else {

            // if NOT correct then display "Wrong credentials" in the text view
            // tvLoginStatus.setText("Wrong UserName Or Password");

            Toast.makeText(LoginActivity.this, "Invalid Credentials",Toast.LENGTH_SHORT).show();

            Intent toRegistration = new Intent(LoginActivity.this, Registration.class);

            LoginActivity.this.startActivity(toRegistration);


        }





    }
}