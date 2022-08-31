package com.example.shivamapplication.diallogbt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.shivamapplication.R;

public class MainActivity extends AppCompatActivity {
   Button dialogbtn;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dialogbtn = findViewById(R.id.dialogbtn);
        Button custBtn = findViewById(R.id.custBtn);

    }
}