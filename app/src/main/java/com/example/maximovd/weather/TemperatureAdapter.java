package com.example.maximovd.weather;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;




// Адаптер
public class TemperatureAdapter extends RecyclerView.Adapter<TemperatureAdapter.ViewHolder> {
    private String [] dataSource;                         // Наш источник данных


    // Передаем в конструктор источник данных
    // В нашем случае это массив, но может быть и запросом к БД
    TemperatureAdapter(String [] dataSource) {
       this.dataSource = dataSource;
    }


    // Этот класс хранит связь между данными и элементами View
    // Сложные данные могут потребовать несколько View на
    // один пункт списка.
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView temperature;
        ViewHolder(TextView v) {
            super(v);
            temperature = v;
        }
    }


    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @Override
    @NonNull
    public TemperatureAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Создаем новый элемент пользовательского интерфейса
        // Через Inflater
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder((TextView) v);
    }

    // Заменить данные в пользовательском интерфейсе
    // Вызывается менеджером
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
               // Вынести на экран используя ViewHolder
        holder.temperature.setText(dataSource[position]);

        // Отрабатывает при необходимости нарисовать карточку
        Log.d("TempAdapter", "onBindViewHolder");
    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return dataSource.length;
    }
}