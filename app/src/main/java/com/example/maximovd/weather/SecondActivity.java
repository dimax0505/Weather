package com.example.maximovd.weather;


import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView name_of_city, temperature, city_not_valid, humidity, speed_of_wind, pressure;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();

        name_of_city.setText(CityFirstUpperCase());
        getWeather(name_of_city.getText().toString());

    }

    private String  CityFirstUpperCase (){
        String cityIn = getIntent().getExtras().getString("name_of_city");
      return cityIn = cityIn.substring(0,1).toUpperCase()+ cityIn.substring(1);
    }

    private void initViews(){
        name_of_city = findViewById(R.id.name_of_city);
        temperature = findViewById(R.id.temperature);
        city_not_valid = findViewById(R.id.city_not_valid);
        humidity = findViewById(R.id.humidity_second);
        speed_of_wind = findViewById(R.id.speed_of_wind_second);
        pressure = findViewById(R.id.pressure_second);
    }

    private void getWeather (String city){
        WeaterData weaterData = new WeaterData();
        if (weaterData.isValidCity(city)) {
            temperature.setText(String.format("%s%n%s %s",getString(R.string.temperature), weaterData.getTemper(city), getString(R.string.degree)));
            temperature.setVisibility(View.VISIBLE);
            if (getIntent().getExtras().getBoolean("humidity")) {
                humidity.setText(String.format("%s%n%s %s",getString(R.string.humidity), weaterData.getHumidity(city), getString(R.string.percent)));
                humidity.setVisibility(View.VISIBLE);
            }
            if (getIntent().getExtras().getBoolean("speed_of_wind")) {
                speed_of_wind.setText(String.format("%s%n%s %s",getString(R.string.speed_of_wind), weaterData.getSpeedOfWind(city), getString(R.string.speed)));
                speed_of_wind.setVisibility(View.VISIBLE);
            }
            if (getIntent().getExtras().getBoolean("pressure")) {
                pressure.setText(String.format("%s%n%s %s",getString(R.string.pressure), weaterData.getPressure(city), getString(R.string.pressure_meter)));
                pressure.setVisibility(View.VISIBLE);
            }

        }
        else city_not_valid.setVisibility(View.VISIBLE);
    }
}
