package com.example.maximovd.weather;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class FourActivity extends AppCompatActivity {
    private WeatherData weatherData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_activity);
        weatherData = new WeatherData(getBaseContext(), getResources().getString(R.string.moscow));

        // получаем экземпляр FragmentTransaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        // добавляем фрагмент
        Bundle [] bundle = new Bundle[weatherData.getCity().length];
        AllCityInfo[] fragment = new AllCityInfo[weatherData.getCity().length];
        for (int i=0; i<weatherData.getCity().length; i++){
            bundle[i] = new Bundle();
            bundlePut(bundle[i],i);
            fragment[i] = new AllCityInfo();
            fragment[i].setArguments(bundle[i]);
            fragmentTransaction.add(R.id.container, fragment[i]);
        }
        fragmentTransaction.commit();
    }

    private void bundlePut(Bundle bundle, int i) {
        bundle.putString("city",weatherData.getCity()[i]);
        bundle.putString("temper",String.valueOf(weatherData.getTemperature()[i]));
        bundle.putInt("cloudy",weatherData.getCloudyAll()[i]);
    }
}
