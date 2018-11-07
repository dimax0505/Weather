package com.example.maximovd.weather;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Objects;

import static com.example.maximovd.weather.WeatherData.*;

public class SecondActivity extends AppCompatActivity {
    private TextView nameOfCity, temperature, cityNotValid, humidity, speedOfWind, pressure;
    private WeatherData weatherData;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        nameOfCity.setText(CityFirstUpperCase());
        weatherData = getInstance(this, nameOfCity.getText().toString());
                //new WeatherData(this, nameOfCity.getText().toString());
        getWeather();

    }

    private String CityFirstUpperCase() {
        String cityIn = Objects.requireNonNull(getIntent().getExtras()).getString(getString(R.string.nameOfCity));
        return Objects.requireNonNull(cityIn).substring(0, 1).toUpperCase() + cityIn.substring(1);
    }

    private void initViews() {
        nameOfCity = findViewById(R.id.nameOfCity);
        temperature = findViewById(R.id.temperature);
        cityNotValid = findViewById(R.id.cityNotValid);
        humidity = findViewById(R.id.humiditySecond);
        speedOfWind = findViewById(R.id.speedOfWindSecond);
        pressure = findViewById(R.id.pressureSecond);
        layout = findViewById(R.id.second_activity);
    }

    private void getWeather() {
        if (weatherData.isValidCity()) {
            temperature.setText(String.format("%s%n%s %s", getString(R.string.temperature), weatherData.getTemper(), getString(R.string.degree)));
            temperature.setVisibility(View.VISIBLE);
            layout.setBackgroundResource(weatherData.getCloudy());
            if (Objects.requireNonNull(getIntent().getExtras()).getBoolean(getString(R.string.humidity))) {
                humidity.setText(String.format("%s%n%s %s", getString(R.string.humidity), weatherData.getHumidity(), getString(R.string.percent)));
                humidity.setVisibility(View.VISIBLE);
            }
            if (getIntent().getExtras().getBoolean(getString(R.string.speedOfWind))) {
                speedOfWind.setText(String.format("%s%n%s %s", getString(R.string.speedOfWind), weatherData.getSpeedOfWind(), getString(R.string.speed)));
                speedOfWind.setVisibility(View.VISIBLE);
            }
            if (getIntent().getExtras().getBoolean(getString(R.string.pressure))) {
                pressure.setText(String.format("%s%n%s %s", getString(R.string.pressure), weatherData.getPressure(), getString(R.string.pressureMeter)));
                pressure.setVisibility(View.VISIBLE);
            }
        } else cityNotValid.setVisibility(View.VISIBLE);
    }
}
