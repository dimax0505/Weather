package com.example.maximovd.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//1. Создайте два экрана в вашем приложении. На первом экране создайте форму запроса для города (EditText) и кнопку отправки запроса.
// По нажатию на кнопку открывайте второй экран, передавайте в него название города с предыдущего экрана и выводите данные о погоде вместе с названием города.
//        2. Почитайте про паттерны помимо паттерна Singleton.
//        3. * Добавьте на первый экран, помимо поля для города, дополнительные параметры (влажность, скорость ветра, давление и тд) в
// виде чекбоксов или свитчей. Передавайте их значения на второй экран и выводите дополнительную информацию в зависимости от значений.
//        4. * Выясните в чем разница между явным и неявным интентами и в каких случаях используется неявный интент.

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
