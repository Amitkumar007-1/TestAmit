package com.example2.writerpad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import Adapter.Adapter;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private ImageView navBackIcon;
private TextView weighingMachineName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Setting Weighing Machine Name
        String weighingMachine=getIntent().getStringExtra("weighingMachineName");
        weighingMachineName=findViewById(R.id.ntcText);
        weighingMachineName.setText(weighingMachine);
       recyclerView= findViewById(R.id.recyclerView);


       //Creating List of ItemDetails Object
        List<ItemDetails> listOfItemDetails= Arrays.asList(new ItemDetails("TMZ","100","B14","170","crate"),new ItemDetails("BMZ","150","DD2","190","Bags"),new ItemDetails("NAS","200","M21","40","Box"),new ItemDetails("BYR","201","NJW","90","Box"),new ItemDetails("MNX","200","N20","160","Bags"),new ItemDetails("KJH","98","R20","250","Bags"),new ItemDetails("MBZ","130","J10","122","crate"),new ItemDetails("NUY","122","N23","200","Box"),new ItemDetails("MQW","250","BH9","150","crate"));
        Adapter adapter=new Adapter(this,listOfItemDetails);
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
       recyclerView.setAdapter(adapter);
        navBackIcon=findViewById(R.id.navbarArrow);
        navBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


}