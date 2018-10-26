package com.example.maximovd.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

//1. Создайте в погодном приложении подходящие стили и примените их в качестве темы для всего приложения
// (например, размер шрифта и его цвет для всех текстовых вьюх вынесите в стиль)
//        2. Создайте ресурсы для своего приложения ‒ строки, картинки.
// Можно скачать из интернета, но только не забывайте про права пользования. Берите такие картинки, которые можно использовать.
// Все строки, используемые в макетах, сделайте ресурсами. Переведите на английский язык и подключите вторым строковым ресурсом к приложению.
//        3. *Выведите картинку в основной макет (лэайаут, который показыватся при старте и относится к первой активити)

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
