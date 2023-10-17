package com.example2.writerpad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example2.writerpad.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Arrays;
import java.util.List;

import Adapter.SelectDeviceAdapter;

public class SelectDeviceActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_device);
        List<WeighingMachineDetails> listOfWeighingMachineDetails = Arrays.asList(new WeighingMachineDetails("NTC-1", "Available to connect"), new WeighingMachineDetails("NTC-2", "Available to connect"), new WeighingMachineDetails("NTC-3", "Conneced to UserName"), new WeighingMachineDetails("NTC-4", "Available to Connect"), new WeighingMachineDetails("NTC-5", "Connected to UserName"), new WeighingMachineDetails("NTC-6", "Available to Connect"), new WeighingMachineDetails("NTC-7", "Available to Connect"), new WeighingMachineDetails("NTC-8", "Available to Connect"), new WeighingMachineDetails("NTC-9", "Available to Connect"));
        recyclerView = findViewById(R.id.selectDeviceRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        SelectDeviceAdapter selectDeviceAdapter = new SelectDeviceAdapter(this, listOfWeighingMachineDetails);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(selectDeviceAdapter);
        bottomNavigationView = findViewById(R.id.bottomNavigationView2);
        bottomNavigationView.getMenu().getItem(0).setCheckable(false);
        onClickBottomNavBar();

    }


    private void onClickBottomNavBar() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.refreshicon:

                        break;
                    case R.id.logsicon:

                        openLogs();

                        break;
                    case R.id.sheet_transfer:
                        break;
                    case R.id.connecticon:
                        break;
                    default:
                        break;

                }
                return true;

            }
        });
    }

    private void openLogs() {
        Intent intent = new Intent(this, Log_Activity.class);
        startActivity(intent);

    }


}