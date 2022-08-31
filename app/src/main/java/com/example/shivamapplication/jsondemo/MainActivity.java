package com.example.shivamapplication.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.shivamapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String jsondata = "{{\n" +
                "     \"Id\":\"1\"\n" +
                "     \"Name\":{\n" +
                "       \"First_Name\":\"Shivam\"\n" +
                "       \"Last_Name\":\"Tomar\"\n" +
                " },\n" +
                "     \"Country\":\"India\"\n" +
                "     \"State\":\"Gujarat\"\n" +
                "}\n";

        try {
           JSONObject rootobject = new JSONObject(jsondata);
            Log.d("JSONQ Object",rootobject.toString());

            String Id = rootobject.getString("Id");
            Log.d("Id",Id);

           JSONObject Name = rootobject.getJSONObject("Name");
           Log.d("Name",Name.toString());

           String First_Name = Name.getString("First_name");
            Log.d("First_Name",First_Name);

            String Last_Name = Name.getString("Last_name");
            Log.d("Last_Name",Last_Name);



            String Country = rootobject.getString("Country");
            Log.d("Country",Country);

            String State = rootobject.getString("State");
            Log.d("State",State);

            fetch fet1 = new fetch();
            fet1.set_Id(Id);
            fet1.setFirst_Name(First_Name);
            fet1.setLast_Name(Last_Name);
            fet1.setCountry(Country);
            fet1.setState(State);

            Log.d("Student",fet1.toString());

            fetch []fetArr = new fetch[5];
            fetArr[0] = new fetch();


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    }
