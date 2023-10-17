package com.example2.writerpad;

import static java.util.Objects.nonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Adapter.LogAdapter;
import Loader.Loader;
import Models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Log_Activity extends AppCompatActivity {
    private String url = "https://jsonplaceholder.typicode.com/";
    private ProgressDialog loadingProgressDialog;
    private List<User> list_of_users;
    private RecyclerView recyclerView;
    private LogAdapter logAdapter;
    private ImageView navbarArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        retrofitMethodology();
        recyclerView = findViewById(R.id.log_recyclerView);
        navbarArrow=  findViewById(R.id.navbarArrow);
        navbarArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void showLoader() {
        loadingProgressDialog = new Loader(this);
        loadingProgressDialog.show();
    }

//    public void hideLoader() {
//        if(nonNull(loadingProgressDialog) )
//        loadingProgressDialog.hide();
//        loadingProgressDialog = null;
//    }

    public void retrofitMethodology() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi myapi = retrofit.create(MyApi.class);
        Call<List<User>> call = myapi.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {


                list_of_users = response.body();
                logAdapter = new LogAdapter(list_of_users);
                recyclerView.setLayoutManager(new LinearLayoutManager(Log_Activity.this));
                recyclerView.setAdapter(logAdapter);

//                                showLoader();
//                Timer timer = new Timer();
//                timer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        hideLoader();
//
//
//                    }
//                }, 3000);
//                list_of_users = response.body();
//       Log.i("RESP",response.body().toString());


            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}