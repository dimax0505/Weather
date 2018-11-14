package com.example.maximovd.weather;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private int secondActivityResultEvent = 9876;
    private TextView content;
    private int[] pictureID = {R.drawable.nature1, R.drawable.nature2, R.drawable.nature3, R.drawable.nature4};

    private final static String TEXT_CONTENT = "В 2014 году Google представила новый подход к дизайну приложений. " +
            "Это была попытка сделать единообразный интерфейс для всех приложений Google и Android. " +
            "Интерфейс, который выглядел бы одинаково, независимо от того, где работает приложение: " +
            "на телефоне, планшете или компьютере. Материальный дизайн основан на образе бумаги на экране. " +
            "Ее называют квантовой или цифровой. Бумага тонкая, плоская, но расположена в трехмерном пространстве, " +
            "имеет тени и двигается. В таком образе предстают объекты интерфейса, " +
            "а анимация показывает пользователю, что происходит. Чрезмерная анимация не нужна, " +
            "Потому что никому не интересно ждать, пока окно с сообщением налетается по экрану.\n";

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.main_backdrop);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        CardRecycleAdapter cardRecycleAdapter = new CardRecycleAdapter(pictureID);
        recyclerView.setAdapter(cardRecycleAdapter);

        content = findViewById(R.id.content);
        content.setText(TEXT_CONTENT);

        FloatingActionButton fab = findViewById(R.id.fab);
        // Обработка нажатия на плавающую кнопку
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Здесь вылетит Snackbar
                Snackbar.make(view, "Вы нажали на плавающую кнопку", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Размещение меню в action bar
        // если он присутствует.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Управление касаниями на action bar.
        // Action bar будет автоматически управлять нажатиями на Home/Up кнопку
        // Вы это можете указать в родительской activity в файле манифеста.
        int id = item.getItemId();
        switch (id) {
            case R.id.to_second_activity:
                Snackbar.make(toolbar, R.string.to_second_activity_question, Snackbar.LENGTH_LONG)
                        .setAction("Вторая активити", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity.this,
                                        InputActivity.class);
                                startActivityForResult(intent, secondActivityResultEvent);
                            }
                        }).show();
                return true;
            case R.id.action_preferences:
                Snackbar.make(toolbar, "Вы выбрали пункт меню настройки", Snackbar.LENGTH_LONG)
                        .show();
                return true;
            case R.id.action_params:
                Snackbar.make(toolbar, "Вы выбрали пункт меню параметры", Snackbar.LENGTH_LONG)
                        .show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == secondActivityResultEvent && resultCode == RESULT_OK) {
            assert data != null;
            String text = data.getStringExtra(InputActivity.dataKey);
            content.setText(text);
        }
    }
}

