package com.example.maximovd.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.Locale;

public class RecyclerActivity extends AppCompatActivity {
    Button buttonAddImage;
   // private String[] data = {"One", "Two", "Three", "Four"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);



        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        buttonAddImage = findViewById(R.id.button_add_image);

        // Эта установка служит для повышения производительности системы
        recyclerView.setHasFixedSize(true);

        // Будем работать со встроенным менеджером
        /*LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                false);*/
        /*GridLayoutManager manager = new GridLayoutManager(this, 3,
                LinearLayoutManager.HORIZONTAL, false);*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Установим адаптер
        final DataSourceBuilder builder = new DataSourceBuilder(getResources());
        final SocnetAdapter adapter = new SocnetAdapter(builder.build());
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new SocnetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerActivity.this,
                        String.format(Locale.getDefault(), "Позиция - %d", position),
                        Toast.LENGTH_SHORT).show();
            }
        });
        //адаптер для обработки нажатий на чекбокс - запоминает значение и выводит тост с сообщением о текущем значении
        adapter.setOnCheckboxCheckedListener(new SocnetAdapter.OnCheckboxCheckedListener() {
            @Override
            public void onCheckboxChange(CompoundButton button, int position) {
                builder.saveChangeCheckbox(position);
                Toast.makeText(RecyclerActivity.this,
                        String.format(Locale.getDefault(), "Позиция - %d установлена - %b", position, builder.isCheckedCheckBox(position)),
                        Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnButtonRemoveClickListener(new SocnetAdapter.OnButtonRemoveLisener() {
            @Override
            public void onButtonRemoveListener(View view, int position) {
                adapter.removeElement(position);
            }
        });
        buttonAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (builder.getFreeElement()==null){
                    Toast.makeText(RecyclerActivity.this,
                            String.format(Locale.getDefault(), "All elemens in List"),
                            Toast.LENGTH_SHORT).show();
                }
               else adapter.addElement(builder.getFreeElement());
            }
        });

    }

}
