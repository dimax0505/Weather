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
    private EditText name_of_city;
    private Button ok;
    private Switch switch_addition;
    private CheckBox checkBox_Humidity, checkBox_Speed, checkBox_Pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setOnOkButton();
        setOnCheckBox();


    }

    private void initViews() {
       name_of_city = findViewById(R.id.name_of_city);
       ok = findViewById(R.id.batton_Ok);
       switch_addition = findViewById(R.id.switch_addition);
       checkBox_Humidity = findViewById(R.id.humidity);
       checkBox_Speed = findViewById(R.id.speed_of_wind);
        checkBox_Pressure = findViewById(R.id.pressure);

    }

    private void setOnOkButton (){
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String city = name_of_city.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name_of_city", city);
                intent.putExtra("humidity", checkBox_Humidity.isChecked());
                intent.putExtra("speed_of_wind", checkBox_Speed.isChecked());
                intent.putExtra("pressure", checkBox_Pressure.isChecked());
                startActivity(intent);

            }
        });
    }

    private void setOnCheckBox() {
        switch_addition.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switch_addition.isChecked()){
                    checkBox_Humidity.setVisibility(View.VISIBLE);
                    checkBox_Speed.setVisibility(View.VISIBLE);
                    checkBox_Pressure.setVisibility(View.VISIBLE);
                }
                else {
                    checkBox_Humidity.setVisibility(View.INVISIBLE);
                    checkBox_Speed.setVisibility(View.INVISIBLE);
                    checkBox_Pressure.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public String getName_of_city() {
        return name_of_city.getText().toString();
    }
}
