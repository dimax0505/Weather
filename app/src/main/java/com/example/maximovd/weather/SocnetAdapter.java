package com.example.maximovd.weather;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.List;

// Адаптер
public class SocnetAdapter extends RecyclerView.Adapter<SocnetAdapter.ViewHolder> {
    private List<Soc> dataSource;                         // Наш источник данных
    private OnItemClickListener itemClickListener;        // Слушатель, будет устанавливаться извне
    private OnCheckboxCheckedListener onCheckedChangeListener;
    private OnButtonRemoveLisener onButtonRemoveLisener;

    // Передаем в конструктор источник данных
    // В нашем случае это массив, но может быть и запросом к БД
    SocnetAdapter(List<Soc> dataSource) {
        this.dataSource = dataSource;
    }

    public void addElement(Soc soc) {
        dataSource.add(soc);
        notifyItemInserted(dataSource.size() - 1);
    }

    public void changeElement(Soc soc, int position) {
        if(dataSource.size() > position) {
            dataSource.set(position, soc);
            notifyItemChanged(position);
        }
    }

    public void removeElement(int position) {
        if(dataSource.size() > position) {
            dataSource.remove(position);
            notifyItemRemoved(position);
        }
    }

    // Этот класс хранит связь между данными и элементами View
    // Сложные данные могут потребовать несколько View на
    // один пункт списка.
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView description;
        public ImageView picture;
        public CheckBox like;
        public Button button;

        ViewHolder(View v) {
            super(v);

            description = v.findViewById(R.id.description);
            picture = v.findViewById(R.id.picture);
            like = v.findViewById(R.id.like);
            button = v.findViewById(R.id.button_remove);

            // Обработчик нажатий на этом ViewHolder
            picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });
            like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    onCheckedChangeListener.onCheckboxChange(buttonView, getAdapterPosition());
                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onButtonRemoveLisener != null) {
                        onButtonRemoveLisener.onButtonRemoveListener(v, getAdapterPosition());
                    }
                }
            });

        }
    }
    //Интерфейс для обработки нажатия кнопки удаления
    public interface OnButtonRemoveLisener {
        void onButtonRemoveListener(View view, int position);
    }
    //Сеттер для слушателя нажатий на кнопку
    void setOnButtonRemoveClickListener (OnButtonRemoveLisener onButtonRemoveClickListener) {
        this.onButtonRemoveLisener = onButtonRemoveClickListener;
    }
    //Интерфейс для обработки изменения значения чекбокса
    public interface OnCheckboxCheckedListener {
        void onCheckboxChange(CompoundButton button, int position);
    }
    //сеттер слушателя нажатий на чекбокс
    void setOnCheckboxCheckedListener(OnCheckboxCheckedListener onCheckedChangeListener) {
    this.onCheckedChangeListener = onCheckedChangeListener;
    }


    // Интерфейс для обработки нажатий как в ListView
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    // Сеттер слушателя нажатий
    void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Создаем новый элемент пользовательского интерфейса
        // Через Inflater
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_card_item, parent, false);

        return new ViewHolder(v);
    }

    // Заменить данные в пользовательском интерфейсе
    // Вызывается менеджером
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Получить элемент из источника данных (БД, интернет...)
        Soc item = dataSource.get(position);
        // Вынести на экран используя ViewHolder
        holder.description.setText(item.getDescription());
        holder.picture.setImageResource(item.getPicture());
        holder.like.setChecked(item.getLike());

        // Отрабатывает при необходимости нарисовать карточку
        Log.d("SocnetAdapter", "onBindViewHolder");
    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}

