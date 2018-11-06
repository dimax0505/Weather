package com.example.maximovd.weather;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

//В погодном приложении создайте заготовку на основе приложения CityInfo.
//Подготовьте фрагмент с выводом температурных характеристик вместо герба: чтобы выбрав город, можно было посмотреть температуру в нем.

public class MainActivity extends AppCompatActivity {
    private EditText nameOfCity;
    private Button ok, toListOfCity, infoButton;
    private Switch switchAddition;
    private CheckBox checkBoxHumidity, checkBoxSpeed, checkBoxPressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setOnOkButton();
        setOnCheckBox();
        setOnToListOfCityButton();
        setOnInfoButton();
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

    private void setOnInfoButton(){
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.InfoBoxName)
                        .setMessage("Максимов Дмитрий Евгеньевич")
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
