package com.example.shivamapplication.registration_demo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.shivamapplication.MainActivity;
import com.example.shivamapplication.R;

public class Registration extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    EditText etFirstName;
    EditText etMiddleName;
    EditText etLastName;

    RadioGroup rgGender;
    RadioButton rbMale;
    RadioButton rbFemale;

    Spinner spSemesters;

    TextView tvDOB;
    Button btnSetDOB;

    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etFirstName = findViewById(R.id.etFirstName);
        etMiddleName = findViewById(R.id.etMiddleName);
        etLastName = findViewById(R.id.etLastName);

        rgGender = findViewById(R.id.rgGender);
        rgGender.setOnCheckedChangeListener(Registration.this);

        spSemesters = findViewById(R.id.spSemesters);
        spSemesters.setOnItemSelectedListener(Registration.this);

        tvDOB = findViewById(R.id.tvDOB);
        btnSetDOB = findViewById(R.id.btnSetDOB);


        btnSubmit = findViewById(R.id.btnSubmit);

        btnSetDOB.setOnClickListener(Registration.this);
        btnSubmit.setOnClickListener(Registration.this);

        // on click of submit,pass all the values to MainActivity and display in console from MainActivity

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnSubmit:
                fnSubmit();
                break;
            case R.id.btnSetDOB:
                fnSetDOB();
                break;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void fnSetDOB() {

        DatePickerDialog dateDialog = new DatePickerDialog(Registration.this);

       dateDialog.setOnDateSetListener(Registration.this);

       dateDialog.show();

        //TimePickerDialog td = new TimePickerDialog(Registration.this,Registration.this,5,15,true);
        //td.show();


    }

    private void fnSubmit() {
        String firstName = etFirstName.getText().toString();
        String middleName = etMiddleName.getText().toString();
        String lastName = etLastName.getText().toString();

        //System.out.println(firstName);
        Log.d("First Name", firstName);
        Log.d("Middle Name", middleName);
        Log.d("Last Name", lastName);

        String selectedGender;
        switch(rgGender.getCheckedRadioButtonId()){
            case R.id.rbMale:
                selectedGender = "MALE";
                Log.d("Submitting Gender","MALE");
                break;
            case R.id.rbFemale:
                selectedGender = "FEMALE";
                Log.d("Submitting Gender","FEMALE");
                break;
            default:
                selectedGender = "MALE";
        }

        Log.d("Submitting semester",spSemesters.getSelectedItem().toString());

        Intent next = new Intent(Registration.this, MainActivity.class);

        next.putExtra("key_first_name",firstName);
        next.putExtra("key_middle_name",middleName);
        next.putExtra("key_last_name",lastName);

        next.putExtra("key_gender",selectedGender);

        next.putExtra("key_semester",spSemesters.getSelectedItem().toString());

        Registration.this.startActivity(next);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.rbMale:
                Log.d("Gender","MALE");
                break;
            case R.id.rbFemale:
                Log.d("Gender","FEMALE");
                break;


        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

      Log.d( "Selected semester", parent.getSelectedItem().toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        tvDOB.setText(year + "-" + (month+1) + "-" + dayOfMonth);

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        tvDOB.setText(""+hourOfDay+":"+minute);

    }
}

