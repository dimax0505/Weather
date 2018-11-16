package com.example.maximovd.weather;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import java.util.Objects;

public class RecyclerActivity extends AppCompatActivity {
    TextView nameOfCity;
       String [] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        data = Objects.requireNonNull(getIntent().getExtras()).getStringArray(getString(R.string.historykey));


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        TemperatureAdapter temperatureAdapter = new TemperatureAdapter(data);
        recyclerView.setAdapter(temperatureAdapter);


    }


    }
