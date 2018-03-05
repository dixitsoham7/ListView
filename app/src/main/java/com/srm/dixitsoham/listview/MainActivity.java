package com.srm.dixitsoham.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private Button asc,des;
    private static ArrayList<String> months =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.lv);
        asc=findViewById(R.id.asc);
        des=findViewById(R.id.des);

        asc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ascending();
            }
        });

        des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descending();
            }
        });

        this.data();
    }

    private void data()
    {
        months.clear();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        //predefined custom layout android.R.layout.simple_list_item_1 has been used here. Predefined layouts are installed along with SDK.
        //if we dont want to use custom layouts then we can actually create them and use over here, by giving ref R.layout.xyz

        list.setAdapter(new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,months));
    }


    private void descending() {
        Collections.reverse(months);
        list.setAdapter(new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,months));

    }

    private void ascending() {
        Collections.sort(months);
        list.setAdapter(new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,months));
    }
}
