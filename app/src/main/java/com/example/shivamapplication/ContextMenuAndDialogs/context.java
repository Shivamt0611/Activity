package com.example.shivamapplication.ContextMenuAndDialogs;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shivamapplication.R;

import java.util.Locale;

public class context extends AppCompatActivity {
    TextView tvMessage;
    ListView lstValues;

    String [] values = {"sem 1", "sem 2","sem 3","SEM 4"};
    private String itemText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);

        tvMessage = findViewById(R.id.tvMessage);
        registerForContextMenu(tvMessage);

        lstValues = findViewById(R.id.lstValues);
        registerForContextMenu(lstValues);


        lstValues.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return values.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }



            @Override
            public View getView(int position, View convertView, ViewGroup viewGroup) {

                 LinearLayout ll = (LinearLayout) getLayoutInflater().inflate(R.layout.item_list, null);

                 TextView tvItem = ll.findViewById(R.id.tvItemOfList);
                 tvItem.setText(values[position]);

                return ll;
            }
        });

        lstValues.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               itemText = values[position];
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId()){
            case R.id.tvMessage:
                getMenuInflater().inflate(R.menu.menu_for_textview,menu);
                break;

            case R.id.lstValues:
                getMenuInflater().inflate(R.menu.menu_for_listview,menu);
                break;
        }


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.cmiUpperCase:
                tvMessage.setText(tvMessage.getText().toString().toUpperCase());
                break;
            case R.id.cmiLowerCase:
                tvMessage.setText(tvMessage.getText().toString().toLowerCase());
                break;
            case R.id.cmiReverse:
               
                Toast.makeText(context.this,"Reverse Clicked"+itemText,Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}