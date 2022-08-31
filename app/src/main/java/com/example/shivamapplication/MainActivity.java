package com.example.shivamapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView tvCurrentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle receivedBundle = getIntent().getExtras();

        String userName = receivedBundle.getString("loggedInUsername");

        Log.d("Received Bundle",receivedBundle.toString());

       Log.d("Received First Name",receivedBundle.getString("key_first_name"));
       Log.d("Received Middle Name",receivedBundle.getString("key_middle_name"));
        Log.d("Received Last Name",receivedBundle.getString("key_last_name"));


        Log.d("Received Gender",receivedBundle.getString("key_gender"));
        Log.d("Received Semesters",receivedBundle.getString("key_semester"));



        setContentView(R.layout.activity_main);

        //tvCurrentUsername = findViewById(R.id.tvCurrentUsername);

       // tvCurrentUsername.setText(userName);

    }
}