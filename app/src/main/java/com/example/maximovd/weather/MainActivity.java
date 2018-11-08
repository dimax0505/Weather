package com.example.maximovd.weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Источник данных
    private String[] cities = {"Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Это список
        ListView listView = findViewById(R.id.listCities);

        // Создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cities);

        // Устанавливаем адаптер в список
        listView.setAdapter(new ListViewAdapter());

        findViewById(R.id.toRecyclerBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });

        // Обработка нажатий
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MainActivity.this,
                        String.format("Выбран город - %s", ((TextView)v).getText()),
                        Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}

