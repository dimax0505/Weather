package com.example.maximovd.weather;

import android.content.res.Resources;
import android.content.res.TypedArray;
import java.util.ArrayList;
import java.util.List;

// Построитель источника данных
 class DataSourceBuilder {
    private List<Soc> dataSource;   // Строим этот источник данных
    private Resources resources;    // Ресурсы приложения

     DataSourceBuilder(Resources resources) {
        dataSource = new ArrayList<>(6);
        this.resources = resources;
    }

    // Строим данные
     List<Soc> build() {
        // Строки описаний из ресурсов
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        // Изображения
        int[] pictures = getImageArray();
        // Заполнение источника данных
        for (int i = 0; i < descriptions.length; i++) {
            dataSource.add(new Soc(descriptions[i], pictures[i], false));
        }
        return dataSource;
    }

    // Механизм вытаскивания идентификаторов картинок (к сожалению, просто массив не работает)
    // ttps://stackoverflow.com/questions/5347107/creating-integer-array-of-resource-ids
    private int[] getImageArray(){
        TypedArray pictures = resources.obtainTypedArray(R.array.pictures);
        int length = pictures.length();
        int[] answer = new int[length];
        for(int i = 0; i < length; i++){
            answer[i] = pictures.getResourceId(i, 0);
        }
        return answer;
    }
    //получаем информацию о текущем значение чекбокса
    boolean isCheckedCHeckBox (int position) {
        return dataSource.get(position).getLike();
    }

    //меняем значение чекбокса при нажатии
    void saveChangeCheckbox (int position) {
        dataSource.get(position).changeLike();
    }
}
