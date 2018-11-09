package com.example.maximovd.weather;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    // Создаем переменные необходимые для работы приложения
    private EditText nameOfCity;
    private Button ok, toListOfCity, infoButton, historyButton;
    private Switch switchAddition;
    private CheckBox checkBoxHumidity, checkBoxSpeed, checkBoxPressure;
    private String information;
    private WeatherData weatherData;

    // Здесь собираем методы которые выполняются при создании активности
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews(); // инициализируем переменные
        setOnOkButton(); //обработка нажатия на кнопку ОК
        setOnCheckBox(); //обработка работы чекбокса
        setOnToListOfCityButton(); //обработка нажатия на кнопку - "к списку городов"
        setOnInfoButton();//обработка нажатия на кнопку инфо - выводится информация об авторе
        setOnHistoryButton();
    }

    private void initViews() {
        nameOfCity = findViewById(R.id.nameOfCity);
        ok = findViewById(R.id.buttonOk);
        switchAddition = findViewById(R.id.switchAddition);
        checkBoxHumidity = findViewById(R.id.humidity);
        checkBoxSpeed = findViewById(R.id.speed_of_wind);
        checkBoxPressure = findViewById(R.id.pressure);
        toListOfCity = findViewById(R.id.to_activity3);
        infoButton = findViewById(R.id.info_about_author);
        information = getText(R.string.information).toString();
        historyButton = findViewById(R.id.buttonHistory);
    }

    private void setOnOkButton() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = getNameOfCity();
                if (city.isEmpty()) city = getString(R.string.inputOfEmpty);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(getString(R.string.nameOfCity), city);
                intent.putExtra(getString(R.string.humidity), checkBoxHumidity.isChecked());
                intent.putExtra(getString(R.string.speedOfWind), checkBoxSpeed.isChecked());
                intent.putExtra(getString(R.string.pressure), checkBoxPressure.isChecked());
                startActivity(intent);

            }
        });
    }
    private void setOnHistoryButton() {
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = getNameOfCity();
                if (city.isEmpty()) city = getString(R.string.inputOfEmpty);
                weatherData = new WeatherData(MainActivity.this, city);
                if (weatherData.isValidCity()){
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                intent.putExtra(getString(R.string.historykey), weatherData.getHistory());
                startActivity(intent);}
                else {
                    Toast.makeText(MainActivity.this,
                            R.string.cityOutOfDatabase,
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void setOnToListOfCityButton() {
        toListOfCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setOnCheckBox() {
        switchAddition.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchAddition.isChecked()) {
                    checkBoxHumidity.setVisibility(View.VISIBLE);
                    checkBoxSpeed.setVisibility(View.VISIBLE);
                    checkBoxPressure.setVisibility(View.VISIBLE);
                } else {
                    checkBoxHumidity.setVisibility(View.INVISIBLE);
                    checkBoxSpeed.setVisibility(View.INVISIBLE);
                    checkBoxPressure.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void setOnInfoButton() {
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.InfoBoxName)
                        .setMessage(information)
                        .setIcon(R.drawable.icons8_weather)
                        .setCancelable(false)
                        .setNegativeButton(R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public String getNameOfCity() {
        return nameOfCity.getText().toString();
    }

}
