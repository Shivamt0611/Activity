package com.example.shivamapplication.JsonActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shivamapplication.R;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonActivity extends AppCompatActivity {
    ListView jsonListview;
    String name,year,Corigin;
    String weight;
    JSONArray jArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_json2);

        jsonListview = findViewById(R.id.JsonListView);
        ArrayList<String> arrName = new ArrayList<>();
        ArrayList<String> arrYear = new ArrayList<>();
        ArrayList<String> arrOrigin = new ArrayList<>();
        ArrayList<Integer> arrWeight = new ArrayList<>();


        try {
            jArray = new JSONArray(loadJsonFile());
            for (int i=0;i < jArray.length(); ++i){
                name = jArray.getJSONObject(i).getString("Name");
                weight = jArray.getJSONObject(i).getString("Weight_in_lbs");
                year = jArray.getJSONObject(i).getString("Year");
                Corigin = jArray.getJSONObject(i).getString("Origin");

                //CarDetails carDetails = new CarDetails(name,year,Corigin,weight);
                //arrName.add(carDetails.getCarName());
                //arrYear.add(carDetails.getYear());
                //arrOrigin.add(carDetails.getOrigin());
                //arrOrigin.add(carDetails.getMiles_per_Gallon());
                //System.out.println(miles);
            }
            BaseAdapter adapter = new BaseAdapter() {
                @Override
                public int getCount() {
                    return arrName.size();

                }

                @Override
                public Object getItem(int i) {
                    return arrName.get(i);
                }

                @Override
                public long getItemId(int i) {
                    return 0;
                }

                @Override
                public View getView(int i, View view, ViewGroup viewGroup) {
                    LinearLayout jsonListView = (LinearLayout) getLayoutInflater().inflate(R.layout.jsonlist,null);
                    TextView cname = jsonListView.findViewById(R.id.carName);
                    cname.setText(arrName.get(i));
                    TextView cYear = jsonListView.findViewById(R.id.year);
                    cYear.setText(arrYear.get(i));
                    TextView cOrigin = jsonListView.findViewById(R.id.origin);
                    cOrigin.setText(arrOrigin.get(i));
                    TextView cWeight = jsonListView.findViewById(R.id.miles);
                    cWeight.setText(String.valueOf(arrWeight.get(i)));
                    return jsonListView;
                }
            };
            jsonListview.setAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String loadJsonFile() {
        String json = null;

        try {
            InputStream stream = getAssets().open("car.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json = new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}



