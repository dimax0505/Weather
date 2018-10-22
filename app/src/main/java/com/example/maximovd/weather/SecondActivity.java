package com.example.maximovd.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView name_of_city;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();

        name_of_city.setText(getIntent().getExtras().getString("name_of_city"));

    }

    private void initViews(){
        name_of_city = findViewById(R.id.name_of_city);
    }

//    private void getWeather (String city){
//    }
}
