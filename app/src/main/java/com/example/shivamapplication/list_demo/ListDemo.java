package com.example.shivamapplication.list_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shivamapplication.R;
import com.example.shivamapplication.registration_demo.Registration;
import com.example.shivamapplication.seekbar_demo.SeekBar_Demo1;

public class ListDemo extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lstDemos;

    String[] demoNames = {"Registration Demo", "Seekbar Demo"};
    String[] demoDescription = {"A demonstration of different controls in context of registration", "A color mixer created using RGB Seek bars"};
    Class<?> []nextClass = {Registration.class , SeekBar_Demo1.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_demo);

        lstDemos = findViewById(R.id.lstDemos);

        BaseAdapter myAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return demoNames.length;
            }
            @Override
            public Object getItem(int position) {
                return demoNames[position];
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                LinearLayout llItem = (LinearLayout) getLayoutInflater().inflate(R.layout.layout_item_list_demos, null);

                TextView tvDemoName = llItem.findViewById(R.id.tvDemoName);
                tvDemoName.setText(demoNames[position]);

                TextView tvDemoDecription =llItem.findViewById(R.id.tvDemoDecription);
                tvDemoDecription.setText(demoDescription[position]);

                return llItem;
            }
        };

        lstDemos.setAdapter(myAdapter);

        lstDemos.setOnItemClickListener(ListDemo.this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // String msg = parent.getItemAtPosition(position).toString();
        // Toast.makeText(ListDemo.this,msg,Toast.LENGTH_SHORT).show();

       // Class<?> nextClass = Registration.class;
        Intent next = new Intent(ListDemo.this, nextClass[position]);
        ListDemo.this.startActivity(next);
    }
}