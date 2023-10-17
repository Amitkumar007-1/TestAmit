package com.example2.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.widget.ArrayAdapter;

import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Adapter.Adapter;

public class HomePage extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        TextView txtUsername = (TextView) findViewById(R.id.textUsername);
        Bundle bundle = getIntent().getExtras();

        String username = bundle.getString("username");
        txtUsername.setText("Welcome " + username);
        List<String> list = Arrays.asList("Amit Kumar", "Vinay Kumar", "Shubham", "Aditya", "Deepika", "Vinay Kumar", "Shubham", "Aditya", "Vinay Kumar", "Shubham", "Aditya", "Deepika", "Vinay Kumar", "Shubham", "Aditya", "Deepika", "Deepika", "Vinay Kumar", "Shubham", "Aditya", "Deepika", "Vinay Kumar", "Shubham", "Aditya", "Deepika", "Aditya", "Aditya", "Deepika", "Vinay Kumar", "Shubham", "Aditya", "Deepika");
        Adapter adapter = new Adapter(list);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
}