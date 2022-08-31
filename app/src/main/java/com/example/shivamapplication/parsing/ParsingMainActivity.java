package com.example.shivamapplication.parsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shivamapplication.R;
import com.example.shivamapplication.Test.Test_MainActivity;
import com.example.shivamapplication.json_demo.MainActivity;

public class ParsingMainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textV1;
    TextView textV2;

    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing_main);

        textV1 = findViewById(R.id.textV1);
        textV2 = findViewById(R.id.textV2);

        button1 = findViewById(R.id.button1);


        button1.setOnClickListener(ParsingMainActivity.this);

    }

    @Override
    public void onClick(View view) {
       // if (textV1.getText().toString().equals("202100721010139") && textV2.getText().toString().equals("Tomar Shivam")){
            Intent next = new Intent(ParsingMainActivity.this, MainActivity.class);

            //next.putExtra("loggedInUsername",et1Name.getText().toString());

            ParsingMainActivity.this.startActivity(next);
        //}
    }
}