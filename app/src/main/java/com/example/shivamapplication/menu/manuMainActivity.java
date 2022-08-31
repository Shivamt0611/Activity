package com.example.shivamapplication.menu;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shivamapplication.MainActivity;
import com.example.shivamapplication.R;

public class manuMainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNumber;

    Button btnDial;
    Button btnCall;
    Button btnBrowser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu_main);

        etNumber = findViewById(R.id.etNumber);
        btnDial = findViewById(R.id.btnDial);
        btnCall = findViewById(R.id.btnCall);
        btnBrowser = findViewById(R.id.btnBrowser);
        //itm1 = findViewById(R.id.itm1);

        btnDial.setOnClickListener(manuMainActivity.this);
        btnCall.setOnClickListener(manuMainActivity.this);
        btnBrowser.setOnClickListener(manuMainActivity.this);
        //itm1.(manuMainActivity.this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDial:
                Intent dial = new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse("tel:" + etNumber.getText().toString()));
                startActivity(dial);
                break;
            case R.id.btnCall:
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:" + etNumber.getText().toString()));
                startActivity(call);
                break;
            case R.id.btnBrowser:
                Intent bro = new Intent(Intent.ACTION_VIEW);
                bro.setData(Uri.parse("https://www.google.com"));
                startActivity(bro);
                break;


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menush, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.miBrowser:
                Intent cas = new Intent(Intent.ACTION_VIEW);
                cas.setData(Uri.parse("https://www.google.com"));
                startActivity(cas);
                break;
        }
                return super.onOptionsItemSelected(item);
        }
    }

