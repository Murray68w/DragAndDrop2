package com.perfpr.listdragdrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView employee1;
    String[] arrayTimes;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        employee1 = (ListView)findViewById(R.id.e1ListView);
         arrayTimes = getResources().getStringArray(R.array.time);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayTimes);
        employee1.setAdapter(adapter);


    }
}
