package com.example.maximovd.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

//1. Создайте два экрана в вашем приложении. На первом экране создайте форму запроса для города (EditText) и кнопку отправки запроса.
// По нажатию на кнопку открывайте второй экран, передавайте в него название города с предыдущего экрана и выводите данные о погоде вместе с названием города.
//        2. Почитайте про паттерны помимо паттерна Singleton.
//        3. * Добавьте на первый экран, помимо поля для города, дополнительные параметры (влажность, скорость ветра, давление и тд) в
// виде чекбоксов или свитчей. Передавайте их значения на второй экран и выводите дополнительную информацию в зависимости от значений.
//        4. * Выясните в чем разница между явным и неявным интентами и в каких случаях используется неявный интент.

public class MainActivity extends AppCompatActivity {
    private EditText nameOfCity;
    private Button ok;
    private Switch switchAddition;
    private CheckBox checkBoxHumidity, checkBoxSpeed, checkBoxPressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setOnOkButton();
        setOnCheckBox();
    }

    private void initViews() {
        nameOfCity = findViewById(R.id.nameOfCity);
        ok = findViewById(R.id.buttonOk);
        switchAddition = findViewById(R.id.switchAddition);
        checkBoxHumidity = findViewById(R.id.humidity);
        checkBoxSpeed = findViewById(R.id.speed_of_wind);
        checkBoxPressure = findViewById(R.id.pressure);

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

    public String getNameOfCity() {
        return nameOfCity.getText().toString();
    }
}
