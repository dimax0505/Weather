package com.example.maximovd.weather;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.Objects;

import static com.example.maximovd.weather.WeatherData.getInstance;

public class FragmentListDropDown extends Fragment {
    private int currentPosition;
    private WeatherData weatherData;
    private Spinner spinner;
    private ListView listOfCity;
    private String city;
    private String [] cities;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_drop_down, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            if (spinner != null) {
                createAdapterList();
                createDropDownList(currentPosition);
                spinner.setSelection(currentPosition);
                showTemperature();
            }
            createAdapterList();
            createDropDownList(currentPosition);
        } else {

            if (listOfCity != null) {
                createAdapterListLand();
                creteListView(currentPosition);
                listOfCity.setItemChecked(currentPosition, true);
                showTemperature();
            } else {
                createAdapterListLand();
                creteListView(currentPosition);
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Intent intent = new Intent();
        intent.putExtra("position", currentPosition);
        super.onSaveInstanceState(outState);
    }

    private void createAdapterListLand() {
        listOfCity = (Objects.requireNonNull(getView()).findViewById(R.id.list_of_city));
        cities = getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_activated_1, cities);
        listOfCity.setAdapter(adapter);
        listOfCity.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    private void creteListView(int position) {

        listOfCity.setItemChecked(position, true);
        city = cities[currentPosition];
        showTemperature();
        listOfCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentPosition = position;
                city = cities[currentPosition];
                showTemperature();
            }
        });

    }

    private void createAdapterList() {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.cities,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }

    private void createDropDownList(int position) {
        spinner = Objects.requireNonNull(getView()).findViewById(R.id.spinner);
        spinner.setSelection(position);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                currentPosition = selectedItemPosition;
                city = spinner.getSelectedItem().toString();
                showTemperature();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void showTemperature() {
        weatherData = getInstance(this.getContext(), city);
        (Objects.requireNonNull(getActivity()).findViewById(R.id.third_activity)).setBackgroundResource(weatherData.getCloudy());
        assert getFragmentManager() != null;
        FragmentInfo detail = (FragmentInfo) getFragmentManager().findFragmentById(R.id.fragment_info);
        assert detail != null;
        detail.setText(getWeather());
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_info, detail);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    private String getWeather() {
        return String.format("%s%n%s %s", getString(R.string.temperature), weatherData.getTemper(), getString(R.string.degree));
    }
}
