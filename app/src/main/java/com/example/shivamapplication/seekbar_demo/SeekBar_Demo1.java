package com.example.shivamapplication.seekbar_demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.shivamapplication.R;

public class SeekBar_Demo1 extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {


    SeekBar sbRed;
    SeekBar sbGreen;
    SeekBar sbBlue;

    TextView tvColorCode;

    LinearLayout llcolor;

    int red;
    int green;
    int blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_demo1);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);

        tvColorCode = findViewById(R.id.tvColorCode);

        llcolor = findViewById(R.id.llColor);

        sbRed.setOnSeekBarChangeListener(SeekBar_Demo1.this);
        sbGreen.setOnSeekBarChangeListener(SeekBar_Demo1.this);
        sbBlue.setOnSeekBarChangeListener(SeekBar_Demo1.this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.sbRed:
                red = progress;
                break;
            case R.id.sbGreen:
                green = progress;
                break;
            case R.id.sbBlue:
                blue = progress;
                break;
        }
          tvColorCode.setText(red + "-" + green + "-" + blue);

        int currentColor = Color.rgb(red,green,blue);
        llcolor.setBackgroundColor(currentColor);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}