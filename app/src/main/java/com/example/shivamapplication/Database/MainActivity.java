package com.example.shivamapplication.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.shivamapplication.R;

public class MainActivity<Student> extends AppCompatActivity implements View.OnClickListener {
    Button btnAddRecord;
    Button btnShowRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        btnAddRecord = findViewById(R.id.btnAddRecord);
        btnShowRecords = findViewById(R.id.btnShowRecords);

        btnAddRecord.setOnClickListener(MainActivity.this);
        btnShowRecords.setOnClickListener(MainActivity.this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddRecord:


                break;
            case R.id.btnShowRecords:

                showAllRecords();

                break;

        }
    }


    @SuppressLint("Range")
    private void showAllRecords() {
        MyDBHelper dbHelper = new MyDBHelper(MainActivity.this, MyDBHelper.DBNAME, null, 1);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columnsToFetch = {"tRollNo", "tFirstName", "tMiddleName", "tLastName"};
        Cursor records = db.query("tblstudents", columnsToFetch, null, null, null, null, null);

        while (records.moveToNext()) {

            Log.d("Roll No", "" + records.getString(0));
            Log.d("First Name", "" + records.getString(1));
            Log.d("Middle Name", "" + records.getString(2));
            Log.d("Last Name", "" + records.getString(3));

            records.getString(0);
            int indexOfFName = records.getColumnIndex("tFirstName");
            records.getString(indexOfFName);


            records.getString(records.getColumnIndex("tFirstName"));


        }
    }
}


