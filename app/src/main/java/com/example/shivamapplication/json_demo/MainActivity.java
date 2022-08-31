package com.example.shivamapplication.json_demo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shivamapplication.R;
import com.example.shivamapplication.Test.Test_MainActivity;
import com.example.shivamapplication.menu.manuMainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lstview;
    String alljsondata = "[\n" +
            "{\n" +
            "   \"ID\" : \"1\",\n" +
            "   \"F_Name\" : \"Shivam\",\n" +
            "   \"M_Name\":\"A\",\n" +
            "   \"L_Name\":\"Tomar\",\n" +
            "   \"Grade\":\"A\"\n" +
            "},\n" +
            "{\n" +
            "   \"ID\" : \"2\",\n" +
            "   \"F_Name\" : \"Divyesh\",\n" +
            "   \"M_Name\":\"A\",\n" +
            "   \"L_Name\":\"Valera\",\n" +
            "   \"Grade\":\"A\"\n" +
            "},\n" +
            "{\n" +
            "   \"ID\" : \"3\",\n" +
            "   \"F_Name\" : \"Sanjay\",\n" +
            "   \"M_Name\":\"A\",\n" +
            "   \"L_Name\":\"Kumar\",\n" +
            "   \"Grade\":\"A\"\n" +
            "},\n" +
            "{\n" +
            "   \"ID\" : \"4\",\n" +
            "   \"F_Name\" : \"AJAY\",\n" +
            "   \"M_Name\":\"A\",\n" +
            "   \"L_Name\":\"Ambaliya\",\n" +
            "   \"Grade\":\"A\"\n" +
            "},\n" +
            "{\n" +
            "   \"ID\" : \"5\",\n" +
            "   \"F_Name\" : \"Satish\",\n" +
            "   \"M_Name\":\"A\",\n" +
            "   \"L_Name\":\"Shiyani\",\n" +
            "   \"Grade\":\"A\"\n" +
            "}\n" +
            "]\n" +
            "\n";
    JSONArray jsonarray;
    Studentclass stu;
    Studentclass[] Arraystudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        try {
            jsonarray = new JSONArray(alljsondata);
            Arraystudent = new Studentclass[jsonarray.length()];
            for (int i = 0; i <= jsonarray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                stu = new Studentclass();
                stu.setID(jsonObject.get("ID").toString());
                stu.setF_Name(jsonObject.get("F_Name").toString());
                stu.setM_Name(jsonObject.get("M_Name").toString());
                stu.setL_Name(jsonObject.get("L_Name").toString());
                stu.setGrade(jsonObject.get("Grade").toString());
                Arraystudent[i] = stu;

                Log.d("json", jsonarray.get(i).toString());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lstview = findViewById(R.id.lstview);

        lstview.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return Arraystudent.length;
            }

            @Override
            public Object getItem(int i) {
                return Arraystudent[i];
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.json_listview, null);
                TextView ID = linearLayout.findViewById(R.id.text1);
                ID.setText(Arraystudent[i].getID());
                TextView First_Name = linearLayout.findViewById(R.id.text2);
                First_Name.setText(Arraystudent[i].getF_Name());
                TextView Middle_Name = linearLayout.findViewById(R.id.text4);
                Middle_Name.setText(Arraystudent[i].getM_Name());
                TextView Last_Name = linearLayout.findViewById(R.id.text3);
                Last_Name.setText(Arraystudent[i].getL_Name());
                TextView Grade = linearLayout.findViewById(R.id.text5);
                Grade.setText(Arraystudent[i].getGrade());

                return linearLayout;
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.json_exit, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.jsonexit:
                //MainActivity.this.finsh();
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}

