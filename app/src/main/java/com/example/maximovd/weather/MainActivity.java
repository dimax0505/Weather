package com.example.maximovd.weather;

//        1. Запишите последовательности вызова методов при различных действиях пользователей: при запуске приложения, при переворачивании устройства, при нажатии кнопки «Домой»…
//        2. В activity погодного приложения создайте пользовательский интерфейс в виде вывода на экран погодных значений - просто захаркодить нужно какую-то погоду. Например, "Москва, 21 градус, ясно".
//        3. Запустите интерфейс на эмуляторе.
//        4. *Внесите изменения в приложение LifeCycle, чтобы сообщения о жизненном цикле выводились не только всплывающими сообщениями, но и в logcat.


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
